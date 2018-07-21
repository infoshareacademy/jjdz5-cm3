package menu;

import console.ConsolePrinter;
import delegations.DelegationAccept;
import delegations.DelegationAdd;
import delegations.DelegationPreview;

import java.io.IOException;

public class MenuDelegation extends Menu {

    private ConsolePrinter consolePrinter = new ConsolePrinter();
    private DelegationAdd addDelegationService = new DelegationAdd();
    private DelegationAccept acceptDelegation = new DelegationAccept();
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
        System.out.println();
        consolePrinter.printLine("---------MENU DELEGACJE---------");
        consolePrinter.printLine("Wybierz liczbę żeby wejść w:");
        consolePrinter.printLine("1. Dodaj delegację | 2. Wyświetl delegacje | 3. Zaakceptuj / odrzuć delegację | ");
        consolePrinter.printLine("9. Powrót do głównego menu.Menu | 0. wyjście z programu");

        goMenu(isChoiceNumber());

    }

    /*metoda sprawdza jak liczba z menu została wybrana i tworzy odpowiedni obiekt w zależności od wyboru */
    @Override
    public void goMenu(int userChoice) {

        while (userChoice != 1 && userChoice != 2 && userChoice != 3 && userChoice != 0 && userChoice != 9) {
            consolePrinter.printLine("Wybór spoza zakresu. Wybierz jeszcze raz");
            userChoice = isChoiceNumber();
        }

        switch (userChoice) {
            case 1:
                addDelegationService.delegationAdd();
                break;
            case 2:
                previewDelegation.delegationPreview();
                break;
            case 3:
                acceptDelegation.delegationAccept();
                break;
            default:
                outOfProgramAndMainMenu(userChoice);
                break;
        }
        showMenu();

    }
}
