package com.isa.cm3.delegations;

import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DelegationTest {

    @Inject
    private Delegation delegation;


    @Test
    void ShouldReturnSetEmployeeName() {
        // arrage
        String result;

        Employee testName = new Employee();

        testName.setEmployeeName("Paweł");

        // act
        result = testName.getEmployeeName();
        // assert
        assertEquals("Paweł", result);
        assertNotEquals("Piotr", result);
    }

    @Test
    void ShouldReturnSetEmployeeSurname() {
        // arrage
        String result;

        Employee testSurname = new Employee();

        testSurname.setEmployeeSurname("Beatowski");

        // act
        result = testSurname.getEmployeeSurname();
        // assert
        assertEquals("Beatowski", result);
        assertNotEquals("Piotrowski", result);
    }

    @Test
    void ShouldReturnSetDestinationCountry() {
        // arrage
        String result;

        Destination testDestinationCountry = new Destination();

        testDestinationCountry.setDestinationCountry("Poland");

        // act
        result = testDestinationCountry.getDestinationCountry();
        // assert
        assertEquals("Poland", result);
        assertNotEquals("Polandia", result);
    }

    @Test
    void ShouldReturnSetDestinationCity() {
        // arrage
        String result;

        Destination testDestinationCity = new Destination();

        testDestinationCity.setDestinationCity("Warszawa");

        // act
        result = testDestinationCity.getDestinationCity();
        // assert
        assertEquals("Warszawa", result);
        assertNotEquals("Wrocław", result);
    }

    @Test
    void ShouldReturnSetDestinationCompany() {
        // arrage
        String result;

        Destination testDestinationCompany = new Destination();

        testDestinationCompany.setDestinationCompany("IBM");

        // act
        result = testDestinationCompany.getDestinationCompany();
        // assert
        assertEquals("IBM", result);
        assertNotEquals("Amazon", result);
    }

    @Test
    void ShouldReturnSetDestinationCompanyAddress() {
        // arrage
        String result;

        Destination testDestinationCompanyAddress = new Destination();

        testDestinationCompanyAddress.setDestinationCompanyAddress("Warszawa Fortuny 9");

        // act
        result = testDestinationCompanyAddress.getDestinationCompanyAddress();
        // assert
        assertEquals("Warszawa Fortuny 9", result);
        assertNotEquals("Wrocław Fortuny 9", result);
    }

    @Test
    void ShouldReturnSetDestination1() {
        // arrage
        String result;

        Destination testDestination = new Destination();

        testDestination.setDestinationCountry("Poland");
        testDestination.setDestinationCity("Warszawa");
        testDestination.setDestinationCompany("IBM");
        testDestination.setDestinationCompanyAddress("Warszawa Fortuny 9");

        // act
        result = testDestination.toString();

        // assert
        assertEquals("Poland,Warszawa,IBM,Warszawa Fortuny 9", result);
        assertNotEquals("Polandia,Wrosław,Amazon,Wrocław Fortuny 9", result);
    }
    @Test
    void ShouldReturnSetDestination2() {
        // arrage
        String result;

        Destination testDestination = new Destination(
                "Poland",
                "Warszawa",
                "IBM",
                "Warszawa Fortuny 9");


        // act
        result = testDestination.toString();

        // assert
        assertEquals("Poland,Warszawa,IBM,Warszawa Fortuny 9", result);
        assertNotEquals("Polandia,Wrosław,Amazon,Wrocław Fortuny 9", result);
    }
}