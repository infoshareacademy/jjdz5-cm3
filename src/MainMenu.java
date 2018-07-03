import java.util.Properties;

public class MainMenu extends Menu {



    public MainMenu() {
        System.out.println("---------------Program do obsługi delegacji---------------");
        System.out.println(" #     #  #####  #  #      #     #     #  #####  #      #  #     # ");
        System.out.println(" # # # #  #   #     # #    #     # # # #  #      # #    #  #     # ");
        System.out.println(" #  #  #  #####  #  #  #   #     #  #  #  ###    #  #   #  #     # ");
        System.out.println(" #     #  #   #  #  #   #  #     #     #  #      #   #  #  #     # ");
        System.out.println(" #     #  #   #  #  #    # #     #     #  #####  #    # #   # # #   ");

        System.out.println("\n Wybierz liczbę żeby wejść w:");
        System.out.println("\n 1. Delegacje | 2. Ustawienia | 0. wyjście z programu");
    }


    @Override
    public void goMenu(int choice) {

        while (choice != 1 && choice != 2 && choice != 0) {
            System.out.println("Wybór spoza zakresu. Wybierz jeszcze raz");
            choice = isChoiceNumber();
        }
        if (choice == 1) {
            Menu delegationMenu = new DelegationMenu();
        } else if (choice == 2) {
            Menu propertiesMenu = new PropertiesMenu();
        } else if (choice == 0) {
            System.exit(1);
        }
    }



}
