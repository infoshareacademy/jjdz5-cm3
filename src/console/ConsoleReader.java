package console;

import delegations.DelegationAdd;
import properties.Properties;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class ConsoleReader {

    private final Scanner scanner = new Scanner(System.in);
    ConsolePrinter consolePrinter = new ConsolePrinter();

    public Integer getInt(int minValue, int maxValue) {
        while (true) {
            Integer inputFromUser = scanner.nextInt();
            if (inputFromUser >= minValue && inputFromUser <= maxValue) {
                return inputFromUser;
            } else {
                consolePrinter.printLine("| Wybrałeś liczbę spoza zakresu. Wpisz jeszcze raz.");
            }
        }
    }

    public Integer getInt() {
        String inputFromUser = getString();

        boolean testString = false;
        while (!testString) {
            if (inputFromUser.matches("[0-9]*")) {
                testString = true;
            } else {
                consolePrinter.printLine("| Proszę wpisać same cyfty.");
                inputFromUser = getString();
            }
        }
        return Integer.parseInt(inputFromUser);
    }

    public String getString() {
        String stringFromUser = scanner.nextLine();
        while (true) {
            if (stringFromUser.isEmpty()) {
                consolePrinter.printLine("| Pole nie może być puste.");
                stringFromUser = scanner.nextLine();
                continue;
            } else {
                break;
            }
        }
        return stringFromUser;
    }

    public String getStringOneWord() {

        String stringFromUser = getString();
        while (true) {
            if (stringFromUser.trim().matches("^[A-Z,ĄŻŚŹĘĆŃÓŁ][a-z,ążśźęćńół]+(([\\-][A-Z,ĄŻŚŹĘĆŃÓŁ][a-z,ążśźęćńół])?[a-z,ążśźęćńół]*)")) {
                break;
            } else {
                consolePrinter.printLine("| Proszę wpisać jeszcze raz dane (wielka litera na poczatku, jeden wyraz, bez cyfr, po myślinku wielka litera)");
                stringFromUser = getString();
                continue;
            }
        }
        return stringFromUser;
    }

    public String getStringOneWordLow() {

        String stringFromUser = getString();
        while (true) {
            if (stringFromUser.trim().matches("((?!\\,).)*$")) {
                break;
            } else {
                consolePrinter.printLine("| Proszę wpisać jeszcze raz dane (dowolne znaki, bez przecinka)");
                stringFromUser = getString();
                continue;
            }
        }
        return stringFromUser;
    }

    public String getStringMoreWords() {

        String stringFromUser = getString();
        while (true) {
            if (stringFromUser.trim().matches("(^[A-Z,ĄŻŚŹĘĆŃÓŁ][a-z,ążśźęćńół]((?!\\,)(?![0-9,=,$,#,%,!,^,&,*,@]).)*$)")) {
                break;
            } else {
                consolePrinter.printLine("| Proszę wpisać jeszcze raz dane (wielka litera na poczatku, brak cyfr i znakow specjalnych)");
                stringFromUser = getString();
                continue;
            }
        }
        return stringFromUser;
    }

    public String getStringMoreWordsLow() {

        String stringFromUser = getString();
        while (true) {
            if (stringFromUser.trim().matches("([A-ZĄŻŚŹĘĆŃÓŁa-zążśźęćńół]((?!\\,).)*$)")) {
                break;
            } else {
                consolePrinter.printLine("| Proszę wpisać jeszcze raz dane (dowolne znaki, bez przecinka)");
                stringFromUser = getString();
                continue;
            }
        }
        return stringFromUser;
    }

    public LocalDate getDateStart() {

        String dateFromUser = getString();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");


        boolean dateCheck = false;
        while (!dateCheck) {
            try {

                formatter.parse(dateFromUser, LocalDate::from);

                if (LocalDate.parse(dateFromUser).isAfter(LocalDate.now())) {
                    dateCheck = true;
                    break;
                } else {
                    consolePrinter.printLine("Data musi być poźniejsza niż data utworzenia delegacji: " + LocalDate.now());
                }
                dateFromUser = getString();
            } catch (DateTimeParseException e) {
                consolePrinter.printLine("Niepoprawny format daty (RRRR-MM-DD).");
                consolePrinter.printLine("Spróbuj jeszcze raz.");
                dateFromUser = getString();
            }
        }
        return LocalDate.parse(dateFromUser);
    }

    public String getStringDefaultCountry() {
        String stringFromUser = scanner.nextLine ();
        while (true) {
            if (stringFromUser.isEmpty ()) {
                return Properties.userDelegationCountry;
            }
            if (stringFromUser.trim().matches("([A-Z,ĄŻŚŹĘĆŃÓŁ][a-z,ążśźęćńół]((?!\\,).)*$)")) {
                break;} else {
                consolePrinter.printLine("| Proszę wpisać jeszcze raz dane (wielka litera na poczatku, brak cyfr.)");
                stringFromUser = scanner.nextLine ();
                continue;}}
        return stringFromUser;
    }

}










