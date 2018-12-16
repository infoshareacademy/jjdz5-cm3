package com.isa.cm3.services;

import java.util.Map;

public class EmployeeAddValidationService {

    private static final String REGEX_NAME_AND_SURNAME = "([A-Z,ĄŻŚŹĘĆŃÓŁ][a-z,ążśźęćńół]((?!\\,).)*$)";
    private static final String SUCCESS_VALIDATION_MESSAGE = "ok";
    private static final String FAILD_VALIDATION_MESSAGE = "Błędnie wpisane pole: ";
    private static final String EMAIL = "^(.+)@(.+)$";

    public String addUserValidation(Map<String, String> map) {

        for (String key : map.keySet()) {

            String value = map.get(key);
            if (key.equals("name")) {
                if (!value.matches(REGEX_NAME_AND_SURNAME)) {
                    return FAILD_VALIDATION_MESSAGE + "imię";
                }
            } else if (key.equals("surname")) {
                if (!value.matches(REGEX_NAME_AND_SURNAME)) {
                    return FAILD_VALIDATION_MESSAGE + "nazwisko";
                }

            } else if (key.equals("emali")) {
                if (!value.matches(EMAIL)) {
                    return FAILD_VALIDATION_MESSAGE + "email";
                }
            }
        }
        return SUCCESS_VALIDATION_MESSAGE;
    }
}