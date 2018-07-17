package delegations;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;


public class DelegationReadFile {


    private final DelegationRepository delegationRepository = new DelegationRepository ();


    public void delegationReadFile( String fileDelegation) {


        File delegationFile = new File( fileDelegation );
        FileReader fileReader = null;

        if ( fileDelegation.isEmpty () || (!delegationFile.exists ())) {
            System.out.println ("####");
            if ( fileDelegation.isEmpty ()) {
                System.out.println ("####  Brak nazwy pliku z delegacjami: ");
            } else if (!delegationFile.exists ()) {
                System.out.println ("####  Brak podanego pliku: " + fileDelegation);

            }

            System.out.println ("####");
            System.out.println ("####  Podaj plik w MENU > 2. Domyślny folder > .....");
            System.out.println ("####");


            return;
        } else {
            try {
                fileReader = new FileReader (delegationFile);
            } catch (FileNotFoundException e) {
                System.out.println( e );
            }
        }
        //     if (fileReader != null) {
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader( fileReader );
            String line = "";
            while ( ( line = bufferedReader.readLine() ) != null ) {

                if (!line.equals("")){  //nie dodawaj pustych lini

                    List<String> tempList = Arrays.asList (line.split (","));

                    if (tempList.size()==12) {
                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                        LocalDate tempCreationDate =  LocalDate.parse ( tempList.get(0).trim () , formatter);
                        LocalDate tempStartDate =  LocalDate.parse ( tempList.get(3).trim () , formatter);
                        LocalDate tempEndDate =  LocalDate.parse ( tempList.get(4).trim () , formatter);
                        delegationRepository.addListDelegation(new Delegation(
                                tempCreationDate,
                                tempStartDate,
                                tempEndDate,
                                tempList.get(9),
                                tempList.get(10),
                                tempList.get(11),
                                (new Employee( tempList.get(1), tempList.get(2) )
                                ),
                                (new Destination(
                                        tempList.get(5),
                                        tempList.get(6),
                                        tempList.get(7),
                                        tempList.get(8))))
                        );
                    }
                }
            }
        } catch  (Exception e ) {
            System.out.println( e );
        } finally {

            try {
                bufferedReader.close();
            } catch (Exception e) {
                System.out.println( e );
            }
        }
        // }
    }

}
