package properties;

import console.ConsolePrinter;
import menu.MenuProperties;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class PropertiesCreateFolder {

    ConsolePrinter consolePrinter = new ConsolePrinter();

    public int createFolder(String userPath) {
        int userChoice = 1;
        if (Files.notExists(Paths.get(userPath))) {
            consolePrinter.printLine("\nFolder nie istnieje. Czy utworzyć ? 1. tak |  2. nie");
            userChoice = new MenuProperties().yesNo();
            if (userChoice == 1) {

                try {
                    Files.createDirectories(Paths.get(userPath));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                consolePrinter.printLine("Scieżka nie została utworzona");

            }
        }
        return userChoice;
    }
}
