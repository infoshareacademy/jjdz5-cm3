package delegations;

import console.ConsolePrinter;
import console.ConsoleReader;
import properties.Properties;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class DelegationRepository {

    private final ConsoleReader consoleReader = new ConsoleReader();
    private final ConsolePrinter consolePrinter = new ConsolePrinter();

    public void addDelegation(Delegation delegation) {

        Integer intFromUser = consoleReader.getInt();

        switch (intFromUser) {

            case 1:
                String fileName = Properties.userDelegationPath.toString();
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

