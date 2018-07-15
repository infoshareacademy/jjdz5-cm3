package menu;

import console.ConsolePrinter;

import java.util.Scanner;

public abstract  class Menu {

    public abstract void showMenu();

    public abstract void goMenu(int choice);

    private ConsolePrinter consolePrinter = new ConsolePrinter();


    /*metoda wczytuje z konsoli liczbę */
    public int readFromConsole() {
        return new Scanner(System.in).nextInt();
    }

    /*metoda sprawdza czy klieny wpisał lczbę całkowitą - jak nie to czeka do skutku */
    public int isChoiceNumber() {

        int userChoice = -1;
        boolean isCorect = false;

        while (!isCorect) {

            try {
                userChoice = readFromConsole();
                isCorect = true;

            } catch (Exception e) {
                consolePrinter.printLine("to nie jest liczba całkowita wpisz jeszcze raz");
                isCorect = false;
            }
        }
        return userChoice;
    }


    /* metoda sprawdza czy było wybrane 0 lub 9 i odpowiednio przenosi do menu.MenuMain lub kończy program*/
    public void outOfProgramAndMainMenu(int choice) {
        if (choice == 0) {
            consolePrinter.printLine("Dziękujemy za skorzystanie z programu. Zapraszamy ponownie.");
            System.exit(1);
        } else {
            MenuMain menuMain = new MenuMain();
            menuMain.showMenu();
            menuMain.goMenu(menuMain.isChoiceNumber());
        }
    }


}


