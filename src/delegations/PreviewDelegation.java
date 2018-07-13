package delegations;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class PreviewDelegation {


    List<Delegation> listDelegations = new ArrayList<> ();

    public void previewDelegationRun(Delegation delegation){

        String fileDelegation = "delegation.txt";

        readFromFileDelegation(delegation, fileDelegation);
        previewDelegation (delegation);

    }

    private void previewDelegation(Delegation delegation){

        StringBuilder out = new StringBuilder("");

        for (Delegation p: listDelegations ) {
            out.append("| ")
                    .append(p.getCreationDate())
                    .append(" | ")
                    .append(p.getEmployee().getEmployeeName())
                    .append(" | ")
                    .append(p.getEmployee().getEmployeeSurname())
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
        System.out.println(out);

    }

    private void readFromFileDelegation(Delegation delegation, String fileDelegation) {

        File delegationFile = new File( fileDelegation );
        FileReader fileReader = null;

        String[] atest;

        try {
            fileReader = new FileReader(delegationFile);
        } catch (FileNotFoundException e) {
            System.out.println("Brak pliku: " + fileDelegation );
            System.exit (1);
        }

        if (fileReader != null) {
            BufferedReader bufferedReader = null;
            try {
                bufferedReader = new BufferedReader( fileReader );
                String line = null;
                while ( ( line = bufferedReader.readLine() ) != null ) {

                    if (!line.equals("")){  //nie dodawaj pustych lini
                        atest = line.split(",");

                        if (atest.length==12) {

                            delegation.setCreationDate(atest[0]);
                            delegation.setEmployee(new Employee(atest[1], atest[2]));
                            delegation.setStartDate(atest[3]);
                            delegation.setEndDate(atest[4]);
                            delegation.setDestination(new Destination(atest[6],
                                    atest[6],
                                    atest[7],
                                    atest[8]));
                            delegation.setPurpose(atest[9]);
                            delegation.setStatus(atest[10]);
                            delegation.setStartPoint(atest[11]);

                            listDelegations.add(new Delegation(
                                    delegation.getCreationDate(),
                                    delegation.getStartDate(),
                                    delegation.getEndDate(),
                                    delegation.getPurpose(),
                                    delegation.getStatus(),
                                    delegation.getStartPoint(),
                                    (new Employee( delegation.getEmployee().getEmployeeName(),
                                            delegation.getEmployee().getEmployeeSurname() )
                                    ),
                                    (new Destination(
                                            delegation.getDestination().getDestinationCountry(),
                                            delegation.getDestination().getDestinationCity(),
                                            delegation.getDestination().getDestinationCompany(),
                                            delegation.getDestination().getDestinationCompanyAddress()))
                            ));
                        }





                    }

                }
            } catch  (Exception e ) {
                System.out.println( e );
            } finally {

                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    System.out.println( e );
                }
            }
        }
    }

}
