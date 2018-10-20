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
    void shouldReturnSetEmployeeName() {
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
    void shouldReturnSetEmployeeSurname() {
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
    void shouldReturnSetDestinationCountry() {
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
    void shouldReturnSetDestinationCity() {
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
    void shouldReturnSetDestinationCompany() {
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
    void shouldReturnSetDestinationCompanyAddress() {
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
    void shouldReturnSetDestination1() {
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
    void shouldReturnSetDestination2() {
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

    @Test
    void shouldReturnEqualsObiect() {
        // arrage
        Boolean result;
        List<Delegation> object1 = new ArrayList<>();
        List<Delegation> object2 = new ArrayList<>();

        LocalDate today = LocalDate.now();

        object1.add(new Delegation(
                Integer.parseInt("1"),
                LocalDate.parse("2018-10-10"),
                (new Employee(
                        "Tomasz",
                        "Andrzejewski")),
                today,
                today,
                (new Destination(
                        "Poland",
                        "Wrocław",
                        "ABC - xyz",
                        "Władysława III")),
                "szkolenie",
                DelegationStatus.TOACCEPT,
                "Gdańsk",
                "sadsadsad"));

        object2.add(new Delegation(
                Integer.parseInt("1"),
                LocalDate.parse("2018-10-10"),
                (new Employee(
                        "Tomasz",
                        "Andrzejewski")),
                today,
                today,
                (new Destination(
                        "Poland",
                        "Wrocław",
                        "ABC - xyz",
                        "Władysława III")),
                "szkolenie",
                DelegationStatus.TOACCEPT,
                "Gdańsk",
                "sadsadsad"));

        // act
        result = object1.equals(object2);
        // assert
        assertEquals(true, result);
    }

    @Test
    void shouldReturnNotEqualsObiect() {
        // arrage
        Boolean result;
        List<Delegation> object1 = new ArrayList<>();
        List<Delegation> object2 = new ArrayList<>();

        LocalDate today = LocalDate.now();

        object1.add(new Delegation(
                Integer.parseInt("1"),
                LocalDate.parse("2018-10-10"),
                (new Employee(
                        "Tomasz",
                        "Andrzejewski")),
                today,
                today,
                (new Destination(
                        "Poland",
                        "Wrocław",
                        "ABC - xyz",
                        "Władysława III")),
                "szkolenie",
                DelegationStatus.TOACCEPT,
                "Gdańsk",
                "sadsadsad"));

        object2.add(new Delegation(
                Integer.parseInt("1"),
                LocalDate.parse("2018-10-10"),
                (new Employee(
                        "Tomasz",
                        "Andrzejewski")),
                today,
                today,
                (new Destination(
                        "Poland",
                        "Wrocław",
                        "ABC - xyz",
                        "Władysława III")),
                "szkolenie",
                DelegationStatus.TOACCEPT,
                "Gdańsk",
                "sadsadsada"));

        // act
        result = object1.equals(object2);
        // assert

        assertNotEquals(true, result);

    }

    @Test
    void shouldReturnEqualsHashCodeObiect() {
        // arrage
        Integer result1;
        Integer result2;
        List<Delegation> object1 = new ArrayList<>();
        List<Delegation> object2 = new ArrayList<>();

        LocalDate today = LocalDate.now();

        object1.add(new Delegation(
                Integer.parseInt("1"),
                LocalDate.parse("2018-10-10"),
                (new Employee(
                        "Tomasz",
                        "Andrzejewski")),
                today,
                today,
                (new Destination(
                        "Poland",
                        "Wrocław",
                        "ABC - xyz",
                        "Władysława III")),
                "szkolenie",
                DelegationStatus.TOACCEPT,
                "Gdańsk",
                "sadsadsad"));

        object2.add(new Delegation(
                Integer.parseInt("1"),
                LocalDate.parse("2018-10-10"),
                (new Employee(
                        "Tomasz",
                        "Andrzejewski")),
                today,
                today,
                (new Destination(
                        "Poland",
                        "Wrocław",
                        "ABC - xyz",
                        "Władysława III")),
                "szkolenie",
                DelegationStatus.TOACCEPT,
                "Gdańsk",
                "sadsadsad"));

        // act
        result1 = object1.hashCode();
        result2 = object2.hashCode();

        // assert
        assertEquals(result1,result2);
    }

    @Test
    void shouldReturnNotEqualsHashCodeObiect() {
        // arrage
        Integer result1;
        Integer result2;
        List<Delegation> object1 = new ArrayList<>();
        List<Delegation> object2 = new ArrayList<>();

        LocalDate today = LocalDate.now();

        object1.add(new Delegation(
                Integer.parseInt("1"),
                LocalDate.parse("2018-10-10"),
                (new Employee(
                        "Tomasz",
                        "Andrzejewski")),
                today,
                today,
                (new Destination(
                        "Poland",
                        "Wrocław",
                        "ABC - xyz",
                        "Władysława III")),
                "szkolenie",
                DelegationStatus.TOACCEPT,
                "Gdańsk",
                "sadsadsad"));

        object2.add(new Delegation(
                Integer.parseInt("2"),
                LocalDate.parse("2018-10-10"),
                (new Employee(
                        "Tomasz Adam",
                        "Andrzejewski")),
                today,
                today,
                (new Destination(
                        "Poland",
                        "Wrocław",
                        "ABC - xyz",
                        "Władysława III")),
                "szkolenie",
                DelegationStatus.TOACCEPT,
                "Gdańsk",
                "sadsadsad"));

        // act
        result1 = object1.hashCode();
        result2 = object2.hashCode();

        // assert
        assertNotEquals(result1,result2);
    }

    @Test
    void shouldReturnEqualsToStringObiect() {
        // arrage
        String result1;
        String result2;
        List<Delegation> object1 = new ArrayList<>();
        List<Delegation> object2 = new ArrayList<>();

        LocalDate today = LocalDate.now();

        object1.add(new Delegation(
                Integer.parseInt("1"),
                LocalDate.parse("2018-10-10"),
                (new Employee(
                        "Tomasz",
                        "Andrzejewski")),
                today,
                today,
                (new Destination(
                        "Poland",
                        "Wrocław",
                        "ABC - xyz",
                        "Władysława III")),
                "szkolenie",
                DelegationStatus.TOACCEPT,
                "Gdańsk",
                "sadsadsad"));

        object2.add(new Delegation(
                Integer.parseInt("1"),
                LocalDate.parse("2018-10-10"),
                (new Employee(
                        "Tomasz",
                        "Andrzejewski")),
                today,
                today,
                (new Destination(
                        "Poland",
                        "Wrocław",
                        "ABC - xyz",
                        "Władysława III")),
                "szkolenie",
                DelegationStatus.TOACCEPT,
                "Gdańsk",
                "sadsadsad"));

        // act
        result1 = object1.toString();
        result2 = object2.toString();

        // assert
        assertEquals(result1,result2);
    }
}
