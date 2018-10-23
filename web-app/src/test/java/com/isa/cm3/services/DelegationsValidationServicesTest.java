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
    private String expectedSuccessValidationResult = "ok";
    private String FailedValidationMessage = "Błędnie wpisane pole: ";
    private String expectedFailedValidationResult;

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
        assertEquals(expectedSuccessValidationResult, result);
    }

    @Test
    @DisplayName("Should return \"Błędnie wpisane pole: imię \"  when given name NotMaches regex")
    void shouldReturnFailedValidationMessageWhenGivenNameDoNotMatchesRegex() {
        //arrange
        map.put("name", "");
        expectedFailedValidationResult = FailedValidationMessage + "imię";

        //act
        String result = delegationsValidationServices.requestValidation(map);

        //assert
        assertEquals(expectedFailedValidationResult, result);
    }

    @Test
    @DisplayName("Should return \"ok\" when given surname matches regex")
    void shouldReturnOkWhenGivenSurnameMatchesRegex() {
        //arrange
        map.put("surname", "Marek");

        //act
        String result = delegationsValidationServices.requestValidation(map);

        //assert
        assertEquals(expectedSuccessValidationResult, result);
    }

    @Test
    @DisplayName("Should return \"Błędnie wpisane nazwisko\" when given surname NotMaches regex")
    void shouldReturnFailedValidationMessageWhenGivenSurnameDoNotMatchesRegex() {
        //arrange
        map.put("surname", "nazwisko");
        expectedFailedValidationResult = FailedValidationMessage + "nazwisko";

        //act
        String result = delegationsValidationServices.requestValidation(map);

        //assert
        assertEquals(expectedFailedValidationResult, result);
    }

    @Test
    @DisplayName("Sholud return \"ok\" when given City matches regex ")
    void shouldReturnOkWhenGivenCityMatchesRegex() {
        //arrange
        map.put("city", "Gdańsk");

        //act
        String result = delegationsValidationServices.requestValidation(map);

        //asssert
        assertEquals(expectedSuccessValidationResult, result);
    }

    @Test
    @DisplayName("Sholud return \"Błędnie wpisane miasto - wpisz tylko litery\" when given City NotMaches regex ")
    void shouldReturnFailedValidationMessageWhenGivenCityDoNotMatchesRegex() {
        //arrange
        map.put("city", "gdańsk");
        expectedFailedValidationResult = FailedValidationMessage + "miasto";

        //act
        String result = delegationsValidationServices.requestValidation(map);

        //asssert
        assertEquals(expectedFailedValidationResult, result);
    }

    @Test
    @DisplayName("Should return \"ok\" when given company matches regex")
    void shouldReturnOkWhenGivenCompanyMatchesRegex() {
        //arrange
        map.put("company", "Firma");

        //act
        String result = delegationsValidationServices.requestValidation(map);

        //assert
        assertEquals(expectedSuccessValidationResult, result);
    }

    @Test
    @DisplayName("Should return \"Błędnie podana nazwa firmy\" when given company NotMaches regex")
    void shouldReturnFailedValidationMessageWhenGivenCompanyMatchesRegex() {
        //arrange
        map.put("company", "1234");
        expectedFailedValidationResult = FailedValidationMessage + "nazwa firmy";

        //act
        String result = delegationsValidationServices.requestValidation(map);

        //assert
        assertEquals(expectedFailedValidationResult, result);
    }

    @Test
    @DisplayName("Should return \"ok\" when given companyAdres matches regex")
    void sholudReturnOkWhenCompanyAdresMatchesRegex() {
        //arrange
        map.put("companyAdres", "Firma");

        //act
        String result = delegationsValidationServices.requestValidation(map);

        //assert
        assertEquals(expectedSuccessValidationResult, result);
    }

    @Test
    @DisplayName("Should return \"Błędnie podany adres firmy\" when given companyAdres NotMaches regex")
    void sholudReturnFailedValidationMessageWhenCompanyAdresDoNotMatcheRegex() {
        //arrange
        map.put("companyAdres", "111Firma");
        expectedFailedValidationResult = FailedValidationMessage + "adres firmy";

        //act
        String result = delegationsValidationServices.requestValidation(map);

        //assert
        assertEquals(expectedFailedValidationResult, result);
    }

    @Test
    @DisplayName("Should return \"ok\" when given startPoint matches regex")
    void sholudReturnOkWhenStartPointMatchesRegex() {
        //arrange
        map.put("startPoint", "Gdańsk");

        //act
        String result = delegationsValidationServices.requestValidation(map);

        //assert
        assertEquals(expectedSuccessValidationResult, result);
    }

    @Test
    @DisplayName("Should return \"Błędnie podane mijsce startu\" when given startPoint NotMaches regex")
    void sholudReturnFailedValidationMessageWhenStartPointMatchesRegex() {
        //arrange
        map.put("startPoint", "111Gdańsk");
        expectedFailedValidationResult = FailedValidationMessage + "miejsce startu";

        //act
        String result = delegationsValidationServices.requestValidation(map);

        //assert
        assertEquals(expectedFailedValidationResult, result);
    }
}