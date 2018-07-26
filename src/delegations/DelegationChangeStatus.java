package delegations;

import console.ConsolePrinter;
import console.ConsoleReader;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DelegationChangeStatus {

    private final ConsolePrinter consolePrinter = new ConsolePrinter();
    private final ConsoleReader consoleReader = new ConsoleReader();
    private final DelegationRepository delegationRepository = new DelegationRepository();
    private final DelegationPreview delegationPreview = new DelegationPreview();


    public void delegationChangeStatus() {

        List<Delegation> delegationsAll = delegationPreview.getDelegationsAll();
        List<Delegation> delegationsToAccept = delegationPreview.getDelegationsToAccept();

        Integer rowNumber = 0;

        delegationPreview.delegationPreview(2);

        consolePrinter.printLine("Wybierz delegację wprowadzając ID i naciśnij ENTER");
        consolePrinter.printLine("| 0. Zrezygnuj ze zmian i powrót do Menu Delegacje |");
        rowNumber = consoleReader.getInt();

        if (rowNumber == 0){
            return;
        }


        Delegation delegation = delegationsAll.get(rowNumber - 1);

        int counter = 0;

        for (Delegation p : delegationsToAccept) {
            if (rowNumber.equals( p.getFileLineNumber())) {
             counter++;
            }
        }

        if (counter == 0 ){
            consolePrinter.printLine("Brak ID: " + rowNumber );
            delegationChangeStatus();
            return;
        }

        consolePrinter.printLine("1. Akceptuj delegację | 2. Nie akceptuj delegacji |");
        consolePrinter.printLine("9. Zrezygnuj |");

        while (true){

            String delegationDecision = consoleReader.getString();
            switch (delegationDecision.toUpperCase()) {
                case "9":
                    return;
                //    break;
                case "1":
                    delegation.setDelegationStatus(DelegationStatus.ACCEPTED);
                    delegationRepository.changeDelegationStatus(delegation);
                    consolePrinter.printLine("Delegacja została zaakceptowana.");
                    delegationPreview.delegationPreview(2);
                    return;
                 //   break;
                case "2":
                    delegation.setDelegationStatus(DelegationStatus.DISCARTED);
                    delegationRepository.changeDelegationStatus(delegation);
                    consolePrinter.printLine("Delegacja została odrzucona.");
                    delegationPreview.delegationPreview(2);
                    return;
                //    break;
//                default:
//                    consolePrinter.printLine("Podano zły znak decyzji. Podaj znak: \"A\", aby zaakceptować lub \"O\", aby odrzucić wniosek delegacyjny");

            }
        }
    }
}
