package menu;

import console.ConsolePrinter;
import properties.PropertiesSetCountry;
import properties.PropertiesSetFolder;
import properties.PropertiesView;

public class MenuProperties extends Menu {

    private ConsolePrinter consolePrinter = new ConsolePrinter();
    PropertiesSetCountry propertiesSetCountry = new PropertiesSetCountry();
    PropertiesSetFolder propertiesSetFolder = new PropertiesSetFolder();
    PropertiesView propertiesView = new PropertiesView();


    public MenuProperties() {

    }

    @Override
    public void showMenu() {
        System.out.println();
        consolePrinter.printLine("To jest menu ustawień");
        consolePrinter.printLine("1. Ustaw domyślny kraj | 2. Domyślny folder | 3. Pokaż ustawienia 9. Powrót do głównego menu.Menu | 0. Wyjście z programu");

        this.goMenu(isChoiceNumber());
    }


    /*metoda sprawdza jak liczba z menu została wybrana i tworzy odpowiedni obiekt w zależności od wyboru */

    @Override
    public void goMenu(int userChoice) {
        while (userChoice != 1 && userChoice != 2 && userChoice != 3 && userChoice != 0 && userChoice != 9) {
            consolePrinter.printLine("Wybór spoza zakresu. Wybierz jeszcze raz");
            userChoice = isChoiceNumber();
        }

        switch (userChoice) {

            case 1:
                propertiesSetCountry.defaultCountry();
                break;
            case 2:
                propertiesSetFolder.defaultFolder();
                break;
            case 3:
                propertiesView.showProperties();
                break;
            default:
                outOfProgramAndMainMenu(userChoice);
                break;
        }

        showMenu();
    }

}
