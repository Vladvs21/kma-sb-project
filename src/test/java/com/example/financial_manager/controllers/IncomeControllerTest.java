package com.example.financial_manager.controllers;

import com.example.financial_manager.components.IncomeManagerImpl;
import com.example.financial_manager.dto.IncomeDto;
import com.example.financial_manager.securityConfig.SecurityConfig;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.mockito.Mockito.*;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(IncomeController.class)
@Import(SecurityConfig.class)
public class IncomeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    private ObjectMapper objectMapper = new ObjectMapper();
    @MockBean
    private IncomeManagerImpl incomeManager;

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
    @WithMockUser(username = "user", password = "password", roles = "USER")
    public void getAllIncomes() throws Exception {
        mockMvc.perform(get("/user/1/incomes")
                        .with(csrf())
                        .contentType(MediaType.APPLICATION_JSON)
                        .characterEncoding("utf-8"))
                .andExpect(status().isOk());
    }

    @Test
    @WithMockUser(username = "user", password = "password", roles = "USER")
    public void getIncomeById() throws Exception {
        mockMvc.perform(get("/user/1/incomes/1")
                        .with(csrf())
                        .contentType(MediaType.APPLICATION_JSON)
                        .characterEncoding("utf-8"))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    @WithMockUser(username = "admin", password = "1111", roles = "ADMIN")
    public void createIncome() throws Exception {
        IncomeDto incomeDto = new IncomeDto(null, "Part-Time Job", 1500, 1L);
        IncomeDto createdIncome = new IncomeDto(3L, "Part-Time Job", 1500, 1L);

        when(incomeManager.addIncome(any())).thenReturn(createdIncome);

        mockMvc.perform(post("/user/1/incomes/createIncome")
                        .with(csrf())
                        .contentType(MediaType.APPLICATION_JSON)
                        .characterEncoding("utf-8")
                        .content(objectMapper.writeValueAsString(incomeDto)))
                .andExpect(status().is3xxRedirection());
    }

    @Test
    @WithMockUser(username = "admin", password = "1111", roles = "ADMIN")
    public void updateIncome() throws Exception {
        IncomeDto updatedIncome = new IncomeDto(1L, "New Salary", 2000, 1L);

        when(incomeManager.updateIncome(eq(1L), any())).thenReturn(updatedIncome);

        mockMvc.perform(put("/user/1/incomes/1")
                        .with(csrf())
                        .contentType(MediaType.APPLICATION_JSON)
                        .characterEncoding("utf-8")
                        .content(objectMapper.writeValueAsString(updatedIncome)))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(updatedIncome)));
    }

    @Test
    @WithMockUser(username = "admin", password = "1111", roles = "ADMIN")
    public void deleteIncome() throws Exception {
        mockMvc.perform(delete("/user/1/incomes/1")
                        .with(csrf())
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("utf-8"))
                .andExpect(status().isNoContent());
    }
}
