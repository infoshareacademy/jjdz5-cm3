package console;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class ConsoleReader {

    ConsolePrinter consolePrinter = new ConsolePrinter();
    Scanner scanner = new Scanner( System.in );


    public Integer getInt(int minValue, int maxValue) {
        while (true) {
            Integer inputFromUser = scanner.nextInt();
            if (inputFromUser>=minValue && inputFromUser<=maxValue) {
                return inputFromUser;
            } else {
                consolePrinter.printLine( "Wybrałeś liczbę spoza zakresu. Wpisz jeszcze raz." );
                //java.util.InputMismatchException
            }
        }
    }

    public Integer getInt() {
        String inputFromUser = getString ();

        boolean testString = false;
        while (!testString) {
            if (inputFromUser.matches( "[0-9]*" )) {
                testString = true;
            } else {
                consolePrinter.printLine( "Proszę wpisać same cyfty." );
                inputFromUser = scanner.nextLine();
            }
        }
        return  Integer.parseInt (inputFromUser);
    }

    public String getString() {
        String stringFromUser = scanner.nextLine();
        boolean testString = false;
        while (!testString) {
            if (!stringFromUser.isEmpty()) {
                testString = true;
            } else {
                consolePrinter.printLine( "Pole nie może być puste." );
                stringFromUser = scanner.nextLine();
            }
        }
        return stringFromUser;
    }


    public String getStringOneWord() {

        String stringFromUser = getString();
        boolean testString = false;
        while (!testString) {
            if (stringFromUser.trim().matches( "^[A-Z,ĄŻŚŹĘĆŃÓŁ][a-z,ążśźęćńół]+(([\\-][A-Z,ĄŻŚŹĘĆŃÓŁ][a-z,ążśźęćńół])?[a-z,ążśźęćńół]*)" )) {
                testString = true;
            } else {
                consolePrinter.printLine( "Proszę wpisać jeszcze raz dane (wielka litera na poczatku, jeden wyraz, bez cyfr, po myślinku wielka litera)" );
                stringFromUser = scanner.nextLine();
            }
        }
        return stringFromUser;
    }

    public String getStringOneWordLow() {

        String stringFromUser = getString();
        boolean testString = false;
        while (!testString) {
            if (stringFromUser.trim().matches( "((?!\\,).)*$" )) {
                testString = true;
            } else {
                consolePrinter.printLine( "Proszę wpisać jeszcze raz dane (dowolne znaki, bez przecinka)" );
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
                consolePrinter.printLine( "Proszę wpisać jeszcze raz dane (wielka litera na poczatku, brak cyfr.)" );
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
                consolePrinter.printLine( "Proszę wpisać jeszcze raz dane (dowolne znaki, bez przecinka, brak cyfr.)" );
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
                    consolePrinter.printLine("Data rozpoczecia delegacji powinna byc pozniejsza niz data jej utworzenia: " + LocalDate.now());
                }
                dateFromUser = scanner.nextLine();
            } catch (DateTimeParseException e) {
                consolePrinter.printLine( "Niepoprawny format daty (RRRR-MM-DD)." );
                consolePrinter.printLine("Sprobuj jeszcze raz.");
                dateFromUser = scanner.nextLine();
            }

        } return LocalDate.parse( dateFromUser );

    }


}










