package com.example.financial_manager;

import com.example.financial_manager.components.ExpenseManagerImpl;
import com.example.financial_manager.controllers.ExpenseController;
import com.example.financial_manager.dto.ExpenseDto;
import com.example.financial_manager.mappers.ExpenseMapper;
import com.example.financial_manager.securityConfig.SecurityConfig;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithAnonymousUser;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


//@RunWith(SpringRunner.class)
@WebMvcTest(ExpenseController.class)
@Import(SecurityConfig.class)
public class ExpenseControllerTest {

    @Autowired
    MockMvc mockMvc;
    ObjectMapper objectMapper = new ObjectMapper();
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
        ExpenseDto expenseDto = new ExpenseDto(null, "Products", 1000.9);
        when(expenseManager.addExpense(any())).thenReturn(expenseDto);
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
    @WithMockUser(username = "admin", password = "1111", roles = "ADMIN")
    public void createExpense() throws Exception {
        ExpenseDto expenseDto = new ExpenseDto(null, "New Expense", 150);
        ExpenseDto createdExpense = new ExpenseDto(3L, "New Expense", 150);

        when(expenseManager.addExpense(any())).thenReturn(createdExpense);

        mockMvc.perform(post("/expenses/createExpanse")
                        .with(csrf())
                        .contentType(MediaType.APPLICATION_JSON)
                        .characterEncoding("utf-8")
                        .content(objectMapper.writeValueAsString(expenseDto)))
                .andExpect(status().isCreated())
                .andExpect(content().json(objectMapper.writeValueAsString(createdExpense)));
    }

    @Test
    @WithMockUser(username = "admin", password = "1111", roles = "ADMIN")
    public void updateExpanse() throws Exception {
        ExpenseDto updatedExpense = new ExpenseDto(1L, "New Salary", 2000);

        when(expenseManager.updateExpense(eq(1L), any())).thenReturn(updatedExpense);

        mockMvc.perform(put("/expenses/1")
                        .with(csrf())
                        .contentType(MediaType.APPLICATION_JSON)
                        .characterEncoding("utf-8")
                        .content(objectMapper.writeValueAsString(updatedExpense)))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(updatedExpense)));
    }

    @Test
    @WithMockUser(username = "admin", password = "1111", roles = "ADMIN")
    public void deleteExpense() throws Exception {
        mockMvc.perform(delete("/expenses/{id}", 2L)
                        .with(csrf())
                        .contentType(MediaType.APPLICATION_JSON)
                        .characterEncoding("utf-8"))
                .andExpect(status().isNoContent());
    }

}
