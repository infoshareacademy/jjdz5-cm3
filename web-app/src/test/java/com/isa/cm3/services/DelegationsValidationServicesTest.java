package com.isa.cm3.services;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Delegations validation services")
public class DelegationsValidationServicesTest {

    private DelegationsValidationServices validator = new DelegationsValidationServices();
    private Map<String, String> input = new HashMap<>();


    @Test
    @DisplayName("Should return \"Błędnie wpisane Imię\" when name is not matches to regex")
    void nameIsInvalid() {
        input.put("name", "jan");
        String result = validator.requestValidation(input);
        assertEquals("Błędnie wpisane Imię", result);
    }

    @Test
    @DisplayName("Should return \"Poprawnie wpisane imie\" when name is matches to regex")
    void nameIsValid() {
        input.put("name", "Karolina");
        String result = validator.requestValidation(input);
        assertEquals("Poprawnie wpisane imie", result);
    }

    @Test
    @DisplayName("Should return \"Błędnie wpisane Nazwisko\" when surname is not matches to regex")
    void surnameIsInvalid() {
        input.put("surnaname", "");
        String result = validator.requestValidation(input);
        assertEquals("Błędnie wpisane Nazwisko", result);
    }

    @Test
    @DisplayName("Should return \"Błędnie podane miejsce startu\" when startPoint is not matches to regex")
    void startPointIsInvalid() {
        input.put("startPoint", "1234");
        String result = validator.requestValidation(input);
        assertEquals("Błędnie podane miejsce startu", result);
    }

    @Test
    @DisplayName("Should return \"Poprawnie podane miejsce startu\" when startPoint is not matches to regex")
    void startPointIsValid() {
        input.put("startPoint", "Gdańsk");
        String result = validator.requestValidation(input);
        assertEquals("Poprawnie podane miejsce startu", result);
    }







}
