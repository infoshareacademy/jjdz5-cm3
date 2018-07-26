package delegations;

import console.ConsolePrinter;
import console.ConsoleReader;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DelegationChangeStatus {
    private final DelegationFilteredPreview delegationFilteredPreview = new DelegationFilteredPreview();
    private final ConsolePrinter consolePrinter = new ConsolePrinter();
    private final ConsoleReader consoleReader = new ConsoleReader();
    private final DelegationRepository delegationRepository = new DelegationRepository();
    private final DelegationPreview delegationPreview = new DelegationPreview();


    public void delegationChangeStatus() {

        List<Delegation> delegationsAll = delegationPreview.getDelegationsAll();
        List<Delegation> delegationsToAccept = delegationPreview.getDelegationsToAccept();
     //   Set<Integer> listToChange = new HashSet();

        delegationPreview.delegationPreview(2);

        consolePrinter.printLine("Wybierz delegację wprowadzając numer wiersza:");
        Integer rowNumber = consoleReader.getInt();

        if (rowNumber == 0){
             return;
        }

        Delegation delegation = delegationsAll.get(rowNumber - 1);


        consolePrinter.printLine("Wpisz \"A\", aby zaakceptować lub \"B\", aby odrzucić wniosek delegacyjny \"0\" by zrezygnować ze zmian");
//        validationLoop:
        while (true){
            String delegationDecision = consoleReader.getString();
            switch (delegationDecision.toUpperCase()) {
                case "0":
                    return;
              //      break validationLoop;
                case "A":
                    delegation.setDelegationStatus(DelegationStatus.ACCEPTED);
                    delegationRepository.changeDelegationStatus(delegation);
                    consolePrinter.printLine("Delegacja została zaakceptowana.");
                    break; // validationLoop;
                case "B":
                    delegation.setDelegationStatus(DelegationStatus.DISCARTED);
                    delegationRepository.changeDelegationStatus(delegation);
                    consolePrinter.printLine("Delegacja została odrzucona.");
                    break; // validationLoop;
                default:
                    consolePrinter.printLine("Podano zły znak decyzji. Podaj znak: \"A\", aby zaakceptować lub \"O\", aby odrzucić wniosek delegacyjny");

            }
        }
    //    delegationRepository.changeDelegationStatus(delegation);
    }
}
