package com.isa.cm3.properties;



import com.isa.cm3.console.ConsolePrinter;
import com.isa.cm3.menu.MenuProperties;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class PropertiesCreateFolder {

    private ConsolePrinter consolePrinter = new ConsolePrinter();

    /**
     * Metoda sprawdza czy w wybrany przez klienta folder istnieje
     * Jeżeli nie to czy dodać
     * @param userPath string z podaną przez klienta ścieżką
     * @return userChoice jako int
     */

    public int createFolder(String userPath) {
        int userChoice = 1;
        if (Files.notExists(Paths.get(userPath))) {
            consolePrinter.printLine("\nFolder nie istnieje.");
            consolePrinter.printLine("| Czy utworzyć?");
            consolePrinter.printLine("| 1. tak |  2. nie |");
            userChoice = new MenuProperties().yesNo();
            if (userChoice == 1) {

                try {
                    Files.createDirectories(Paths.get(userPath));

                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                consolePrinter.printLine("| Scieżka nie została utworzona");
            }
        }
        return userChoice;
    }
}
