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
    private static final String EXPECTED_SUCCESS_VALIDATION_RESULT = "ok";
    private static final String FAILED_VALIDATION_MESSAGE = "Błędnie wpisane pole: ";
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
        assertEquals(EXPECTED_SUCCESS_VALIDATION_RESULT, result);
    }

    @Test
    @DisplayName("Should return \"Błędnie wpisane pole: imię \"  when given name NotMaches regex")
    void shouldReturnFailedValidationMessageWhenGivenNameDoNotMatchesRegex() {
        //arrange
        map.put("name", "");
        expectedFailedValidationResult = FAILED_VALIDATION_MESSAGE + "imię";

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
        assertEquals(EXPECTED_SUCCESS_VALIDATION_RESULT, result);
    }

    @Test
    @DisplayName("Should return \"Błędnie wpisane pole: nazwisko\" when given surname NotMaches regex")
    void shouldReturnFailedValidationMessageWhenGivenSurnameDoNotMatchesRegex() {
        //arrange
        map.put("surname", "nazwisko");
        expectedFailedValidationResult = FAILED_VALIDATION_MESSAGE + "nazwisko";

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
        assertEquals(EXPECTED_SUCCESS_VALIDATION_RESULT, result);
    }

    @Test
    @DisplayName("Sholud return \"Błędnie wpisane pole: miasto\" when given City NotMaches regex ")
    void shouldReturnFailedValidationMessageWhenGivenCityDoNotMatchesRegex() {
        //arrange
        map.put("city", "gdańsk");
        expectedFailedValidationResult = FAILED_VALIDATION_MESSAGE + "miasto";

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
        assertEquals(EXPECTED_SUCCESS_VALIDATION_RESULT, result);
    }

    @Test
    @DisplayName("Should return \"Błędnie wpisane pole: nazwa firmy\" when given company NotMaches regex")
    void shouldReturnFailedValidationMessageWhenGivenCompanyMatchesRegex() {
        //arrange
        map.put("company", "1234");
        expectedFailedValidationResult = FAILED_VALIDATION_MESSAGE + "nazwa firmy";

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
        assertEquals(EXPECTED_SUCCESS_VALIDATION_RESULT, result);
    }

    @Test
    @DisplayName("Should return \"Błędnie wpisane pole: adres firmy\" when given companyAdres NotMaches regex")
    void sholudReturnFailedValidationMessageWhenCompanyAdresDoNotMatcheRegex() {
        //arrange
        map.put("companyAdres", "111Firma");
        expectedFailedValidationResult = FAILED_VALIDATION_MESSAGE + "adres firmy";

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
        assertEquals(EXPECTED_SUCCESS_VALIDATION_RESULT, result);
    }

    @Test
    @DisplayName("Should return \"Błędnie wpisane pole: mijsce startu\" when given startPoint NotMaches regex")
    void sholudReturnFailedValidationMessageWhenStartPointMatchesRegex() {
        //arrange
        map.put("startPoint", "111Gdańsk");
        expectedFailedValidationResult = FAILED_VALIDATION_MESSAGE + "miejsce startu";

        //act
        String result = delegationsValidationServices.requestValidation(map);

        //assert
        assertEquals(expectedFailedValidationResult, result);
    }
}