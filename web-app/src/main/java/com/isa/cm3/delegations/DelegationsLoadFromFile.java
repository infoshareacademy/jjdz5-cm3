package com.isa.cm3.delegations;

import javax.inject.Inject;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

public class DelegationsLoadFromFile {

    @Inject
    DelegationRepository delegationRepository;

    private Path path = Paths.get(System.getProperty("jboss.server.data.dir"), "delegations.txt");

    public String delegationReadFile(String fileDelegation) {

        Reader reader;
        try {
            reader = Files.newBufferedReader(path, StandardCharsets.UTF_8);
            if (((BufferedReader) reader).readLine() == null) {
                return "brak danych";
            } else { return "ok";}



            do {
                    i++;
                }
                while (((BufferedReader) reader).readLine() != null);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


            BufferedReader bufferedReader = null;
            try {
                bufferedReader = new BufferedReader(fileReader);
                String line = "";
                int fileLineNumber = 0;
                while ((line = bufferedReader.readLine()) != null) {

                    if (!line.equals("")) {  //nie dodawaj pustych lini

                        List<String> tempList = Arrays.asList(line.split(","));

                        if (tempList.size() == 13) {

                            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");

                            LocalDate tempCreationDate = LocalDate.parse(
                                    tempList.get(1).trim().replace("-", ""), formatter);

                            LocalDate tempStartDate = LocalDate.parse(
                                    tempList.get(4).trim().replace("-", ""), formatter);

                            LocalDate tempEndDate = LocalDate.parse(
                                    tempList.get(5).trim().replace("-", ""), formatter);

                            readDelegations.add(new Delegation(
                                    ++fileLineNumber, tempCreationDate,
                                    (new Employee(tempList.get(2), tempList.get(3))
                                    ),
                                    tempStartDate,
                                    tempEndDate,
                                    (new Destination(
                                            tempList.get(6),
                                            tempList.get(7),
                                            tempList.get(8),
                                            tempList.get(9))),
                                    tempList.get(10),
                                    DelegationStatus.valueOf(tempList.get(11)),
                                    tempList.get(12)));
                        }
                    }

                }
            } catch (Exception e) {
                System.out.println(e);
            } finally {

                try {
                    bufferedReader.close();
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        }

        return readDelegations;

    }
}
