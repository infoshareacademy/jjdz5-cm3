package properties;

import console.ConsoleClearScreen;
import console.ConsolePrinter;
import console.ConsoleReader;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

public class PropertiesSetFolder {

    private ConsolePrinter consolePrinter = new ConsolePrinter();
    private ConsoleReader consoleReader = new ConsoleReader();
    private ConsoleClearScreen consoleClearScreen = new ConsoleClearScreen();
    private PropertiesCreateFolder propertiesCreateFolder = new PropertiesCreateFolder();
    private PropertiesMoveDelegation propertiesMoveDelegation = new PropertiesMoveDelegation();
    private PropertiesWindowsDiscs propertiesWindowsDiscs = new PropertiesWindowsDiscs();
    private File[] discs;


    public void defaultFolder() {

        String userPath = "";

        if (System.getProperty("os.name").toLowerCase().contains("windows")) {
            discs = propertiesWindowsDiscs.windowsDiscs();
            consolePrinter.printLine("Podaj ścieżkę - tylko foldery bez nazwy pliku i musi się kończyć zankiem \"\\\" np.: c:\\delegacje\\ (przerwanie operacji wybierz 3) :");
            userPath = consoleReader.getString();
            if (userPath.equalsIgnoreCase("3")) {
                return;
            }
        } else {
            discs = File.listRoots();
            consolePrinter.printLine("Twój system to linux - dlatego twoja ścieżka będzie zaczynać sie od" + System.getProperty("user.home") + "/");
            consolePrinter.printLine("podajesz tylko katalogi bez nazwy pliku");
            consolePrinter.printLine("np.:  jeżeli wpiszesz delegacje/   to twoja scieżka będzie taka: " + System.getProperty("user.home") + "/delegacje/delegations.txt");
            userPath = consoleReader.getString();
            if (userPath.equalsIgnoreCase("3")) {
                return;
            }
        }


        if (System.getProperty("os.name").toLowerCase().contains("windows")) {
            while (true) {

                if (userPath.equalsIgnoreCase("3")) {
                    return;
                }

                if (!userPath.matches("[a-z A-Z]\\:\\\\.*\\\\$")) {
                    consolePrinter.printLine("Błąd - ścieżka musi się zaczynać od jednego z możliwych do wyboru dysków: " + Arrays.toString(discs) + " i kończyć znakiem \"\\\" np.: c:\\delegacje\\ ");
                    consolePrinter.printLine("Podaj ścieżkę jeszcze raz:");
                    userPath = consoleReader.getString();
                    if (userPath.equalsIgnoreCase("3")) {
                        return;
                    }
                    continue;
                }

                if (!Arrays.toString(discs).contains(userPath.substring(0, 2).toUpperCase())) {
                    consolePrinter.printLine("blad brak takiego dysku: Możliwy wybór to: " + Arrays.toString(discs));
                    userPath = consoleReader.getString();
                    if (userPath.equalsIgnoreCase("3")) {
                        return;
                    }
                    continue;
                }

                break;
            }
        } else {
            while (true) {

                if (userPath.equalsIgnoreCase("3")) {
                    return;
                }

                if (!userPath.matches("[a-zA-Z0-9].*/$")) {
                    consolePrinter.printLine("ścieżka nie może zaczynać się od / i musi kończyc się / . Podaj ścieżkę ");
                    consolePrinter.printLine("podajesz tylko katalogi bez nazwy pliku");
                    consolePrinter.printLine("np.:  jeżeli wpiszesz delegacje/   to twoja scieżka będzie taka: " + System.getProperty("user.home") + "/delegacje/delegations.txt");
                    userPath = consoleReader.getString();
                    if (userPath.equalsIgnoreCase("3")) {
                        return;
                    }
                    continue;
                }

                userPath = System.getProperty("user.home") + "/" + userPath;
                break;
            }
        }

        if (propertiesCreateFolder.createFolder(userPath) == 1) {
            propertiesMoveDelegation.moveDlegation(userPath);
            Properties.userDelegationPath = Paths.get(userPath, Properties.FILE_NAME);
            consoleClearScreen.clrscr();
            consolePrinter.printLine("Scieżka ustawiona na: " + Properties.userDelegationPath);
        }

        if (Files.notExists(Properties.userDelegationPath)) {
            try {
                Files.createFile(Properties.userDelegationPath);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}





