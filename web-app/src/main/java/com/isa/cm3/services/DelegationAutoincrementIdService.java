package com.isa.cm3.services;

import com.isa.cm3.delegations.Settings;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Dependent
public class DelegationAutoincrementIdService {

    @Inject
    Settings settings;

    public Integer loadId() {
        Integer i = 1;
        Reader reader;

        try {
            reader = Files.newBufferedReader(settings.getPath(), StandardCharsets.UTF_8);

            if (((BufferedReader) reader).readLine() == null) {
                return 1;
            } else {
                do {
                    i++;
                }
                while (((BufferedReader) reader).readLine() != null);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return i;
    }
}
