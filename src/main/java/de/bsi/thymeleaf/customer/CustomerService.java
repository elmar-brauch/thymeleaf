package de.bsi.thymeleaf.customer;

import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;
import java.util.logging.Logger;

@Service
public class CustomerService {

    private static final Logger log = Logger.getLogger(CustomerService.class.getName());

    public Optional<String> getCustomerNumberByEmail(String email) {
        log.finest("Search customer number by email %s".formatted(email));
        return Optional.of("EMAIL_123");
    }

    public Optional<String> getCustomerNumberByFirstNameAndLastName(String firstName, String lastName) {
        log.finest("Search customer number by first name %s and last name %s".formatted(firstName, lastName));
        return Optional.of("FIRST_LAST_123");
    }

    public Optional<String> getCustomerNumberByGivenNameAndFamilyName(String givenName, String familyName) {
        log.finest("Search customer number by given name %s and family name %s".formatted(givenName, familyName));
        return Optional.of("GIVEN_FAMILY_123");
    }

}
