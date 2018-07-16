package delegations;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import delegations.*;

public class PreviewDelegation {

private final DelegationReadFile delegationReadFile = new DelegationReadFile ();
private final DelegationRepository delegationRepository = new DelegationRepository ();

  //  List<Delegation> listDelegations = new ArrayList<> ();

    public void previewDelegationRun(Delegation delegation){

        // tu: odczyt danych z pliku konfiguracyjnego
        String fileDelegation = "delegation.txt";
        //


     //   readFromFileDelegation(fileDelegation);
        delegationReadFile.delegationReadFile (fileDelegation);
        previewDelegation ();
    }

    private void previewDelegation(){

        StringBuilder out = new StringBuilder();
        out.trimToSize ();

//        for (Delegation p: listDelegations ) {
//            out.append("| ")
//                    .append(p.getCreationDate())
//                    .append(" | ")
//                    .append(p.getEmployee().getEmployeeName())
//                    .append(" | ")
//                    .append(p.getEmployee().getEmployeeSurname())
//                    .append(" | ")
//                    .append(p.getStartDate())
//                    .append(" | ")
//                    .append(p.getEndDate())
//                    .append(" | ")
//                    .append(p.getDestination().getDestinationCountry())
//                    .append(" | ")
//                    .append(p.getDestination().getDestinationCity())
//                    .append(" | ")
//                    .append(p.getDestination().getDestinationCompany())
//                    .append(" | ")
//                    .append(p.getDestination().getDestinationCompanyAddress())
//                    .append(" | ")
//                    .append(p.getPurpose())
//                    .append(" | ")
//                    .append(p.getStatus())
//                    .append(" | ")
//                    .append(p.getStartPoint())
//                    .append(" | ")
//                    .append("\n");
//        }
        System.out.println(out);

    }

//    private void readFromFileDelegation( String fileDelegation) {
//
//
//        File delegationFile = new File( fileDelegation );
//        FileReader fileReader = null;
//
//
//        try {
//            fileReader = new FileReader(delegationFile);
//        } catch (FileNotFoundException e) {
//            System.out.println("Brak pliku: " + fileDelegation );
//            System.exit (1);
//        }
//
//   //     if (fileReader != null) {
//            BufferedReader bufferedReader = null;
//            try {
//                bufferedReader = new BufferedReader( fileReader );
//                String line = "";
//                while ( ( line = bufferedReader.readLine() ) != null ) {
//
//                    if (!line.equals("")){  //nie dodawaj pustych lini
//
//                        List<String> tempList = Arrays.asList (line.split (","));
//
//                        if (tempList.size()==12) {
//
//                            listDelegations.add(new Delegation(
//                                    tempList.get(0),
//                                    tempList.get(3),
//                                    tempList.get(4),
//                                    tempList.get(9),
//                                    tempList.get(10),
//                                    tempList.get(11),
//                                    (new Employee( tempList.get(1), tempList.get(2) )
//                                    ),
//                                    (new Destination(
//                                            tempList.get(5),
//                                            tempList.get(6),
//                                            tempList.get(7),
//                                            tempList.get(8))))
//                            );
//                        }
//                    }
//                }
//            } catch  (Exception e ) {
//                System.out.println( e );
//            } finally {
//
//                try {
//                    bufferedReader.close();
//                } catch (Exception e) {
//                    System.out.println( e );
//                }
//            }
//       // }
//    }

}
