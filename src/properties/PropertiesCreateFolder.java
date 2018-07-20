package properties;

import console.ConsolePrinter;
import menu.MenuProperties;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class PropertiesCreateFolder {

    ConsolePrinter consolePrinter = new ConsolePrinter();

    public void createFolder(String userPath) {

        if (Files.notExists(Paths.get(userPath))) {
            consolePrinter.printLine("\nFolder nie istnieje. Czy utworzyć ? 1. tak |  2. nie");
            int userChoice = new MenuProperties().yesNo();
            if (userChoice == 1) {

                try {
                    Files.createDirectories(Paths.get(userPath));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                return;
            }
        }
    }
}
