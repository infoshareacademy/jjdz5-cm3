package com.isa.cm3.delegations;

import javax.enterprise.context.ApplicationScoped;
import java.nio.file.Path;
import java.nio.file.Paths;

@ApplicationScoped
public class Settings {

    private final Path path = Paths.get(System.getProperty("jboss.server.data.dir"), "delegations.txt");

    public Path getPath() {
        return path;
    }
}
