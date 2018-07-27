package menu;

import console.ConsoleClearScreen;
import console.ConsolePrinter;
import properties.PropertiesLoad;

public class MenuMain extends Menu {

    private ConsolePrinter consolePrinter = new ConsolePrinter();
    private MenuDelegation menuDelegation = new MenuDelegation();
    private MenuProperties menuProperties = new MenuProperties();
    private PropertiesLoad propertiesLoad = new PropertiesLoad();
    private ConsoleClearScreen consoleClearScreen = new ConsoleClearScreen();


    /*
     * Dodaj poniżej kolejny punkt menu dodając kolejną linię i odpowiedni kolejny numer
     *
     * !!!! Pamiętaj aby ddoać wpis w metodzie goMenu
     *
     * */
    public MenuMain() {

    }

    public void menuMainRun() {
        propertiesLoad.loadProperties();
        showMenu();
        goMenu(isChoiceNumber());
    }

    @Override
    public void showMenu() {
        System.out.println(System.getProperties());
        consoleClearScreen.clrscr();
        consolePrinter.printLine("---------------Program do obsługi delegacji---------------");
        consolePrinter.printLine(" #     #  #####  #  #      #     #     #  #####  #      #  #     # ");
        consolePrinter.printLine(" # # # #  #   #     # #    #     # # # #  #      # #    #  #     # ");
        consolePrinter.printLine(" #  #  #  #####  #  #  #   #     #  #  #  ###    #  #   #  #     # ");
        consolePrinter.printLine(" #     #  #   #  #  #   #  #     #     #  #      #   #  #  #     # ");
        consolePrinter.printLine(" #     #  #   #  #  #    # #     #     #  #####  #    # #   # # #   ");

        consolePrinter.printLine("\n Wybierz liczbę żeby wejść w:");
        consolePrinter.printLine("\n 1. Delegacje | 2. Ustawienia | 0. wyjście z programu");
    }

    /*metoda sprawdza jak liczba z menu została wybrana i tworzy odpowiedni obiekt w zależności od wyboru */
    @Override
    public void goMenu(int userChoice) {

        while (userChoice != 1 && userChoice != 2 && userChoice != 0) {
            consolePrinter.printLine("Wybór spoza zakresu. Wybierz jeszcze raz");
            userChoice = isChoiceNumber();
        }

        switch (userChoice) {
            case 1:
                menuDelegation.showMenu();
                break;
            case 2:
                menuProperties.showMenu();
                break;
            default:
                consolePrinter.printLine("Dziękujemy za skorzystanie z programu. Zapraszamy ponownie.");
                System.exit(0);
        }
    }
}

