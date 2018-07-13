package menu;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import delegations.*;

public class DelegationMenu extends Menu {

    List<Delegation> listDelegations = new ArrayList<> ();

    private AddDelegation addDelegationService = new AddDelegation();
    private AcceptDelegation acceptDelegation = new AcceptDelegation();
    private DiscardDelegation discardDelegation = new DiscardDelegation();
    private PreviewDelegation previewDelegation = new PreviewDelegation();



    /*
     * Dodaj poniżej kolejny punkt menu dodając kolejną linię i odpowiedni kolejny numer
     *
     * !!!! Pamiętaj aby ddoać wpis w metodzie goMenu
     *
     * */
    public DelegationMenu() {

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
            addDelegationService.addDelegation ();
        } else if (choice == 2) {
            previewDelegation.previewDelegationRun (delegation);

        } else if (choice == 3) {
            acceptDelegation.acceptDelegation ();
        } else if (choice == 4) {
            discardDelegation.discardDelegation ();
        } else if (choice == 0 || choice == 9) {
            outOfProgramAndMainMenu (choice) ;
        }
        showMenu ();
    }

}

