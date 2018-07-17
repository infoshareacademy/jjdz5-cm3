package delegations;


import console.ConsolePrinter;

public class DelegationPreview {

    private final DelegationReadFile delegationReadFile = new DelegationReadFile ();
    private final DelegationRepository delegationRepository = new DelegationRepository ();
    private final ConsolePrinter consolePrinter = new ConsolePrinter();

    public void delegationPreview(){

        // tu: odczyt danych z pliku konfiguracyjnego
        String fileDelegation = "delegation.txt";

        delegationReadFile.delegationReadFile (fileDelegation);

        StringBuilder out = new StringBuilder();

        out.trimToSize ();

        for (Delegation p: delegationRepository.listDelegations) {

            out.append("| ")
                    .append(p.getCreationDate())
                    .append(" | ")
                    .append(p.getEmployee().getEmployeeName ())
                    .append(" | ")
                    .append(p.getEmployee().getEmployeeSurname ())
                    .append(" | ")
                    .append(p.getStartDate())
                    .append(" | ")
                    .append(p.getEndDate())
                    .append(" | ")
                    .append(p.getDestination().getDestinationCountry())
                    .append(" | ")
                    .append(p.getDestination().getDestinationCity())
                    .append(" | ")
                    .append(p.getDestination().getDestinationCompany())
                    .append(" | ")
                    .append(p.getDestination().getDestinationCompanyAddress())
                    .append(" | ")
                    .append(p.getPurpose())
                    .append(" | ")
                    .append(p.getStatus())
                    .append(" | ")
                    .append(p.getStartPoint())
                    .append(" | ")
                    .append("\n");

        }

        consolePrinter.printLine(out.toString ());

    }
}
