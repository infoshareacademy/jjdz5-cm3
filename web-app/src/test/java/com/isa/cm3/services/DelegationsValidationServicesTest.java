package com.isa.cm3.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DelegationsValidationServicesTest {

    private DelegationsValidationServices delegationsValidationServices;
    private  Map<String, String> map = new HashMap<>();

    @BeforeEach
    void init() {
        delegationsValidationServices = new DelegationsValidationServices();

    }

    @Test
    @DisplayName("Should return ok when given name matches regex")
    void shouldReturnOkWhenGivenNameMatchesRegex() {
        //arrange
        map.put("name", "Marek");
        //act
        String result = delegationsValidationServices.requestValidation(map);
        assertEquals("ok", result);
    }

    @Test
    @DisplayName("Should return \"Błędnie wpisane nazwisko\" when given name matches regex")
    void shouldReturnMessegeWhenGivenNameDoNotMatchesRegex() {
        //arrange
        map.put("name", "1111");
        //act
        String result = delegationsValidationServices.requestValidation(map);
        assertEquals("Błędnie wpisane imię",result);
    }

    @Test
    @DisplayName("Should return \"ok\" when given surname matches regex")
    void shouldReturnOkWhenGivenSurnameMatchesRegex() {
        //arrange
        map.put("surname", "Marek");
        //act
        String result = delegationsValidationServices.requestValidation(map);
        assertEquals("ok", result);
    }

    @Test
    @DisplayName("Should return \"Błędnie wpisane nazwisko\" when given surname don't matches regex")
    void shouldReturnMessegeWhenGivenSurnameDoNotMatchesRegex() {
        //arrange
        map.put("surname", "nazwisko");
        //act
        String result = delegationsValidationServices.requestValidation(map);
        assertEquals("Błędnie wpisane nazwisko",result);
    }

}