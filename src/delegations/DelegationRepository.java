package delegations;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import console.ConsolePrinter;
import console.ConsoleReader;
import delegations.*;

public class DelegationRepository {

    public final static List<Delegation> listDelegations = new ArrayList<>();

    ConsoleReader consoleReader = new ConsoleReader();
    ConsolePrinter consolePrinter = new ConsolePrinter();

    public void addListDelegation(Delegation delegation) {
        listDelegations.add( delegation );
    }

    public void addDelegation(Delegation delegation) {


        Integer intFromUser = consoleReader.getInt();

        switch (intFromUser) {

            case 1:
                String fileName = "/home/monika/development/jjdz5-cm3/paths/data/delegation.txt";
                File file = new File( fileName );

            try (

                    FileWriter fileWriter = new FileWriter( file, true );
                    BufferedWriter writer = new BufferedWriter( fileWriter );
            ) {
                writer.write( String.valueOf( delegation ) );
                writer.newLine();

            } catch (IOException e) {
                e.printStackTrace();
            }

            break;

            case 2:
                consolePrinter.printLine("Odrzucasz delegacje");
                break;

        }

    }
}

