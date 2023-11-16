package com.example.financial_manager;

import com.example.financial_manager.components.ExpenseManagerImpl;
import com.example.financial_manager.controllers.ExpenseController;
import com.example.financial_manager.dto.ExpenseDto;
import com.example.financial_manager.securityConfig.SecurityConfig;
import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.Imported;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithAnonymousUser;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static net.bytebuddy.matcher.ElementMatchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


//@RunWith(SpringRunner.class)
@WebMvcTest(ExpenseController.class)
@Import(SecurityConfig.class)
public class ExpenseControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    ExpenseManagerImpl expenseManager;
    @Autowired
    private WebApplicationContext context;
    @BeforeEach
    public void setup() {
        mockMvc = MockMvcBuilders
                .webAppContextSetup(context)
                .apply(springSecurity())
                .build();
       }

    @Test
    @WithAnonymousUser
    public void cannotGetCustomerIfNotAuthorized() throws Exception {
        mockMvc.perform(get("/expenses/{id}", 1L))
                .andExpect(status().isUnauthorized());
    }

    @Test
    @WithMockUser(username = "user", password = "password", roles = "USER")
    public void cannotCreateCustomerIfNotAnAdmin() throws Exception {
        mockMvc.perform(post("/expenses/createExpanse")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\n" +
                                "  \"purpose\": \"Buying stocks \",\n" +
                                "  \"amount\": 1000.01\n" +
                                "}")
                        .with(csrf())
                )
                .andExpect(status().isForbidden());
    }


    @Test
    @WithMockUser(username = "user", password = "password", roles = "USER")
    public void testGetExpanse() throws Exception {
        mockMvc.perform(get("/expenses/{id}", 1L)
                        .with(csrf())
                        //.with(user("admin").password("1111").roles("ADMIN"))
                        .contentType(MediaType.APPLICATION_JSON)
                        .characterEncoding("utf-8"))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    public void deleteExpense() throws Exception {
        mockMvc.perform(get("/expenses/{id}", 2L)
                        .with(csrf())
                        .with(user("admin").password("1111").roles("ADMIN"))
                        .contentType(MediaType.APPLICATION_JSON)
                        .characterEncoding("utf-8"))
                .andExpect(status().isOk());
    }

}
