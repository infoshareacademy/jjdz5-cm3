package menu;

import menu.DelegationMenu;
import menu.Menu;
import menu.PropertiesMenu;

public class MainMenu extends Menu {


    /*
     * Dodaj poniżej kolejny punkt menu dodając kolejną linię i odpowiedni kolejny numer
     *
     * !!!! Pamiętaj aby ddoać wpis w metodzie goMenu
     *
     * */
    public MainMenu() {

    }

    @Override
    public void showMenu() {
        System.out.println("---------------Program do obsługi delegacji---------------");
        System.out.println(" #     #  #####  #  #      #     #     #  #####  #      #  #     # ");
        System.out.println(" # # # #  #   #     # #    #     # # # #  #      # #    #  #     # ");
        System.out.println(" #  #  #  #####  #  #  #   #     #  #  #  ###    #  #   #  #     # ");
        System.out.println(" #     #  #   #  #  #   #  #     #     #  #      #   #  #  #     # ");
        System.out.println(" #     #  #   #  #  #    # #     #     #  #####  #    # #   # # #   ");

        System.out.println("\n Wybierz liczbę żeby wejść w:");
        System.out.println("\n 1. Delegacje | 2. Ustawienia | 0. wyjście z programu");
    }

    /*metoda sprawdza jak liczba z menu została wybrana i tworzy odpowiedni obiekt w zależności od wyboru */
    @Override
    public void goMenu(int choice) {

        while (choice != 1 && choice != 2 && choice != 0) {
            System.out.println("Wybór spoza zakresu. Wybierz jeszcze raz");
            choice = isChoiceNumber();
        }
        if (choice == 1) {
            Menu delegationMenu = new DelegationMenu();
            delegationMenu.showMenu();
        } else if (choice == 2) {
            Menu propertiesMenu = new PropertiesMenu();
            propertiesMenu.showMenu();
        } else if (choice == 0) {
            System.out.println("Dziękujemy za skorzystanie z programu. Zapraszamy ponownie.");
            System.exit(1);
        }
    }


}
