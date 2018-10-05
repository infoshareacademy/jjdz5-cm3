package com.isa.cm3.delegations;

import javax.enterprise.context.ApplicationScoped;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.format.DateTimeFormatter;

@ApplicationScoped
public class Settings {

    private final Path path = Paths.get(System.getProperty("jboss.server.data.dir"), "delegations.txt");

    private final DateTimeFormatter formater = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public Path getPath() {
        return path;
    }

    private final Path uploadDir = Paths.get(System.getProperty("jboss.server.data.dir"),"upload/");

    public Path getUploadDir() {
        return uploadDir;
    }

    public DateTimeFormatter getFormater() {
        return formater;
    }
}
