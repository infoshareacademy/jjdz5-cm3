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

    @Inject
    Settings settings;
    @Inject
    private DelegationRepository delegationRepository;


    public String loadDelegationsFromFile() {

        String line;
        Reader reader;
        try {
            reader = Files.newBufferedReader(settings.getPath(), StandardCharsets.UTF_8);
            line = ((BufferedReader) reader).readLine();
            if (line == null) {
                return "Brak delegacji do wyświetlenia";
            } else {
                try {
                    readingLinesWithDelegatonsFromFile(line, (BufferedReader) reader);
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

    private void readingLinesWithDelegatonsFromFile(String line, BufferedReader reader) throws IOException {
        while (line != null) {
            if (!line.equals("")) {
                List<String> tempList = Arrays.asList(line.split(","));

                delegationRepository.setList(new Delegation(
                        Integer.parseInt(tempList.get(0).trim()),
                        LocalDate.parse(tempList.get(1).trim(), settings.getFormater()),
                        (new Employee(
                                tempList.get(2).trim(),
                                tempList.get(3).trim())),
                        LocalDate.parse(tempList.get(4).trim(), settings.getFormater()),
                        LocalDate.parse(tempList.get(5).trim(), settings.getFormater()),

                        (new Destination(tempList.get(6).trim(),
                                tempList.get(7).trim(),
                                tempList.get(8).trim(),
                                tempList.get(9).trim())),
                        tempList.get(10).trim(),
                        DelegationStatus.valueOf(tempList.get(11).trim()),
                        tempList.get(12).trim(),
                        tempList.get(13).trim()));
            }

            line = reader.readLine();
        }
    }
}

