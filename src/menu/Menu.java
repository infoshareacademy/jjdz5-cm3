package menu;

import console.ConsolePrinter;
import console.ConsoleReader;


public abstract class Menu {

    public abstract void showMenu();

    public abstract void goMenu(int choice);

    private ConsolePrinter consolePrinter = new ConsolePrinter();

    ConsoleReader consoleReader = new ConsoleReader ();

    /*metoda sprawdza czy klieny wpisał lczbę całkowitą - jak nie to czeka do skutku */
    public int isChoiceNumber() {

        String userChoice = "";

        while (true) {
            userChoice = consoleReader.readLine();
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


}


