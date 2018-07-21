package console;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class ConsoleReader {


    Scanner scanner = new Scanner(System.in);

    public Integer getInt() {
        return scanner.nextInt();
    }

    public String getString() {
        return scanner.nextLine();
    }

    public String getStringOneWord() {

        String stringFromUser = scanner.nextLine();
        boolean testString = false;
        while (!testString) {
            if (stringFromUser.trim().matches( "^[A-Z][a-z]{1,30}$" )) {
                    testString = true; }
             else {
                System.out.println( "Prosze wpisac jeszcze raz dane (wielka litera na poczatku, jeden wyraz, bez cyfr)" );
                stringFromUser = scanner.nextLine();
            }
        } return stringFromUser;
    }

    public String getStringMoreWords() {

        String stringFromUser = scanner.nextLine();
        boolean testString = false;
        while (!testString) {
            if (stringFromUser.trim().matches( "([A-Z][a-zA-Z]*\\s*)+" )) {
                testString = true; }
            else {
                System.out.println( "Prosze wpisac jeszcze raz dane (wielkie litery, brak cyfr)" );
                stringFromUser = scanner.nextLine();
            }
        } return stringFromUser;
    }



    public LocalDate getDate() {

        String dateFromUser = scanner.nextLine();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern( "yyyy-MM-dd" );


        boolean dateCheck = false;
        while (!dateCheck) {
            try {
                formatter.parse( dateFromUser, LocalDate::from );
                dateCheck = true;
            } catch (DateTimeParseException e) {
                System.out.println( "Niepoprawny format daty (RRRR-MM-DD). Sprobuj jeszcze raz." );
                dateFromUser = scanner.nextLine();

            }

        }
        return LocalDate.parse( dateFromUser );
    }
}
