package delegations;

import console.ConsolePrinter;
import console.ConsoleReader;

import java.util.List;

public class DelegationAccept {
    private final DelegationFilteredPreview delegationFilteredPreview = new DelegationFilteredPreview();
    private final ConsolePrinter consolePrinter = new ConsolePrinter();
    private final ConsoleReader consoleReader = new ConsoleReader();
    private final DelegationRepository delegationRepository = new DelegationRepository();


    public void delegationAccept() {
        List<Delegation> delegations = delegationFilteredPreview.getDelegations();
        delegationFilteredPreview.delegationPreview();

        consolePrinter.printLine("Wybierz delegację wprowadzając numer wiersza:");
        Integer rowNumber = consoleReader.getInt(1,delegations.size());

        Delegation delegation = delegations.get(rowNumber - 1);

        consolePrinter.printLine("Wpisz \"A\", aby zaakceptować lub \"O\", aby odrzucić wniosek delegacyjny");
        validationLoop:
        while (true){
            String delegationDecision = consoleReader.getString();
            switch (delegationDecision) {
                case "A":
                    delegation.setDelegationStatus(DelegationStatus.ACCEPT);
                    consolePrinter.printLine("Delegacja została zaakceptowana.");
                    break validationLoop;
                case "O":
                    delegation.setDelegationStatus(DelegationStatus.DISCRD);
                    consolePrinter.printLine("Delegacja została odrzucona.");
                    break validationLoop;
                default:
                    consolePrinter.printLine("Podano zły znak decyzji. Podaj znak: \"A\", aby zaakceptować lub \"O\", aby odrzucić wniosek delegacyjny");
            }
        }
        delegationRepository.changeDelegationStatus(delegation);
    }
}
