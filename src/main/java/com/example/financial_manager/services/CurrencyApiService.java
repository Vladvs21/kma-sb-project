package com.example.financial_manager.services;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CurrencyApiService {

    private final RestTemplate restTemplate = new RestTemplate();

    public CurrencyRates fetchCurrencyRates() {
        //String apiKey = "cur_live_ocdBOKquG87vqyE5wXTB7rtGM1mNIfBnP4dNz8nv";
        String apiUrl = "https://api.currencyapi.com/v3/latest?apikey=cur_live_ocdBOKquG87vqyE5wXTB7rtGM1mNIfBnP4dNz8nv&currencies=EUR%2CUSD%2CCAD";
        ResponseEntity<CurrencyRates> response = restTemplate.exchange(
                apiUrl,
                HttpMethod.GET,
                null,
                CurrencyRates.class
        );

        if (response.getStatusCode() == HttpStatus.OK) {
            return response.getBody();
        } else {
            throw new RuntimeException("Failed to fetch currency rates from the external API");
        }
    }
}
