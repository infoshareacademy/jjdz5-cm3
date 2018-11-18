package com.isa.cm3.delegations;

import javax.enterprise.context.ApplicationScoped;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.format.DateTimeFormatter;

@ApplicationScoped
public class Settings {

    private final Path path = Paths.get(System.getProperty("jboss.server.data.dir"), "delegations.txt");
    private final DateTimeFormatter dateFormater = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private final Path uploadDir = Paths.get(System.getProperty("jboss.server.data.dir"), "upload/");

    public Path getPath() {
        return path;
    }

    public Path getUploadDir() {
        return uploadDir;
    }

    public DateTimeFormatter getFormater() {
        return dateFormater;
    }
}
