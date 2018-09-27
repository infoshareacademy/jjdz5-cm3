package com.isa.cm3.delegations;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import java.io.IOException;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;

@RequestScoped
public class DelegationListSaveToFile {

    @Inject
    Settings settings;

    @Inject
    DelegationRepository delegationRepository;

    public void saveToFile() {

        Writer writer;

        for (Delegation delegation : delegationRepository.getList()) {
            try {


                if (delegation.getFileLineNumber().equals(1)) {
                    writer = Files.newBufferedWriter(settings.getPath(), StandardCharsets.UTF_8, StandardOpenOption.TRUNCATE_EXISTING);
                    writer.write(delegation.toString());
                } else {

                    writer = Files.newBufferedWriter(settings.getPath(), StandardCharsets.UTF_8, StandardOpenOption.APPEND);
                    writer.write(delegation.toString());
                }

            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
