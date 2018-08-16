package com.isa.cm3.delegations;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class DelegationRepository {

    Path path = Paths.get(System.getProperty("jboss.server.data.dir"),"delegations.txt");

    public static List<Delegation> list = new ArrayList<>();

    public void loadList (Delegation delegation){

        try {
            Reader reader = Files.newBufferedReader(path,StandardCharsets.UTF_8);
            ((BufferedReader) reader).readLine()
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static List<Delegation> getList() {
        return list;
    }
}
