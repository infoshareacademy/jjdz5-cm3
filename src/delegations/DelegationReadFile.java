package delegations;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.List;


public class DelegationReadFile {


    private final DelegationRepository delegationRepository = new DelegationRepository ();


    public void delegationReadFile( String fileDelegation) {


        File delegationFile = new File( fileDelegation );
        FileReader fileReader = null;

        try {
            fileReader = new FileReader(delegationFile);
        } catch (FileNotFoundException e) {
            System.out.println ( "####" );
            System.out.println ( "####  Brak pliku: " + fileDelegation );
            System.out.println ( "####" );

            return;
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

                        delegationRepository.addListDelegation(new Delegation(
                                tempList.get(0),
                                tempList.get(3),
                                tempList.get(4),
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
