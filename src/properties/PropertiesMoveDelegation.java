package properties;

import console.ConsolePrinter;
import menu.MenuProperties;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.List;


public class PropertiesMoveDelegation {
    private ConsolePrinter consolePrinter = new ConsolePrinter();

    public boolean isNotEmpty() {
        boolean bool = true;

        try {
            Path path = Properties.userDelegationPath;
            List<String> lista = Files.readAllLines(path, StandardCharsets.ISO_8859_1);
            bool = false;
            for (String s : lista) {
                if (s.trim().length() > 1) {
                    bool = true;
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println(e);
        }
        return bool;
    }

    public void moveDlegation(String userPath) {
        boolean bool = Files.exists(Properties.userDelegationPath);
        if (bool && isNotEmpty()) {
            consolePrinter.printLine("W poprzedniej lokalizacji jest plik z delegacjiami. Czy przenieść do nowej lokalizacji? ");
            consolePrinter.printLine("Jeżeli wybierzesz \"nie\" stary plik nadal będzie dostępny w poprzedniej lokalizcaji ");
            consolePrinter.printLine("1. Tak | 2. Nie");
            int userChoice = new MenuProperties().yesNo();
            if (userChoice == 1) {
                try {
                    Path tempPath = Paths.get(userPath, Properties.FILE_NAME);
                    if (Files.exists(tempPath)) {
                        consolePrinter.printLine("Istnieje już plik w tej lokalizacji 1.nadpisanie | 2. zostawienie ");
                        userChoice = new MenuProperties().yesNo();
                        if (userChoice == 1) {
                            Files.deleteIfExists(tempPath);
                        } else {
                            String oldDelegation = "delegation_old_" + LocalDateTime.now() + "_.txt";
                            Path oldPath = Paths.get(userPath, oldDelegation);
                            Files.move(tempPath, oldPath);
                        }
                    }
                    Files.move(Properties.userDelegationPath, tempPath);

                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {

                Path tempPath = Paths.get(userPath, Properties.FILE_NAME);
                if (Files.exists(tempPath)) {
                    consolePrinter.printLine("Istnieje już plik w tej lokalizacji 1.nowy pusty plik | 2. zostawienie ");
                    userChoice = new MenuProperties().yesNo();
                    if (userChoice == 1) {
                        try {
                            Files.deleteIfExists(tempPath);
                            Files.createFile(tempPath);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                    } else {
                        return;
                    }
                    return;

                } else {
                    try {
                        Files.deleteIfExists(Properties.userDelegationPath);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
