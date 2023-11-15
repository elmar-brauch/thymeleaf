package de.bsi.thymeleaf.customer;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
class CustomerControllerTest {

    private final WebTestClient webTestClient = WebTestClient.bindToServer().baseUrl("http://localhost:8080").build();

    @Test
    void getCustomerNumberByEmailPositiveCase() {
        webTestClient.get().uri("/customer/email?email=e@b.de").exchange()
                .expectStatus().isOk()
                .expectBody().jsonPath("$.customerNumber").isEqualTo("EMAIL_123");
    }

    @Test
    void getCustomerNumberByEmailValidationFailedCase() {
        webTestClient.get().uri("/customer/email?email=email").exchange()
                .expectStatus().isBadRequest();
    }

    @Test
    void getCustomerNumberByFirstNameAndLastNamePositiveCase() {
        webTestClient.get().uri("/customer/name?firstName=John&lastName=Doe").exchange()
                .expectStatus().isOk()
                .expectBody().jsonPath("$.customerNumber").isEqualTo("FIRST_LAST_123");
    }

    @Test
    void getCustomerNumberByFirstNameAndLastNameValidationFailedCase() {
        webTestClient.get().uri("/customer/name?firstName=John&lastName=123").exchange()
                .expectStatus().isBadRequest();
    }

}