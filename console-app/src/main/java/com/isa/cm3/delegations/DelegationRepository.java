package com.isa.cm3.delegations;


import com.isa.cm3.console.ConsolePrinter;
import com.isa.cm3.console.ConsoleReader;
import com.isa.cm3.properties.Properties;

import java.io.*;

public class DelegationRepository {

    private final ConsoleReader consoleReader = new ConsoleReader();
    private final ConsolePrinter consolePrinter = new ConsolePrinter();

    public void changeDelegationStatus(Delegation delegation) {

        File delegationFile = new File(Properties.userDelegationPath.toString());
        FileReader fileReader = null;

        try {
            fileReader = new FileReader(delegationFile);
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }

        StringBuilder out = new StringBuilder();
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(fileReader);
            String line = "";
            int fileLineNumber = 0;
            while ((line = bufferedReader.readLine()) != null) {
                if (fileLineNumber == delegation.getFileLineNumber() - 1) {
                    out.append(String.valueOf(delegation));
                } else {
                    out.append(line);
                }
                out.append("\n");
                fileLineNumber++;
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            try {
                bufferedReader.close();
            } catch (Exception e) {
                System.out.println(e);
            }
        }

        try (

                FileWriter fileWriter = new FileWriter(delegationFile, false);
                BufferedWriter writer = new BufferedWriter(fileWriter);
        ) {
            writer.write(out.toString());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addDelegation(Delegation delegation) {


        Integer intFromUser = consoleReader.getShortInt();

        switch (intFromUser) {

            case 1:
                String fileName = Properties.userDelegationPath.toString();
                File file = new File(fileName);
                if (file.exists ()) {
                    try (
                            FileWriter fileWriter = new FileWriter(file, true);
                            BufferedWriter writer = new BufferedWriter(fileWriter);
                    ) {
                        writer.write(String.valueOf(delegation));
                        writer.newLine();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else {
                    consolePrinter.printLine ("| Brak podanego pliku: " + file );
                    consolePrinter.printLine ("| Podaj nazwę pliku w MENU > 2. Domyślny folder > .....");
                }break;
            case 2:
                consolePrinter.printLine("Odrzucasz delegacje");
                break;
        }
    }
}

