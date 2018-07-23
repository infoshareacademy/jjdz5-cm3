package properties;

import console.ConsoleClearScreen;
import console.ConsolePrinter;
import console.ConsoleReader;

import java.io.File;
import java.nio.file.Paths;
import java.util.Arrays;

public class PropertiesSetFolder {

    ConsolePrinter consolePrinter = new ConsolePrinter();
    ConsoleReader consoleReader = new ConsoleReader();
    ConsoleClearScreen consoleClearScreen = new ConsoleClearScreen();
    PropertiesCreateFolder propertiesCreateFolder = new PropertiesCreateFolder();
    PropertiesMoveDelegation propertiesMoveDelegation = new PropertiesMoveDelegation();
    File[] discs = File.listRoots();


    public void defaultFolder() {

        String userPath = "";

        if (System.getProperty("os.name").toLowerCase().contains("windows")) {
            consolePrinter.printLine("Podaj ścieżkę:");
            userPath = consoleReader.readLine();
        }else{
            consolePrinter.printLine("Twój system to linux - dlatego twoja ścieżka będzie zaczynać sie od" + System.getProperty("user.home") + "/" );
            userPath = System.getProperty("user.home") + "/" + consoleReader.readLine();
        }

        while (true) {
            if (System.getProperty("os.name").toLowerCase().contains("windows")) {
                if (!userPath.matches("[a-z A-Z]\\:\\\\.*\\\\$")) {
                    consolePrinter.printLine("blad ścieżka musi się zaczynać od np.: c:\\ i kończyć znakiem \"\\\". Podaj ścieżkę");
                    userPath = consoleReader.readLine();
                    continue;
                }

                if (!Arrays.toString(discs).contains(userPath.substring(0, 2).toUpperCase())) {
                    consolePrinter.printLine("blad brak takiego dysku: Możliwy wybór to: " + Arrays.toString(discs));
                    userPath = consoleReader.readLine();
                    continue;
                }

                break;
            } else {
                if (!userPath.matches("^[a-zA-Z].*/$")) {
                    consolePrinter.printLine("ścieżka nie może zaczynać się od / i musi kończyc się / . Podaj ścieżkę ");
                    userPath = consoleReader.readLine();
                    continue;
                }
                break;
            }
        }

        if (propertiesCreateFolder.createFolder(userPath) == 1){
            propertiesMoveDelegation.moveDlegation(userPath);
            Properties.userDelegationPath = Paths.get(userPath, Properties.fileName);
            consoleClearScreen.clrscr();
            consolePrinter.printLine("Scieżka ustawiona na: " + Properties.userDelegationPath);
        }


    }
}



