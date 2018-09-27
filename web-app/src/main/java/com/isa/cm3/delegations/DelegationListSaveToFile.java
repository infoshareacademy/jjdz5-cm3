package com.isa.cm3.delegations;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class DelegationListSaveToFile {

    private Path path = Paths.get(System.getProperty("jboss.server.data.dir"), "delegations.txt");


    public void saveToFile(Delegation delegation) {

        if (Files.notExists(path)) {
            try {
                Files.createFile(path);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try {
            Reader reader = Files.newBufferedReader(path, StandardCharsets.UTF_8);
            if (((BufferedReader) reader).readLine() == null) {
                Writer writeOnce = Files.newBufferedWriter(path, StandardCharsets.UTF_8);
                writeOnce.write(delegation.toString());
                writeOnce.close();
                return;
            }
            Writer writeOut = Files.newBufferedWriter(path, StandardCharsets.UTF_8, StandardOpenOption.APPEND);
            ((BufferedWriter) writeOut).newLine();
            writeOut.write(delegation.toString());
            writeOut.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
