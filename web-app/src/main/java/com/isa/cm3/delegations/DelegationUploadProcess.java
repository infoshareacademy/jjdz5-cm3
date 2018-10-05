package com.isa.cm3.delegations;

import org.apache.logging.log4j.*;
import org.apache.logging.slf4j.Log4jLogger;

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
public class DelegationUploadProcess {

    @Inject
    private Settings settings;
    @Inject
    private DelegationRepository delegationRepository;

    private static final Logger LOGGER = LogManager.getLogger(Log4jLogger.class);

    public String uploadFromFileProcess(Part part) {
        String line;
        BufferedReader reader;

        try {

            if (part.getSize() == 0) {
                return "Plik jest pusty";
            }

            InputStream fileStream = part.getInputStream();
            reader = new BufferedReader(new InputStreamReader(fileStream, StandardCharsets.UTF_8));
            line = reader.readLine().trim();

            if (line.isEmpty()) {
                return "Plik jest pusty";
            }
            LocalDate date;
            int id = 1;
            while (line != null) {
                try {
                    List<String> tempList = Arrays.asList(line.split(","));
                    if (tempList.size() != 11) {
                        return "Są błędy w pliku. Długość jednej z lini to: " + tempList.size() + " a powinno być 11." +
                                "\n Żadne dane nie zostały zapisane. Popraw plik i spóbuj jeszcze raz";
                    }

                    try {
                        date = LocalDate.parse(tempList.get(0).trim(), settings.getFormater());
                        LOGGER.warn("BOM na początku pliku ");
                    } catch (java.time.format.DateTimeParseException e) {
                        String substring = tempList.get(0).substring(1, tempList.get(0).length());
                        date = LocalDate.parse(substring, settings.getFormater());
                        LOGGER.info("Błąd parsowania");
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
        return "ok";
    }
}

