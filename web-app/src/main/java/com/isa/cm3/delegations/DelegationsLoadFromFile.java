package com.isa.cm3.delegations;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

@RequestScoped
public class DelegationsLoadFromFile {

    private final DateTimeFormatter formater = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    @Inject
    private DelegationRepository delegationRepository;
    @Inject
    private Employee employee;
    @Inject
    private Destination destination;
    @Inject
    private Delegation delegation;


    private Path path = Paths.get(System.getProperty("jboss.server.data.dir"), "delegations.txt");

    public String loadDelegationsFromFile() {

        String line;
        Reader reader;
        try {
            reader = Files.newBufferedReader(path, StandardCharsets.UTF_8);
            line = ((BufferedReader) reader).readLine();
            if (line == null) {
                return "Brak delegacji do wyświetlenia";
            } else {
                try {
                    while (line != null) {
                        if (!line.equals("")) {
                            List<String> tempList = Arrays.asList(line.split(","));

                            delegationRepository.setList(new Delegation(
                                    Integer.parseInt(tempList.get(0).trim()),
                                    LocalDate.parse(tempList.get(1).trim(), formater),
                                    (new Employee(
                                            tempList.get(2).trim(),
                                            tempList.get(3).trim())),
                                    LocalDate.parse(tempList.get(4).trim(), formater),
                                    LocalDate.parse(tempList.get(5).trim(), formater),

                                    (new Destination(tempList.get(6).trim(),
                                            tempList.get(7).trim(),
                                            tempList.get(8).trim(),
                                            tempList.get(9).trim())),
                                    tempList.get(10).trim(),
                                    DelegationStatus.valueOf(tempList.get(11).trim()),
                                    tempList.get(12).trim(),
                                    (tempList.get(13).trim())));

                            delegationRepository.setCreationDateList("");
                            delegationRepository.setNameList("");
                            delegationRepository.setSurNameList("");
                            delegationRepository.setDestinationCountryList("");

                            delegationRepository.setCreationDateList(tempList.get(1).trim());
                            delegationRepository.setNameList(tempList.get(2).trim());
                            delegationRepository.setSurNameList(tempList.get(3).trim());
                            delegationRepository.setDestinationCountryList(tempList.get(6).trim());
                        }
                        line = ((BufferedReader) reader).readLine();
                    }
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "ok";
    }
}

