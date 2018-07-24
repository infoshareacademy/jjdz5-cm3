package menu;

import console.ConsoleClearScreen;
import console.ConsolePrinter;
import properties.PropertiesSetCountry;
import properties.PropertiesSetFolder;
import properties.PropertiesView;

public class MenuProperties extends Menu {

    private PropertiesSetCountry propertiesSetCountry = new PropertiesSetCountry();
    private PropertiesSetFolder propertiesSetFolder = new PropertiesSetFolder();
    private PropertiesView propertiesView = new PropertiesView();
    private ConsoleClearScreen consoleClearScreen = new ConsoleClearScreen();
    private ConsolePrinter consolePrinter = new ConsolePrinter();


    public MenuProperties() {

    }

    @Override
    public void showMenu() {
        consoleClearScreen.clrscr();
        consolePrinter.printLine("================================");
        consolePrinter.printLine("=        MENU USTAWIENIA       =");
        consolePrinter.printLine("================================");
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
                new MenuSetProperties().MenuChange(userChoice);
                propertiesSetCountry.defaultCountry();
                break;
            case 2:
                new MenuSetProperties().MenuChange(userChoice);
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

    @Override
    public int yesNo() {
        return super.yesNo();
    }
}
