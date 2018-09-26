package com.isa.cm3.delegations;

import javax.enterprise.context.RequestScoped;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Map;

@RequestScoped
public class DelegationsValidation {

    private final String regExNameAndSurname = "([A-Z,ĄŻŚŹĘĆŃÓŁ][a-z,ążśźęćńół]((?!\\,).)*$)";
    private final DateTimeFormatter formater = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private final String city = "(^[A-Z,ĄŻŚŹĘĆŃÓŁ][a-z,ążśźęćńół]((?!\\,)(?![0-9,=,$,#,%,!,^,&,*,@]).)*$)";
    private final String company = "([A-Z,ĄŻŚŹĘĆŃÓŁ][a-z,ążśźęćńół]((?!\\,).)*$)";
    private final String companyAdres = "([A-Z,ĄŻŚŹĘĆŃÓŁ][a-z,ążśźęćńół]((?!\\,).)*$)";
    private final String startPoint = "([A-Z,ĄŻŚŹĘĆŃÓŁ][a-z,ążśźęćńół]((?!\\,).)*$)";

    public String requestValidation(Map<String, String> map) {

        LocalDate startDate = LocalDate.now();
        LocalDate endDate = LocalDate.now();

        for (String key : map.keySet()) {

            String value = map.get(key);

            if (key.equals("country") || key.equals("purpose")) {
                continue;
            } else if (key.equals("name")) {
                if (!value.matches(regExNameAndSurname)) {
                    return "Błędnie wpisane Imię";
                }
            } else if (key.equals("surname")) {
                if (!value.matches(regExNameAndSurname)) {
                    return "Błędnie wpisane nazwisko";
                }
            } else if (key.equals("startDate")) {
                startDate = LocalDate.parse(value, formater);

                if (!dateVAlidation(value, formater).equals("ok")) {
                    return dateVAlidation(map.get(key), formater);
                }
            } else if (key.equals("endDate")) {
                endDate = LocalDate.parse(value, formater);
                if (!dateVAlidation(value, formater).equals("ok")) {
                    return dateVAlidation(map.get(key), formater);
                }

            } else if (key.equals("city")) {
                if (!value.matches(city)) {
                    return "Błędnie wpisane miasto - wpisz tylko litery";
                }
            } else if (key.equals("company")) {
                if (!value.matches(company)) {
                    return "Błędnie podana nazwa firmy";
                }
            } else if (key.equals("companyAdres")) {
                if (!value.matches(companyAdres)) {
                    return "Błędnie podana adres firmy";
                }
            } else if (key.equals("startPoint")) {
                if (!map.get(key).matches(startPoint)) {
                    return "Błędnie podana adres firmy";
                }
            }
        }

        if (endDate.isBefore(startDate)) {
            return "Data powrotu nie może być wcześniejsza od daty wyjazdu";
        }

        if (startDate.isBefore(LocalDate.now())) {
            return "Data wyjazdu nie może być wcześniejsza od daty dzisiejszej";
        }
        return "ok";
    }


    private String dateVAlidation(String str, DateTimeFormatter formater) {

        try {

            LocalDate ld = LocalDate.parse(str, formater);
            String result = ld.format(formater);
            if (!result.equals(str)) {
                return "Błędna data";
            }
        } catch (DateTimeParseException e) {
            e.printStackTrace();
        }
        return "ok";
    }
}



