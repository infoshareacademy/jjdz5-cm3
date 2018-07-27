package delegations;

import console.ConsolePrinter;
import console.ConsoleReader;

import java.util.List;


public class DelegationChangeStatus {
    private final ConsolePrinter consolePrinter = new ConsolePrinter();
    private final ConsoleReader consoleReader = new ConsoleReader();
    private final DelegationRepository delegationRepository = new DelegationRepository();
    private final DelegationPreview delegationPreview = new DelegationPreview();

    public void delegationChangeStatus() {
        List<Delegation> delegationsAll = delegationPreview.getDelegationsAll();
        List<Delegation> delegationsToAccept = delegationPreview.getDelegationsToAccept();

        Delegation delegation;
        Integer delegationDecision;
        Integer rowNumber;
        while (true) {
            delegationPreview.delegationPreview(2);

            if (delegationsToAccept.size() == 0) {
                consolePrinter.printLine("||");
                consolePrinter.printLine("|| Brak delegacji do akceptacji lub odrzucenia");
                consolePrinter.printLine("||");

                return;
            }

            consolePrinter.printLine("Aby wybrać delegację podaj jej nr ID i naciśnij ENTER.");
            consolePrinter.printLine("| 0 Rezygnacja ze zmian i powrót do Menu Delegacje |");
            rowNumber = consoleReader.getInt();

            if (rowNumber == 0) {
                return;
            }
            if (rowNumber > delegationsAll.size()) {
            } else {
                delegation = delegationsAll.get(rowNumber - 1);

                int counter = 0;

                for (Delegation p : delegationsToAccept) {
                    if (rowNumber.equals(p.getFileLineNumber())) {
                        counter++;
                    }
                }
                if (counter == 0) {
                    consolePrinter.printLine("Brak delegacji o nr ID: " + rowNumber);
                    delegationChangeStatus();
                    return;
                } else {
                    consolePrinter.printLine("| 1. Akceptuj delegację");
                    consolePrinter.printLine("| 2. Odrzuć delegację");
                    consolePrinter.printLine("| 9. Zrezygnuj z akcji");
                }

                delegationDecision = consoleReader.getInt();

                switch (delegationDecision) {
                    case 9:
                        delegationChangeStatus();
                        return;
                    //    break;
                    case 1:
                        delegation.setDelegationStatus(DelegationStatus.ACCEPTED);
                        delegationRepository.changeDelegationStatus(delegation);
                        consolePrinter.printLine("| Delegacja została zaakceptowana");
                        delegationPreview.delegationPreview(2);
                        return;
                    //   break;
                    case 2:
                        delegation.setDelegationStatus(DelegationStatus.DISCARTED);
                        delegationRepository.changeDelegationStatus(delegation);
                        consolePrinter.printLine("| Delegacja została odrzucona");
                        delegationPreview.delegationPreview(2);
                        return;
                    //    break;
                    default:
                        consolePrinter.printLine("| Wpisano niepoprawny numer decyzji");
                        consolePrinter.printLine("| 1. aby zaakceptować" );
                        consolePrinter.printLine("| 2. aby odrzucić wniosek delegacyjny");
                        delegationChangeStatus();
                        break;

                }
            }
        }
    }
}
