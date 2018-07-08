public class DelegationMenu extends Menu {

    /*
     * Dodaj poniżej kolejny punkt menu dodając kolejną linię i odpowiedni kolejny numer
     *
     * !!!! Pamiętaj aby ddoać wpis w metodzie goMenu
     *
     * */
    public DelegationMenu() {
        System.out.println("---------MENU DELEGACJE---------");
        System.out.println("Wybierz liczbę żeby wejść w:");
        System.out.println("1. Dodaj delegację | 2. Wyświetl delegacje | 3. Zaakceptuj delegację | 4. Odrzuć delegację | ");
        System.out.println("5. cos tam cos tam | 9. Powrót do głównego Menu | 0. wyjście z programu");

        goMenu(isChoiceNumber());
    }


    /*metoda sprawdza jak liczba z menu została wybrana i tworzy odpowiedni obiekt w zależności od wyboru */
    @Override
    public void goMenu(int choice) {

        while (choice != 1 && choice != 2 && choice != 3 && choice != 4 && choice != 5 && choice != 0 && choice != 9) {
            System.out.println("Wybór spoza zakresu. Wybierz jeszcze raz");
            choice = isChoiceNumber();
        }
        Delegation delegation = new Delegation();
        if (choice == 1) {
            delegation.addDelegation();
        } else if (choice == 2) {
            delegation.previewDelegation();
        } else if (choice == 3) {
            delegation.acceptDelegation();
        } else if (choice == 4) {
            delegation.discardDelegation();
        } else if (choice == 5) {
            delegation.discardDelegation();
        } else outOfProgramandMainMenu(choice);
    }
}
