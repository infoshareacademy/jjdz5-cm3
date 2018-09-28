package com.isa.cm3.delegations;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;

@RequestScoped
public class DelegationAddToFile {

    @Inject
    Settings settings;

    public void saveToFile(Delegation delegation) {

        if (Files.notExists(settings.getPath())) {
            try {
                Files.createFile(settings.getPath());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try {
            Reader reader = Files.newBufferedReader(settings.getPath(), StandardCharsets.UTF_8);
            if (((BufferedReader) reader).readLine() == null) {
                Writer writeOnce = Files.newBufferedWriter(settings.getPath(), StandardCharsets.UTF_8);
                writeOnce.write(delegation.toString());
                writeOnce.close();
                return;
            }
            Writer writeOut = Files.newBufferedWriter(settings.getPath(), StandardCharsets.UTF_8, StandardOpenOption.APPEND);
            ((BufferedWriter) writeOut).newLine();
            writeOut.write(delegation.toString());
            writeOut.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
