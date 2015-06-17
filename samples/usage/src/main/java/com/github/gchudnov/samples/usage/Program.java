package com.github.gchudnov.samples.usage;

import com.github.gchudnov.bspec.*;

/**
 * Constraint that only a customer who has specified a first given name can specify a second given name
 */
public class Program {

    static class Customer {
        String firstName;
        String secondName;

        Customer(String firstName, String secondName) {
            this.firstName = firstName;
            this.secondName = secondName;
        }
    }

    static class HasFirstNameSpecification extends CompositeSpecification<Customer> {
        @Override
        public boolean isSatisfiedBy(Customer candidate) {
            return candidate != null && candidate.firstName != null && !candidate.firstName.isEmpty();
        }
    }

    static class HasSecondNameSpecification extends CompositeSpecification<Customer> {
        @Override
        public boolean isSatisfiedBy(Customer candidate) {
            return candidate != null && candidate.secondName != null && !candidate.secondName.isEmpty();
        }
    }

    public static void main(String[] args) {

        Customer customer1 = new Customer("Bob", null);
        Customer customer2 = new Customer(null, "Pablo");
        Customer customer3 = new Customer("Juan", "Pablo");

        Specification<Customer> hasFirstName = new HasFirstNameSpecification();
        Specification<Customer> hasSecondName = new HasSecondNameSpecification();

        Specification<Customer> isCustomerNameValid = (hasSecondName.not()).or(hasFirstName);

        System.out.println("Only a customer who has specified a first given name can specify a second given name:");
        System.out.println();
        System.out.printf("customer1 (first_name: `Bob`): %b\n", isCustomerNameValid.isSatisfiedBy(customer1)); // true
        System.out.printf("customer2 (second_name: `Pablo`): %b\n", isCustomerNameValid.isSatisfiedBy(customer2)); // false
        System.out.printf("customer3 (first_name: `Juan`, second_name: `Pablo`): %b\n", isCustomerNameValid.isSatisfiedBy(customer3)); // true

    }
}
