package console;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class ConsoleReader {

    // Uwagi: mozna wyciagnac scannera na poczatek kodu


    public String readLine() {

        return new Scanner( System.in ).nextLine();
    }


    public LocalDate getDate() {

        Scanner scanner = new Scanner( System.in );
        String dateFromUser = scanner.nextLine();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern( "yyyy-MM-dd" );


        boolean dateCheck = false;
        while (!dateCheck) {
            try {
                LocalDate date = formatter.parse( dateFromUser, LocalDate::from );
                dateCheck = true;
            } catch (DateTimeParseException e) {
                System.out.println( "Niepoprawny format daty. Sprobuj jeszcze raz." );
                dateFromUser = scanner.nextLine();

            }

        }
        return LocalDate.parse( dateFromUser );
    }
}
