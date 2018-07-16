package properties;

import console.ConsolePrinter;
import console.ConsoleReader;
import menu.MenuProperties;

public class PropertiesSetCountry {

    ConsolePrinter consolePrinter = new ConsolePrinter();
    ConsoleReader consoleReader = new ConsoleReader();
    //MenuDelegation menuDelegation = new MenuDelegation();


    public void defaultCountry() {

        consolePrinter.printLine("Obecnie domyślny kraj to: " + Properties.userDelegationCountry);
        consolePrinter.printLine("1. Zmiana | 2. Powrót");

        int userChoice = new MenuProperties().isChoiceNumber();

        while (userChoice != 1 && userChoice != 2) {
            consolePrinter.printLine("Wybór spoza zakresu");
        }

        switch (userChoice) {
            case 1:
                consolePrinter.printLine("Podaj kraj:");
                Properties.userDelegationCountry = consoleReader.readLine();
                break;
            default:
               new MenuProperties().showMenu();
                break;
        }
    }
}
