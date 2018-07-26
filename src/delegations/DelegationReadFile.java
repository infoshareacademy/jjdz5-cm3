package delegations;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class DelegationReadFile {


    private final DelegationRepository delegationRepository = new DelegationRepository ();


    public List<Delegation> delegationReadFile(String fileDelegation) {

        List<Delegation> readDelegations = new ArrayList<>();

            File delegationFile = new File (fileDelegation);

            FileReader fileReader = null;

            if (fileDelegation.isEmpty () || (!delegationFile.exists ())) {
                System.out.println ("####");
                if (fileDelegation.isEmpty ()) {
                    System.out.println ("####  Brak nazwy pliku z delegacjami: ");
                } else if (!delegationFile.exists ()) {
                    System.out.println ("####  Brak podanego pliku: " + fileDelegation);

                }

                System.out.println ("####");
                System.out.println ("####  Podaj plik w MENU > 2. Domyślny folder > .....");
                System.out.println ("####");


                return readDelegations;
            } else {
                try {
                    fileReader = new FileReader (delegationFile);
                } catch (FileNotFoundException e) {
                    System.out.println (e);
                }
            }

            BufferedReader bufferedReader = null;
            try {
                bufferedReader = new BufferedReader (fileReader);
                String line = "";
                int fileLineNumber = 0;
                while ((line = bufferedReader.readLine ()) != null) {

                    if (!line.equals ("")) {  //nie dodawaj pustych lini

                        List<String> tempList = Arrays.asList (line.split (","));

                        if (tempList.size () == 13) {



                            DateTimeFormatter formatter = DateTimeFormatter.ofPattern ("yyyyMMdd");

                            LocalDate tempCreationDate = LocalDate.parse (
                                    tempList.get (1).trim ().replace ("-", ""), formatter);

                            LocalDate tempStartDate = LocalDate.parse (
                                    tempList.get (4).trim ().replace ("-", ""), formatter);

                            LocalDate tempEndDate = LocalDate.parse (
                                    tempList.get (5).trim ().replace ("-", ""), formatter);

                            readDelegations.add (new Delegation (
                                    ++fileLineNumber, tempCreationDate,
                                    (new Employee (tempList.get (2), tempList.get (3))
                                    ),
                                    tempStartDate,
                                    tempEndDate,
                                    (new Destination (
                                            tempList.get (6),
                                            tempList.get (7),
                                            tempList.get (8),
                                            tempList.get (9))),
                                    tempList.get (10),
                                    DelegationStatus.valueOf (tempList.get (11)),
                                    tempList.get (12)));
                        }
                    }
                //    fileLineNumber++;
                }
            } catch (Exception e) {
                System.out.println (e);
            } finally {

                try {
                    bufferedReader.close ();
                } catch (Exception e) {
                    System.out.println (e);
                }
            }
            return readDelegations;
        }

    }

