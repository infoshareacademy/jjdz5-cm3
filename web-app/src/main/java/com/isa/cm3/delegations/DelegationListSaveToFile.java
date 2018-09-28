package com.isa.cm3.delegations;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;

@RequestScoped
public class DelegationListSaveToFile {

    @Inject
    private Settings settings;

    @Inject
    private DelegationRepository delegationRepository;

    public void saveToFile() {

        Writer writer;


        for (Delegation delegation : delegationRepository.getList()) {
            try {
                if (delegation.getFileLineNumber().equals(1)) {
                    writer = Files.newBufferedWriter(settings.getPath(), StandardCharsets.UTF_8, StandardOpenOption.TRUNCATE_EXISTING);
                    writer = Files.newBufferedWriter(settings.getPath(), StandardCharsets.UTF_8);
                    writer.write(delegation.toString());
                    writer.close();
                } else {
                    writer = Files.newBufferedWriter(settings.getPath(), StandardCharsets.UTF_8, StandardOpenOption.APPEND);
                    ((BufferedWriter) writer).newLine();
                    writer.write(delegation.toString());
                    writer.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
