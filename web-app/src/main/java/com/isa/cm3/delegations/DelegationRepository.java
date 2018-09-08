package com.isa.cm3.delegations;

import javax.enterprise.context.ApplicationScoped;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class DelegationRepository {

    public static List<Delegation> list = new ArrayList<>();
    private static Integer delegationInicialId = loadId();
    private Integer delegationId = getDelegationInicialId();

    public static Integer loadId() {
        Integer i = 1;
        Path path = Paths.get(System.getProperty("jboss.server.data.dir"), "delegations.txt");
        try {
            Reader reader = Files.newBufferedReader(path, StandardCharsets.UTF_8);


            if (((BufferedReader) reader).readLine() == null) {
                return 1;
            } else {
                do {
                    i++;
                }
                while (((BufferedReader) reader).readLine() != null);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return i;

    }

    public static List<Delegation> getList() {
        return list;
    }

    public Integer getDelegationInicialId() {
        return delegationInicialId;
    }

    public Integer getDelegationId() {
        return delegationId;
    }

    public void setDelegationId(Integer delegationId) {
        this.delegationId = delegationId + 1;
    }
}
