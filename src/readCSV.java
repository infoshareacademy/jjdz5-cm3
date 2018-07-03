import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class readCSV {


        private static final String FILE_DELEGATION = "delegation.txt";

        List<String> linesCSV = new ArrayList<> ();


        public void addCSVLines( String delegat ) {
            linesCSV.add( delegat );
        }

        public int getCSVSize(){
            return linesCSV.size();
        }

        public String getCurrentCSVLine( int i ){
            return linesCSV.get( i );
        }


        public void readCSV(){

            File stableFile = new File( FILE_DELEGATION );
            FileReader fileReader = null;

            try {
                fileReader = new FileReader(stableFile);
            } catch (FileNotFoundException e) {
                System.out.println("Brak pliku: " + FILE_DELEGATION );
                System.exit (1);
            }

            if (fileReader != null) {
                BufferedReader bufferedReader = null;
                try {
                    bufferedReader = new BufferedReader( fileReader );
                    String line = null;
                    while ( ( line = bufferedReader.readLine() ) != null ) {

                        if (!line.equals("") ){  //nie dodawaj pustych lini
                            addCSVLines( line );
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
