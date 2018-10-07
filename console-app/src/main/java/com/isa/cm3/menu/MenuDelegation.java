package com.isa.cm3.menu;


import com.isa.cm3.console.ConsoleClearScreen;
import com.isa.cm3.console.ConsolePrinter;
import com.isa.cm3.delegations.DelegationAdd;
import com.isa.cm3.delegations.DelegationChangeStatus;
import com.isa.cm3.delegations.DelegationPreview;

public class MenuDelegation extends Menu {

    private ConsolePrinter consolePrinter = new ConsolePrinter();
    private DelegationAdd addDelegationService = new DelegationAdd();
    private DelegationChangeStatus delegationChangeStatus = new DelegationChangeStatus();
    private DelegationPreview previewDelegation = new DelegationPreview();
    private ConsoleClearScreen consoleClearScreen = new ConsoleClearScreen();


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
        consolePrinter.printLine("================================");
        consolePrinter.printLine("=        MENU DELEGACJE        =");
        consolePrinter.printLine("================================");
        consolePrinter.printLine("Wybierz liczbę żeby wejść w:");
        consolePrinter.printLine("| 1. Dodaj delegację" );
        consolePrinter.printLine("| 2. Wyświetl delegacje ");
        consolePrinter.printLine("| 3. Zaakceptuj lub odrzuć delegację");
        consolePrinter.printLine("| 9. Powrót do głównego Menu");
        consolePrinter.printLine("| 0. wyjście z programu");

        goMenu(isChoiceNumber());

    }

    /*metoda sprawdza jak liczba z menu została wybrana i tworzy odpowiedni obiekt w zależności od wyboru */

    @Override
    public void goMenu(int userChoice) {

        while (userChoice != 1 && userChoice != 2 && userChoice != 3 && userChoice != 0 && userChoice != 9) {
            consolePrinter.printLine("| Wybór spoza zakresu. Wybierz jeszcze raz");
            userChoice = isChoiceNumber();
        }

        switch (userChoice) {
            case 1:
                addDelegationService.delegationAdd();
                break;
            case 2:
                previewDelegation.delegationPreview(1);
                break;
            case 3:
                delegationChangeStatus.delegationChangeStatus();
                break;
            default:
                outOfProgramAndMainMenu(userChoice);
                break;
        }
        showMenu();
    }
}
