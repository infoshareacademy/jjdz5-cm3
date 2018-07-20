package properties;

import console.ConsolePrinter;
import menu.MenuProperties;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


public class PropertiesMoveDelegation {
    ConsolePrinter consolePrinter = new ConsolePrinter();

    public boolean isNotEmpty() {
        boolean bool = true;
        try {
            if (Files.newBufferedReader(Properties.userDelegationPath).readLine() != null) {
                bool = true;
            } else {
                bool = false;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bool;
    }

    public void moveDlegation(String userPath) {
        boolean bool = Files.exists(Properties.userDelegationPath);
        if (bool && isNotEmpty()) {
            consolePrinter.printLine("W poprzedniej lokalizacji jest plik z delegacjiami. Czy przenieść do nowej lokalizacji? ");
            consolePrinter.printLine("Jezlei wybierzesz nie stary plik nadal będzie dostępny w poprzedniej lokalizcaji ");
            consolePrinter.printLine("1. Tak | 2. Nie");
            int userChoice = new MenuProperties().yesNo();
            if (userChoice == 1) {
                try {
                    Files.move(Properties.userDelegationPath, Paths.get(userPath + Properties.fileName));
                    Files.delete(Properties.userDelegationPath);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                return;
            }
        }
    }
}
