package properties;

import console.ConsoleClearScreen;
import console.ConsolePrinter;
import console.ConsoleReader;

public class PropertiesSetCountry {

    ConsolePrinter consolePrinter = new ConsolePrinter();
    ConsoleReader consoleReader = new ConsoleReader();
    ConsoleClearScreen consoleClearScreen = new ConsoleClearScreen();

    public void defaultCountry() {

        consolePrinter.printLine("Podaj kraj:");
        String userCountry = consoleReader.readLine();
        while (true) {
            if (userCountry.matches("[a-z A-Z]{4,100}")) {
                Properties.userDelegationCountry = userCountry;
                consoleClearScreen.pressAnyKeyToContinue();
                consoleClearScreen.clrscr();
                break;
            } else {
                consolePrinter.printLine("Nie ma takiej krótkiej nazwy kraju. Podaj jeszce raz ");
                userCountry = consoleReader.readLine();
                continue;
            }
        }
    }
}

