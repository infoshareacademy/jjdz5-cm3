package menu;

import console.ConsolePrinter;
import console.ConsoleReader;

public abstract class Menu {

    private ConsolePrinter consolePrinter = new ConsolePrinter();
    private ConsoleReader consoleReader = new ConsoleReader();

    public abstract void showMenu();

    public abstract void goMenu(int choice);

    /*metoda sprawdza czy klieny wpisał lczbę całkowitą - jak nie to czeka do skutku */
    public int isChoiceNumber() {

        String userChoice = "";

        while (true) {
            userChoice = consoleReader.getString();
            if (userChoice.matches("[0-9]")) {
                break;
            } else {
                consolePrinter.printLine("Podałeś złą wartość - wpisz jeszcze raz");
            }
        }
        return Integer.parseInt(userChoice);
    }


    /* metoda sprawdza czy było wybrane 0 lub 9 i odpowiednio przenosi do menu.MenuMain lub kończy program*/
    public void outOfProgramAndMainMenu(int choice) {
        if (choice == 0) {
            consolePrinter.printLine("Dziękujemy za skorzystanie z programu. Zapraszamy ponownie.");
            System.exit(0);
        } else {
            MenuMain menuMain = new MenuMain();
            menuMain.menuMainRun();
        }
    }

    public int yesNo() {

        int userChoice = isChoiceNumber();
        while (userChoice != 1 && userChoice != 2) {
            consolePrinter.printLine("Wybór spoza zakresu");
            userChoice = isChoiceNumber();
        }
        return userChoice;
    }
}


