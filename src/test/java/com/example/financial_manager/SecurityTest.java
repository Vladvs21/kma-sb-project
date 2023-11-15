package com.example.financial_manager;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SecurityTest {

    @LocalServerPort
    private int port;

    private final TestRestTemplate restAdminTemplate = new TestRestTemplate("user", "password");
    private final TestRestTemplate restUserTemplate = new TestRestTemplate("admin", "password");

    @Test
    public void adminExpense() {
        String url = "http://localhost:" + port + "/expenses";

        String htmlContent = restAdminTemplate.getForObject(url, String.class);
        ResponseEntity<String> response = restAdminTemplate.getForEntity(url, String.class);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);

        assertThat(htmlContent).contains("<button type=\"submit\">Add Expense</button>");
    }

    @Test
    public void userExpense() {
        String url = "http://localhost:" + port + "/expenses";

        String htmlContent = restUserTemplate.getForObject(url, String.class);
        ResponseEntity<String> response = restUserTemplate.getForEntity(url, String.class);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);

        assertThat(htmlContent).doesNotContain("<button type=\"submit\">Add Expense</button>");
    }
}
