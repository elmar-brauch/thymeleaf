package de.bsi.thymeleaf.customer;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@RestController
@Validated
public class CustomerController {

    public record Customer(String customerNumber) {}

    private final Logger log = Logger.getLogger(CustomerController.class.getName());
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    /**
     * Find customer number by email.
     *
     * @param email email address of the customer.
     * @return Returns customer number wrapped in Customer record.
     */
    @GetMapping(path = "/customer/email", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Customer> getCustomerNumberByEmail(
            @Email @RequestParam("email") String email) {
        log.finest("Incoming request GET /customer?email=%s".formatted(email));
        var optionalCustomerNumber = customerService.getCustomerNumberByEmail(email);
        if (optionalCustomerNumber.isPresent())
            return ResponseEntity.ok(new Customer(optionalCustomerNumber.get()));
        return ResponseEntity.notFound().build();
    }

    private static final String REGEX_GERMAN_WORD = "[a-zA-ZäöüÖÄÜß]+";

    /**
     * Find customer number by first name and last name.
     *
     * @param firstName first name of the customer.
     * @param lastName last name of the customer.
     * @return Returns customer number wrapped in Customer record.
     */
    @GetMapping(path = "/customer/name", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Customer> getCustomerNumberByFirstNameAndLastName(
            @Valid @Pattern(regexp = REGEX_GERMAN_WORD) @RequestParam("firstName") String firstName,
            @Valid @Pattern(regexp = REGEX_GERMAN_WORD) @RequestParam("lastName") String lastName) {
        log.finest("Incoming request GET /customer?firstName=%s&lastName=%s".formatted(firstName, lastName));
        var optionalCustomerNumber = customerService.getCustomerNumberByFirstNameAndLastName(firstName, lastName);
        if (optionalCustomerNumber.isPresent())
            return ResponseEntity.ok(new Customer(optionalCustomerNumber.get()));
        return ResponseEntity.notFound().build();
    }

}
