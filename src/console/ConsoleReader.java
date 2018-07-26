package console;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class ConsoleReader {


    Scanner scanner = new Scanner( System.in );


    public Integer getInt(int minValue, int maxValue) {
        while (true) {
            Integer inputFromUser = scanner.nextInt();
            if (inputFromUser>=minValue && inputFromUser<=maxValue) {
                return inputFromUser;
            } else {
                System.out.println( "Wybrales liczbe z poza zakresu. Wpisz jeszcze raz." );
                //java.util.InputMismatchException
            }
        }
    }

    public Integer getInt() {

            Integer inputFromUser = scanner.nextInt();
        return  inputFromUser;

    }

    public String getString() {
        String stringFromUser = scanner.nextLine();
        boolean testString = false;
        while (!testString) {
            if (!stringFromUser.isEmpty()) {
                testString = true;
            } else {
                System.out.println( "Pole nie może być puste" );
                stringFromUser = scanner.nextLine();
            }
        }
        return stringFromUser;
    }


    public String getStringOneWord() {

        String stringFromUser = scanner.nextLine();
        boolean testString = false;
        while (!testString) {
            if (stringFromUser.trim().matches( "^[A-Z,ĄŻŚŹĘĆŃÓŁ][a-z,ążśźęćńół]+(([\\-][A-Z,ĄŻŚŹĘĆŃÓŁ][a-z,ążśźęćńół])?[a-z,ążśźęćńół]*)" )) {
                testString = true;
            } else {
                System.out.println( "Proszę wpisać jeszcze raz dane (wielka litera na poczatku, jeden wyraz, bez cyfr, po myślinku wielka litera)" );
                stringFromUser = scanner.nextLine();
            }
        }
        return stringFromUser;
    }

    public String getStringOneWordLow() {

        String stringFromUser = scanner.nextLine();
        boolean testString = false;
        while (!testString) {
            if (stringFromUser.trim().matches( "((?!\\,).)*$" )) {
                testString = true;
            } else {
                System.out.println( "Proszę wpisać jeszcze raz dane (dowolne znaki, bez przecinka)" );
                stringFromUser = scanner.nextLine();
            }
        }
        return stringFromUser;
    }

    public String getStringMoreWords() {

        String stringFromUser = scanner.nextLine();
        boolean testString = false;
        while (!testString) {
            if (stringFromUser.trim().matches( "([A-Z,ĄŻŚŹĘĆŃÓŁ][a-z,ążśźęćńół]((?!\\,).)*$)" )) {
                testString = true;
            } else {
                System.out.println( "Proszę wpisać jeszcze raz dane (wielka litera na poczatku, brak cyfr.)" );
                stringFromUser = scanner.nextLine();
            }
        }
        return stringFromUser;
    }

    public String getStringMoreWordsLow() {

        String stringFromUser = scanner.nextLine();
        boolean testString = false;
        while (!testString) {
            if (stringFromUser.trim().matches( "([A-Z,ĄŻŚŹĘĆŃÓŁ,a-z,ążśźęćńół]((?!\\,).)*$)" )) {
                testString = true;
            } else {
                System.out.println( "Proszę wpisać jeszcze raz dane (dowolne znaki, bez przecinka, brak cyfr.)" );
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










