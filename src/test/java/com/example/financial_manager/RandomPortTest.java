package com.example.financial_manager;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.context.annotation.Import;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Import(TestConfig.class)
public class RandomPortTest {

    @LocalServerPort
    private int port;

     @Autowired
     private TestRestTemplate restTemplateBuilder;

    @Test
    public void testExpenseWithRandomPort() {
        String url = "http://localhost:" + port + "/expenses";
        String htmlContent = restTemplateBuilder.getForObject(url, String.class);
        assertEquals(htmlContent, "[]");
    }

    @Test
    public void testExpenseWithDefaultPort() {
        String url = "http://localhost:" + 8080 + "/expenses";
        String htmlContent = restTemplateBuilder.getForObject(url, String.class);
        assertThat(htmlContent).contains("\"id\":1");
    }
}
