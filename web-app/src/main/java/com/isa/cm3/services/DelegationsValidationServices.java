package com.isa.cm3.services;

import com.isa.cm3.delegations.Settings;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Map;

@RequestScoped
public class DelegationsValidationServices {

    private static final String REGEX_NAME_AND_SURNAME = "([A-Z,ĄŻŚŹĘĆŃÓŁ][a-z,ążśźęćńół]((?!\\,).)*$)";
    private static final String CITY = "(^[A-Z,ĄŻŚŹĘĆŃÓŁ][a-z,ążśźęćńół]((?!\\,)(?![0-9,=,$,#,%,!,^,&,*,@]).)*$)";
    private static final String COMPANY = "([A-Z,ĄŻŚŹĘĆŃÓŁ][a-z,ążśźęćńół]((?!\\,).)*$)";
    private static final String COMPANY_ADRES = "([A-Z,ĄŻŚŹĘĆŃÓŁ][a-z,ążśźęćńół]((?!\\,).)*$)";
    private static final String START_POINT = "([A-Z,ĄŻŚŹĘĆŃÓŁ][a-z,ążśźęćńół]((?!\\,).)*$)";
    private static final String SUCCESS_VALIDATION_MESSAGE = "ok";
    private static final String FAILD_VALIDATION_MESSAGE = "Błędnie wpisane pole: ";
    private static final String
            FAILD_VALIDATION_MESSAGE_END_DATE_BEFORE_START_DATE = "Data powrotu nie może być wcześniejsza od daty wyjazdu";
    private static final String
            FAILD_VALIDATION_MESSAGE_START_DATE_BEFORE_TODAY = "Data wyjazdu nie może być wcześniejsza od daty dzisiejszej";


    @Inject
    Settings settings;

    public String requestValidation(Map<String, String> map) {

        LocalDate startDate = LocalDate.now();
        LocalDate endDate = LocalDate.now();

        for (String key : map.keySet()) {

            String value = map.get(key);

            if (key.equals("country") || key.equals("purpose")) {
                continue;
            } else if (key.equals("name")) {
                if (!value.matches(REGEX_NAME_AND_SURNAME)) {
                    return FAILD_VALIDATION_MESSAGE + "imię"; //FIXME
                }
            } else if (key.equals("surname")) {
                if (!value.matches(REGEX_NAME_AND_SURNAME)) {
                    return FAILD_VALIDATION_MESSAGE + "nazwisko"; //FIXME
                }
            } else if (key.equals("startDate")) {
                startDate = LocalDate.parse(value, settings.getFormater());

                if (!dateValidation(value, settings.getFormater()).equals(SUCCESS_VALIDATION_MESSAGE)) {
                    return dateValidation(map.get(key), settings.getFormater());
                }
            } else if (key.equals("endDate")) {
                endDate = LocalDate.parse(value, settings.getFormater());
                if (!dateValidation(value, settings.getFormater()).equals(SUCCESS_VALIDATION_MESSAGE)) {
                    return dateValidation(map.get(key), settings.getFormater());
                }
            } else if (key.equals("city")) {
                if (!value.matches(CITY)) {
                    return FAILD_VALIDATION_MESSAGE + "miasto"; //FIXME
                }
            } else if (key.equals("company")) {
                if (!value.matches(COMPANY)) {
                    return FAILD_VALIDATION_MESSAGE + "nazwa firmy"; //FIXME
                }
            } else if (key.equals("companyAdres")) {
                if (!value.matches(COMPANY_ADRES)) {
                    return FAILD_VALIDATION_MESSAGE + "adres firmy"; //FIXME
                }
            } else if (key.equals("startPoint")) {
                if (!map.get(key).matches(START_POINT)) {
                    return FAILD_VALIDATION_MESSAGE + "miejsce startu"; //FIXME
                }
            }
        }

        if (isBefore(startDate, endDate)) {
            return FAILD_VALIDATION_MESSAGE_END_DATE_BEFORE_START_DATE;
        }

        if (isBefore(LocalDate.now(), startDate)) {
            return FAILD_VALIDATION_MESSAGE_START_DATE_BEFORE_TODAY;
        }
        return SUCCESS_VALIDATION_MESSAGE;
    }

    private boolean isBefore(LocalDate startDate, LocalDate endDate) {
        return endDate.isBefore(startDate);
    }

    private String dateValidation(String str, DateTimeFormatter formater) {

        String message = "Błędna data"; //FIXME

        try {

            LocalDate ld = LocalDate.parse(str, formater);
            String result = ld.format(formater);
            if (!result.equals(str)) {
                return message;
            }
        } catch (DateTimeParseException e) {
            e.printStackTrace();
        }
        return SUCCESS_VALIDATION_MESSAGE;
    }
}