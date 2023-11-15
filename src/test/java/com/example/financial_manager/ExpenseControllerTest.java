package com.example.financial_manager;

import com.example.financial_manager.controllers.ExpenseController;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.junit.jupiter.api.Test;

@WebMvcTest(ExpenseController.class)
public class ExpenseControllerTest {

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testGetUser() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/expenses/{id}", 1)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.expense_id").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$.expanseAmount").isNotEmpty())
                .andExpect(MockMvcResultMatchers.jsonPath("$.expensePurpose").isNotEmpty());
    }
}
