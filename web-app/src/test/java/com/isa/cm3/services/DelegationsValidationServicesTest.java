package com.isa.cm3.services;

import com.isa.cm3.delegations.Settings;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class DelegationsValidationServicesTest {

    @Inject
    Settings settings;
    LocalDate startDate = LocalDate.now();
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
    @DisplayName("Should return \"Błędnie wpisane imię\" when given name matches regex")
    void shouldReturnMessegeWhenGivenNameDoNotMatchesRegex() {
        //arrange
        map.put("name", "1111");
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
    @DisplayName("Shuld return true when all keys are ok")
    void sholdReturnTrueWhenAllMapKeysAreCorrect(){
        map.put("country","");
        map.put("city","");

        assertAll(
                ()->assertTrue(map.containsKey("country")),
                ()->assertTrue(map.containsKey("city"))
        );
    }

    @Test
    @DisplayName("Should return \"ok\" when given company matches regex")
    void shouldReturnOkWhenGivenCompanyMatchesRegex(){
        //arrange
        map.put("company","Firma");
        //act
        String result = delegationsValidationServices.requestValidation(map);
        //assert
        assertEquals("ok",result);
    }
    @Test
    @DisplayName("Should return \"Błędnie podana nazwa firmy\" when given company don't matche regex")
    void shouldReturnMessageWhenGivenCompanyMatchesRegex(){
        //arrange
        map.put("company","1234");
        //act
        String result = delegationsValidationServices.requestValidation(map);
        //assert
        assertEquals("Błędnie podana nazwa firmy",result);
    }

    
}