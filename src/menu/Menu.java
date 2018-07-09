package menu;

import java.util.Scanner;

public abstract  class Menu {

    public abstract void showMenu();

    public abstract void goMenu(int choice);


    /*metoda wczytuje z konsoli liczbę */
    public int readFromConsole() {
        return new Scanner(System.in).nextInt();
    }

    /*metoda sprawdza czy klieny wpisał lczbę całkowitą - jak nie to czeka do skutku */
    public int isChoiceNumber() {

        int choice = -1;
        boolean isCorect = false;

        while (!isCorect) {

            try {
                choice = readFromConsole();
                isCorect = true;

            } catch (Exception e) {
                System.out.println("to nie jest liczba całkowita wpisz jeszcze raz");
                isCorect = false;
            }
        }
        return choice;
    }


    /* metoda sprawdza czy było wybrane 0 lub 9 i odpowiednio przenosi do menu.MainMenu lub kończy program*/
    public void outOfProgramAndMainMenu(int choice) {
        if (choice == 0) {
            System.out.println("Dziękujemy za skorzystanie z programu. Zapraszamy ponownie.");
            System.exit(1);
        } else {
            MainMenu mainMenu = new MainMenu();
            mainMenu.showMenu();
            mainMenu.goMenu(mainMenu.isChoiceNumber());
        }
    }


}


