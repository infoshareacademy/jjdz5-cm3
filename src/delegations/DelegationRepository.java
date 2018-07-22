package delegations;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import delegations.*;

public class DelegationRepository {
    
    public final static List<Delegation> listDelegations = new ArrayList<> ();
    
    public void addListDelegation(Delegation delegation) {
        listDelegations.add( delegation );

        String fileName = "/home/monika/development/jjdz5-cm3/paths/data/delegation.txt";
        File file = new File(fileName);

        try (
        FileWriter fileWriter = new FileWriter(file, true );
        BufferedWriter writer = new BufferedWriter(fileWriter);
        ) {
            writer.write( String.valueOf( listDelegations ) );
            writer.newLine();

        } catch(IOException e) {
            e.printStackTrace();
        }


    }
}

