package com.isa.cm3.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DelegationsValidationServicesTest {

    private DelegationsValidationServices delegationsValidationServices;
    private Map<String, String> map = new HashMap<>();

    @BeforeEach
    void init() {
        delegationsValidationServices = new DelegationsValidationServices();
    }

    @Test
    @DisplayName("Should return \"ok\" when given name matches regex")
    void shouldReturnOkWhenGivenNameMatchesRegex() {
        //arrange
        map.put("name", "Marek");
        //act
        String result = delegationsValidationServices.requestValidation(map);
        //assert
        assertEquals("ok", result);
    }

    @Test
    @DisplayName("Should return \"Błędnie wpisane imię\" when given name don't matche regex")
    void shouldReturnMessegeWhenGivenNameDoNotMatchesRegex() {
        //arrange
        map.put("name", "");
        //act
        String result = delegationsValidationServices.requestValidation(map);
        //assert
        assertEquals("Błędnie wpisane imię", result);
    }

    @Test
    @DisplayName("Should return \"ok\" when given surname matches regex")
    void shouldReturnOkWhenGivenSurnameMatchesRegex() {
        //arrange
        map.put("surname", "Marek");
        //act
        String result = delegationsValidationServices.requestValidation(map);
        //assert
        assertEquals("ok", result);
    }

    @Test
    @DisplayName("Should return \"Błędnie wpisane nazwisko\" when given surname don't matches regex")
    void shouldReturnMessegeWhenGivenSurnameDoNotMatchesRegex() {
        //arrange
        map.put("surname", "nazwisko");
        //act
        String result = delegationsValidationServices.requestValidation(map);
        //assert
        assertEquals("Błędnie wpisane nazwisko", result);
    }

    @Test
    @DisplayName("Sholud return \"ok\" when given City matches regex ")
    void shouldReturnOkWhenGivenCityMatchesRegex() {
        //arrange
        map.put("city", "Gdańsk");
        //act
        String result = delegationsValidationServices.requestValidation(map);
        //asssert
        assertEquals("ok", result);
    }

    @Test
    @DisplayName("Sholud return \"Błędnie wpisane miasto - wpisz tylko litery\" when given City don't matche regex ")
    void shouldReturnMessageWhenGivenCityDoNotMatchesRegex() {
        //arrange
        map.put("city", "gdańsk");
        //act
        String result = delegationsValidationServices.requestValidation(map);
        //asssert
        assertEquals("Błędnie wpisane miasto - wpisz tylko litery", result);
    }

    @Test
    @DisplayName("Should return \"ok\" when given company matches regex")
    void shouldReturnOkWhenGivenCompanyMatchesRegex() {
        //arrange
        map.put("company", "Firma");
        //act
        String result = delegationsValidationServices.requestValidation(map);
        //assert
        assertEquals("ok", result);
    }

    @Test
    @DisplayName("Should return \"Błędnie podana nazwa firmy\" when given company don't matche regex")
    void shouldReturnMessageWhenGivenCompanyMatchesRegex() {
        //arrange
        map.put("company", "1234");
        //act
        String result = delegationsValidationServices.requestValidation(map);
        //assert
        assertEquals("Błędnie podana nazwa firmy", result);
    }

    @Test
    @DisplayName("Should return \"ok\" when given companyAdres matches regex")
    void sholudReturnOkWhenCompanyAdresMatchesRegex() {
        //arrange
        map.put("companyAdres", "Firma");
        //act
        String result = delegationsValidationServices.requestValidation(map);
        //assert
        assertEquals("ok", result);
    }

    @Test
    @DisplayName("Should return \"Błędnie podany adres firmy\" when given companyAdres don't matche regex")
    void sholudReturnMessageWhenCompanyAdresDoNotMatcheRegex() {
        //arrange
        map.put("companyAdres", "111Firma");
        //act
        String result = delegationsValidationServices.requestValidation(map);
        //assert
        assertEquals("Błędnie podany adres firmy", result);
    }

    @Test
    @DisplayName("Should return \"ok\" when given startPoint matches regex")
    void sholudReturnOkWhenStartPointMatchesRegex() {
        //arrange
        map.put("startPoint", "Gdańsk");
        //act
        String result = delegationsValidationServices.requestValidation(map);
        //assert
        assertEquals("ok", result);
    }

    @Test
    @DisplayName("Should return \"Błędnie podane mijsce startu\" when given startPoint matches regex")
    void sholudReturnMessageWhenStartPointMatchesRegex() {
        //arrange
        map.put("startPoint", "111Gdańsk");
        //act
        String result = delegationsValidationServices.requestValidation(map);
        //assert
        assertEquals("Błędnie podane mijsce startu", result);
    }
}