public class PropertiesMenu extends Menu {

//    public static void clearScreen() {
////        System.out.print("\033[H\033[2J");
////        System.out.flush();
////    }

    public PropertiesMenu() {
        System.out.println("To jest menu ustawień");
        System.out.println("1. Ustaw domyślny kraj | 2. Domyślny folder | 9. Powrót do głównego Menu | 0. Wyjście z programu");

        goMenu(isChoiceNumber());

    }


    /*metoda sprawdza jak liczba z menu została wybrana i tworzy odpowiedni obiekt w zależności od wyboru */
    @Override
    public void goMenu(int choice) {
        while (choice != 1 && choice != 2 && choice != 0 && choice != 9) {
            System.out.println("Wybór spoza zakresu. Wybierz jeszcze raz");
            choice = isChoiceNumber();
        }

        Properties properties = new Properties();

        if (choice == 1) {
            properties.defaultCountry();
        } else if (choice == 2) {
            properties.propertiesFolder();
        } else outOfProgramandMainMenu(choice);
    }

}
