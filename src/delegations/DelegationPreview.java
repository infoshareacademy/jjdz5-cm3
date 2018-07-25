package delegations;


import console.ConsolePrinter;

public class DelegationPreview {

    private final DelegationReadFile delegationReadFile = new DelegationReadFile ();
    private final DelegationRepository delegationRepository = new DelegationRepository ();
    private final ConsolePrinter consolePrinter = new ConsolePrinter();

    public void delegationPreview(){

        // tu: odczyt ścieżki do pliku z danymi delegacji z pliku konfiguracyjnego
        String fileDelegation = "/home/monika/development/jjdz5-cm3/paths/data/delegation.txt";

        delegationReadFile.delegationReadFile (fileDelegation);

        StringBuilder out = new StringBuilder();

        int columnWideWidth;
        int[] columnWidth = new int[13];

        columnWideWidth = 0;
        for (int i=0 ; i < 13 ;i++){
            columnWidth[i] = 0;
        }

        for (Delegation p: DelegationRepository.listDelegations) {

            Integer lenLP = DelegationRepository.listDelegations.indexOf(p);

            if (  columnWidth[0] < lenLP.toString ().trim ().length ()){
                columnWidth[0] = lenLP.toString ().trim ().length ();
                if ( columnWidth[0] < 4){
                    columnWidth[0] = 4;
                }
            }

            if ( columnWidth[1] < p.getCreationDate().toString().trim().length()){
                columnWidth[1] = p.getCreationDate().toString().trim().length();
                if ( columnWidth[1] < 5){
                    columnWidth[1] = 5;
                }
            }

            if (columnWidth[2] < p.getEmployee().getEmployeeName().trim().length()){
                columnWidth[2] = p.getEmployee().getEmployeeName().trim().length();
                if (columnWidth[2] < 4){
                    columnWidth[2] = 4;
                }
            }

            if (columnWidth[3] < p.getEmployee().getEmployeeSurname().trim().length()){
                columnWidth[3] = p.getEmployee().getEmployeeSurname().trim().length();
                if (columnWidth[3] < 8){
                    columnWidth[3] = 8;
                }
            }

            if (columnWidth[4] < p.getStartDate().toString().trim().length()){
                columnWidth[4] = p.getStartDate().toString().trim().length();
                if (columnWidth[4] < 10){
                    columnWidth[4] = 10;
                }
            }

            if (columnWidth[5] < p.getEndDate().toString().trim().length()){
                columnWidth[5] = p.getEndDate().toString().trim().length();
                if (columnWidth[5] < 10){
                    columnWidth[5] = 10;
                }
            }

            if (columnWidth[6] < p.getDestination().getDestinationCountry().trim().length()){
                columnWidth[6] = p.getDestination().getDestinationCountry().trim().length();
                if (columnWidth[6] < 4){
                    columnWidth[6] = 4;
                }
            }

            if (columnWidth[7] < p.getDestination().getDestinationCity().trim().length()){
                columnWidth[7] = p.getDestination().getDestinationCity().trim().length();
                if (columnWidth[7] < 6){
                    columnWidth[7] = 6;
                }
            }

            if (columnWidth[8] < p.getDestination().getDestinationCompany().trim().length()){
                columnWidth[8] = p.getDestination().getDestinationCompany().trim().length();
                if (columnWidth[8] < 5){
                    columnWidth[8] = 5;
                }
            }

            if (columnWidth[9] < p.getDestination().getDestinationCompanyAddress().trim().length()) {
                columnWidth[9] = p.getDestination().getDestinationCompanyAddress().trim().length();
                if (columnWidth[9] < 5){
                    columnWidth[9] = 5;
                }
            }

            if (columnWidth[10] < p.getPurpose().trim().length()){
                columnWidth[10] = p.getPurpose().trim().length();
                if (columnWidth[10] < 13){
                    columnWidth[10] = 13;
                }
            }

            if (columnWidth[11] < p.getDelegationStatus ().toString ().trim().length()){
                columnWidth[11] = p.getDelegationStatus ().toString ().trim().length();
                if (columnWidth[11] < 6){
                    columnWidth[11] = 6;
                }
            }

            if (columnWidth[12] < p.getStartPoint().trim().length()){
                columnWidth[12] = p.getStartPoint().trim().length();
                if (columnWidth[12] < 8){
                    columnWidth[12] = 8;
                }
            }
        }

        for (int i=0 ; i < 13 ;i++){
            columnWideWidth  += columnWidth[i];
        }

        if (columnWideWidth != 0) {

            columnWideWidth += 3 * 2 + 11 * 3;
            out.trimToSize();


            out.append(chrRepeat("=", columnWideWidth))
                    .append("\n");


            // nagłówek pierwsza linia
            out.append("|")
                    .append(" Lp.").append(chrRepeat(" ", columnWidth[0] - 4))
                    .append(" | ")
                    .append("Data").append(chrRepeat(" ", columnWidth[1] - 4))
                    .append("| ")
                    .append("Inię").append(chrRepeat(" ", columnWidth[2] - 4))
                    .append("| ")
                    .append("Nazwisko").append(chrRepeat(" ", columnWidth[3] - 8))
                    .append("| ")
                    .append("Delegacja").append(chrRepeat(" ", columnWidth[4] + columnWidth[5] - 6))
                    .append("| ")
                    .append("Kraj").append(chrRepeat(" ", columnWidth[6] - 4))
                    .append("| ")
                    .append("Miasto").append(chrRepeat(" ", columnWidth[7] - 6))
                    .append("| ")
                    .append("Firma").append(chrRepeat(" ", columnWidth[8] - 5))
                    .append("| ")
                    .append("Adres").append(chrRepeat(" ", columnWidth[9] - 5))
                    .append("| ")
                    .append("Cel delegacji").append(chrRepeat(" ", columnWidth[10] - 13))
                    .append("| ")
                    .append("Status").append(chrRepeat(" ", columnWidth[11] - 6))
                    .append("| ")
                    .append("z miasta").append(chrRepeat(" ", columnWidth[12] - 8))
                    .append("|")
                    .append("\n");

            // nagłówek druga linia
            out.append("| ")
                    .append(chrRepeat(" ", columnWidth[0]))
                    .append("| ")
                    .append("utworzenia ")
                    .append("| ")
                    .append(chrRepeat(" ", columnWidth[2]))
                    .append("| ")
                    .append(chrRepeat(" ", columnWidth[3]))
                    .append("| ")
                    .append("    od     ")
                    .append("| ")
                    .append("    do     ")
                    .append("| ")
                    .append(chrRepeat(" ", columnWidth[6]))
                    .append("| ")
                    .append(chrRepeat(" ", columnWidth[7]))
                    .append("| ")
                    .append(chrRepeat(" ", columnWidth[8]))
                    .append("| ")
                    .append(chrRepeat(" ", columnWidth[9]))
                    .append("| ")
                    .append(chrRepeat(" ", columnWidth[10]))
                    .append("| ")
                    .append(chrRepeat(" ", columnWidth[11]))
                    .append("| ")
                    .append(chrRepeat(" ", columnWidth[12]))
                    .append("|")
                    .append("\n");

            out.append(chrRepeat("=", columnWideWidth))
                    .append("\n");

            for (Delegation p : DelegationRepository.listDelegations) {

                Integer lenLP = DelegationRepository.listDelegations.indexOf(p);

                out.append("| ")
                        .append(lenLP.toString().trim())
                        .append(chrRepeat(" ", columnWidth[0] - lenLP.toString().trim().length()))
                        .append("| ")
                        .append(p.getCreationDate())
                        .append(" | ")
                        .append(p.getEmployee().getEmployeeName().trim())
                        .append(chrRepeat(" ", columnWidth[2] - p.getEmployee().getEmployeeName().trim().length()))
                        .append("| ")
                        .append(p.getEmployee().getEmployeeSurname().trim())
                        .append(chrRepeat(" ", columnWidth[3] - p.getEmployee().getEmployeeSurname().trim().length()))
                        .append("| ")
                        .append(p.getStartDate())
                        .append(" | ")
                        .append(p.getEndDate())
                        .append(" | ")
                        .append(p.getDestination().getDestinationCountry().trim())
                        .append(chrRepeat(" ", columnWidth[6] - p.getDestination().getDestinationCountry().trim().length()))
                        .append("| ")
                        .append(p.getDestination().getDestinationCity().trim())
                        .append(chrRepeat(" ", columnWidth[7] - p.getDestination().getDestinationCity().trim().length()))
                        .append("| ")
                        .append(p.getDestination().getDestinationCompany().trim())
                        .append(chrRepeat(" ", columnWidth[8] - p.getDestination().getDestinationCompany().trim().length()))
                        .append("| ")
                        .append(p.getDestination().getDestinationCompanyAddress().trim())
                        .append(chrRepeat(" ", columnWidth[9] - p.getDestination().getDestinationCompanyAddress().trim().length()))
                        .append("| ")
                        .append(p.getPurpose().trim())
                        .append(chrRepeat(" ", columnWidth[10] - p.getPurpose().trim().length()))
                        .append("| ")
                        .append(p.getDelegationStatus().toString())
                        .append(chrRepeat(" ", columnWidth[11] - p.getDelegationStatus().toString().trim().length()))
                        .append("| ")
                        .append(p.getStartPoint().trim())
                        .append(chrRepeat(" ", columnWidth[12] - p.getStartPoint().trim().length()))
                        .append("|")
                        .append("\n");

            }
            out.append(chrRepeat("=", columnWideWidth))
                    .append("\n");

            consolePrinter.printLine(out.toString());
        }
    }
    private String chrRepeat(String str, int n){

        StringBuilder spaceRep = new StringBuilder ();

        for (int i = 0; i <= n; i++) {
            spaceRep.append (str);
        }

        return spaceRep.toString ();
    }
}
