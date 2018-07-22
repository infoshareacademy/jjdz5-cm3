package console;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class ConsoleReader {


    Scanner scanner = new Scanner( System.in );


    public Integer getInt() {
        Integer stringFromUser = scanner.nextInt();
        boolean testString = false;
        while (!testString) {
            if (stringFromUser==1||stringFromUser==2) {
                testString = true;
            } else {
                System.out.println( "Wybrales liczne poza zakresem. Wpisz jeszcze raz." );
                stringFromUser = scanner.nextInt();
            }
        }
        return stringFromUser;
    }

    public String getString() {
        String stringFromUser = scanner.nextLine();
        boolean testString = false;
        while (!testString) {
            if (!stringFromUser.isEmpty()) {
                testString = true;
            } else {
                System.out.println( "Pole nie moze byc puste" );
                stringFromUser = scanner.nextLine();
            }
        }
        return stringFromUser;
    }


    public String getStringOneWord() {

        String stringFromUser = scanner.nextLine();
        boolean testString = false;
        while (!testString) {
            if (stringFromUser.trim().matches( "^[A-Z][a-z]{1,30}$" )) {
                testString = true;
            } else {
                System.out.println( "Prosze wpisac jeszcze raz dane (wielka litera na poczatku, jeden wyraz, bez cyfr)" );
                stringFromUser = scanner.nextLine();
            }
        }
        return stringFromUser;
    }

    public String getStringMoreWords() {

        String stringFromUser = scanner.nextLine();
        boolean testString = false;
        while (!testString) {
            if (stringFromUser.trim().matches( "([A-Z][a-zA-Z]*\\s*)+" )) {
                testString = true;
            } else {
                System.out.println( "Prosze wpisac jeszcze raz dane (wielkie litery, brak cyfr)" );
                stringFromUser = scanner.nextLine();
            }
        }
        return stringFromUser;
    }


    public LocalDate getDateStart() {

        Scanner scanner = new Scanner( System.in );
        String dateFromUser = scanner.nextLine();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern( "yyyy-MM-dd" );


        boolean dateCheck = false;
        while (!dateCheck) {
            try {

                formatter.parse( dateFromUser, LocalDate::from );

                if (LocalDate.parse( dateFromUser ).isAfter( LocalDate.now()) ){
                    dateCheck = true;
                    break;
                } else {
                    System.out.println("Data rozpoczecia delegacji powinna byc pozniejsza niz data jej utworzenia: " + LocalDate.now());
                }
                dateFromUser = scanner.nextLine();
            } catch (DateTimeParseException e) {
                System.out.println( "Niepoprawny format daty (RRRR-MM-DD)." );
                System.out.println("Sprobuj jeszcze raz.");
                dateFromUser = scanner.nextLine();
            }

        } return LocalDate.parse( dateFromUser );

    }


}










