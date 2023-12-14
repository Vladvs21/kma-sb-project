package com.example.financial_manager.services;

import com.example.financial_manager.services.CurrencyApiService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

public class CurrencyApiServiceTest {

    private CurrencyApiService currencyApiService;
    private RestTemplate restTemplate;

    @BeforeEach
    public void setUp() {
        restTemplate = mock(RestTemplate.class);
        currencyApiService = new CurrencyApiService();
    }

    @Test
    public void testFetchCurrencyRates_SuccessfulResponse() {
        String apiUrl = "https://api.currencyapi.com/v3/latest?apikey=cur_live_ocdBOKquG87vqyE5wXTB7rtGM1mNIfBnP4dNz8nv&currencies=EUR";
        CurrencyRates expectedRates = new CurrencyRates();

        ResponseEntity<CurrencyRates> response = new ResponseEntity<>(expectedRates, HttpStatus.OK);
        when(restTemplate.exchange(eq(apiUrl), eq(HttpMethod.GET), isNull(), eq(CurrencyRates.class)))
                .thenReturn(response);

        CurrencyRates actualRates = currencyApiService.fetchCurrencyRates();

        assertEquals(expectedRates, actualRates);
    }
}