package menu;

import console.ConsolePrinter;
import properties.Properties;

public class MenuProperties extends Menu {

    private ConsolePrinter consolePrinter = new ConsolePrinter();
    Properties properties = new Properties();


    public MenuProperties() {

    }

    @Override
    public void showMenu() {
        consolePrinter.printLine("To jest menu ustawień");
        consolePrinter.printLine("1. Ustaw domyślny kraj | 2. Domyślny folder | 9. Powrót do głównego menu.Menu | 0. Wyjście z programu");

        this.goMenu(isChoiceNumber());
    }


    /*metoda sprawdza jak liczba z menu została wybrana i tworzy odpowiedni obiekt w zależności od wyboru */

    @Override
    public void goMenu(int userChoice) {
        while (userChoice != 1 && userChoice != 2 && userChoice != 0 && userChoice != 9) {
            consolePrinter.printLine("Wybór spoza zakresu. Wybierz jeszcze raz");
            userChoice = isChoiceNumber();
        }

        switch (userChoice) {

            case 1:
                properties.defaultCountry();
                break;
            case 2:
                properties.propertiesFolder();
                break;
            default:
                outOfProgramAndMainMenu(userChoice);
                break;

        }

    }

}
