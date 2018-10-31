package com.isa.cm3.services;

import com.isa.cm3.delegations.*;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.servlet.http.Part;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@RequestScoped
public class DelegationImportService {

    @Inject
    private Settings settings;
    @Inject
    private DelegationRepository delegationRepository;

    private static final String message = "Plik z błędami lub pusty. Żadne delegacje nie zostału zaimportowane.";
    private static final String succesMessage = "ok";

    public String uploadFromFileProcess(Part part) {
        String line;
        BufferedReader reader;
        LocalDate date;
        int id = 1;
        try {
            InputStream fileStream = part.getInputStream();
            reader = new BufferedReader(new InputStreamReader(fileStream, StandardCharsets.UTF_8));
            line = reader.readLine().trim();

            while (line != null) {
                try {
                    if (line.equals("")) {
                        return message + " : Zawiera puste linie.";
                    }
                    List<String> tempList = Arrays.asList(line.split(","));
                    if (tempList.size() != 11) {
                        return message;
                    }

                    String dateValidationInfo = bomAndDateValidation(tempList, id);
                    if (dateValidationInfo.equals("ok")) {
                        date = LocalDate.parse(tempList.get(0).trim(), settings.getFormater());
                    } else if (dateValidationInfo.equals("bom")) {
                        String substring = tempList.get(0).trim().substring(1, tempList.get(0).length());
                        date = LocalDate.parse(substring);
                    } else {
                        return message;
                    }

                    delegationRepository.setList(new Delegation(
                            id,
                            date,
                            (new Employee(
                                    tempList.get(1).trim(),
                                    tempList.get(2).trim())),
                            LocalDate.parse(tempList.get(3).trim(), settings.getFormater()),
                            LocalDate.parse(tempList.get(4).trim(), settings.getFormater()),

                            (new Destination(tempList.get(5).trim(),
                                    tempList.get(6).trim(),
                                    tempList.get(7).trim(),
                                    tempList.get(8).trim())),
                            tempList.get(9).trim(),
                            DelegationStatus.TOACCEPT,
                            tempList.get(10).trim(),
                            null
                    ));
                    line = reader.readLine();
                    id++;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return succesMessage;
    }

    private String bomAndDateValidation(List<String> tempList, int counter) {

        String regex = "([12]\\d{3}-(0[1-9]|1[0-2])-(0[1-9]|[12]\\d|3[01]))";
        boolean allMatches = tempList.get(0).trim().matches(regex) && tempList.get(3).trim().matches(regex) && tempList.get(4).trim().matches(regex);
        boolean twoMatches = tempList.get(3).trim().matches(regex) && tempList.get(4).trim().matches(regex);

        if (counter == 1) {
            if (allMatches) {
                return succesMessage;
            } else {
                String substring = tempList.get(0).trim().substring(1, tempList.get(0).length());
                if (substring.matches(regex) && twoMatches) {
                    return "bom";
                } else {
                    return message;
                }
            }
        }

        if (counter > 1) {
            if (allMatches) {
                return succesMessage;
            } else {
                return message;
            }
        }
        return succesMessage;
    }
}