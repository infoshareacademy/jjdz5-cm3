package com.isa.cm3.delegations;

import javax.enterprise.context.RequestScoped;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Map;

@RequestScoped
public class DelegationsValidation {

    private final String nameSurname = "([A-Z,ĄŻŚŹĘĆŃÓŁ][a-z,ążśźęćńół]((?!\\,).)*$)";
    private final DateTimeFormatter formater = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private final String city = "([A-Z,ĄŻŚŹĘĆŃÓŁ][a-z,ążśźęćńół]((?!\\,).)*$)";
    private final String company = "([A-Z,ĄŻŚŹĘĆŃÓŁ][a-z,ążśźęćńół]((?!\\,).)*$)";
    private final String companyAdres = "([A-Z,ĄŻŚŹĘĆŃÓŁ][a-z,ążśźęćńół]((?!\\,).)*$)";
    private final String startPoint = "([A-Z,ĄŻŚŹĘĆŃÓŁ][a-z,ążśźęćńół]((?!\\,).)*$)";


    public String requestValidation(Map<String, String> map) {

        for (String s : map.keySet()) {

            if (s.equalsIgnoreCase("name") || s.equalsIgnoreCase("surname")) {
                if (!map.get(s).matches(nameSurname)) {
                    return "Błędnie wpisane Imię lub nazwisko";
                }

            } else if (s.equalsIgnoreCase("startDate")) {

                if (!dateVAlidation(map.get(s), formater).equals("ok")) {
                    return dateVAlidation(map.get(s), formater);
                }
            } else if (s.equalsIgnoreCase("endDate")) {
                if (!dateVAlidation(map.get(s), formater).equals("ok")) {
                    return dateVAlidation(map.get(s), formater);
                }
            } else if (s.equalsIgnoreCase("city")) {
                if (!map.get(s).matches(city)) {
                    return "Błędnie wpisane miasto - wpisz tylko litery";
                }
            } else if (s.equalsIgnoreCase("company")) {
                if (!map.get(s).matches(company)) {
                    return "Błędnie podana nazwa firmy";
                }
            } else if (s.equalsIgnoreCase("companyAdres")) {
                if (!map.get(s).matches(companyAdres)) {
                    return "Błędnie podana adres firmy";
                }
            }else if (s.equalsIgnoreCase("startPoint")){
                if (!map.get(s).matches(startPoint)){
                    return "Błędnie podana adres firmy";
                }
            }
        }
        return "true";
    }

    private String dateVAlidation(String str, DateTimeFormatter formater) {
        try {
            LocalDate ld = LocalDate.parse(str, formater);
            String result = ld.format(formater);
            if (!result.equals(str)) {
                return "Błędna data";
            } else if (ld.isAfter(LocalDate.now())) {
                return "Data wyjazdu nie może być wcześniejsza od daty dzisiejszej ";
            }
        } catch (DateTimeParseException e) {
            e.printStackTrace();
        }
        return "ok";
    }
}



