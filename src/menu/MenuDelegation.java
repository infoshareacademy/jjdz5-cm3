package menu;


import delegations.*;


public class MenuDelegation extends Menu {

    private DelegationAdd delegationAdd = new DelegationAdd();
    private DelegationAccept delegationAccept = new DelegationAccept ();
    private DelegationDiscard delegationDiscard = new DelegationDiscard ();
    private DelegationPreview previewDelegation = new DelegationPreview();
    
    /*
     * Dodaj poniżej kolejny punkt menu dodając kolejną linię i odpowiedni kolejny numer
     *
     * !!!! Pamiętaj aby ddoać wpis w metodzie goMenu
     *
     * */
    
    public MenuDelegation() {

    }

    @Override
    public void showMenu() {
        System.out.println("---------MENU DELEGACJE---------");
        System.out.println("Wybierz liczbę żeby wejść w:");
        System.out.println("1. Dodaj delegację | 2. Wyświetl delegacje | 3. Zaakceptuj delegację | 4. Odrzuć delegację | ");
        // tu: poprzednia / następna delegacja
        System.out.println("9. Powrót do głównego menu.Menu | 0. wyjście z programu");

        goMenu(isChoiceNumber());

    }

    /*metoda sprawdza jak liczba z menu została wybrana i tworzy odpowiedni obiekt w zależności od wyboru */
    @Override
    public void goMenu(int choice) {

        while (choice != 1 && choice != 2 && choice != 3 && choice != 4 && choice != 5 && choice != 0 && choice != 9) {
            System.out.println ("Wybór spoza zakresu. Wybierz jeszcze raz");
            choice = isChoiceNumber ();
        }

        Delegation delegation = new Delegation ();

        if (choice == 1) {
            delegationAdd.delegationAdd ();
        } else if (choice == 2) {
            previewDelegation.delegationPreview ();
        } else if (choice == 3) {
            delegationAccept.delegationAccept ();
        } else if (choice == 4) {
            delegationDiscard.delegationDiscard ();
        } else if (choice == 0 || choice == 9) {
            outOfProgramAndMainMenu (choice) ;
        }
        showMenu ();
    }

}

