package properties;

import console.ConsolePrinter;
import console.ConsoleReader;
import menu.MenuProperties;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

public class PropertiesSetFolder {

    ConsolePrinter consolePrinter = new ConsolePrinter();
    ConsoleReader consoleReader = new ConsoleReader();
    File[] discs = File.listRoots();

    Properties properties = new Properties();


    public void defaultFolder() {

        consolePrinter.printLine("Obecnie domyślny folder to: " + Properties.userDelegationPath);
        consolePrinter.printLine("1. Zmiana | 2. Powrót");

        int userChoice = new MenuProperties().isChoiceNumber();

        while (userChoice != 1 && userChoice != 2) {
            consolePrinter.printLine("Wybór spoza zakresu");
        }

        switch (userChoice) {
            case 1:
                consolePrinter.printLine("Podaj folder:");
                String userPath = consoleReader.readLine();

                while (true) {

                    if (!userPath.matches("[a-z A-Z]\\:\\\\.*")) {
                        consolePrinter.printLine("blad ścieżka musi się zaczynać od np.: c:\\");
                        userPath = consoleReader.readLine();
                        continue;
                    }

                   if (!Arrays.toString(discs).contains(userPath.substring(0,2).toUpperCase())) {
                       consolePrinter.printLine("blad brak takiego dysku: Możliwy wybór to: " + Arrays.toString(discs));
                       userPath = consoleReader.readLine();
                       continue;
                   }
                   break;
                }

                Path user = Paths.get(userPath);
                Properties.userDelegationPath = user;


                consolePrinter.printLine("Scieżka ustawiona na: " + user);


            default:
                new MenuProperties().showMenu();
                break;
                }

            }







        }



