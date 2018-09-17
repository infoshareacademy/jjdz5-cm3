package com.isa.cm3.delegations;

import javax.enterprise.context.Dependent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Dependent
public class DelegationAutoincrementId {

    public  Integer loadId() {
        Integer i = 1;
        Path path = Paths.get(System.getProperty("jboss.server.data.dir"), "delegations.txt");
        Reader reader;

        try {
            reader = Files.newBufferedReader(path, StandardCharsets.UTF_8);


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
