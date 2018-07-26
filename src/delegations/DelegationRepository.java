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

  //  public final static List<Delegation> listDelegations = new ArrayList<>();

    ConsoleReader consoleReader = new ConsoleReader();
    ConsolePrinter consolePrinter = new ConsolePrinter();

//    public void addListDelegation(Delegation delegation) {
//        listDelegations.add( delegation );
//    }

    public void changeDelegationStatus(Delegation delegation){
        File delegationFile = new File( "paths/data/delegation.txt" );
        FileReader fileReader = null;
        try {
            fileReader = new FileReader (delegationFile);
        } catch (FileNotFoundException e) {
            System.out.println( e );
        }

        StringBuilder out = new StringBuilder();
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader( fileReader );
            String line = "";
            int fileLineNumber = 0;
            while ( ( line = bufferedReader.readLine() ) != null ) {
                if (fileLineNumber == delegation.getFileLineNumber()) {
                    out.append(String.valueOf( delegation ));
                } else {
                    out.append(line);
                }
                out.append("\n");
                fileLineNumber++;
            }
        } catch  (Exception e ) {
            System.out.println( e );
        } finally {
            try {
                bufferedReader.close();
            } catch (Exception e) {
                System.out.println( e );
            }
        }

        try (

                FileWriter fileWriter = new FileWriter( delegationFile, false );
                BufferedWriter writer = new BufferedWriter( fileWriter );
        ) {
            writer.write(out.toString());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addDelegation(Delegation delegation) {


        Integer intFromUser = consoleReader.getInt(1,2);

        switch (intFromUser) {

            case 1:
                String fileName = "paths/data/delegation.txt";
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

