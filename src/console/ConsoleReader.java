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
    int minValue = 1;
    int maxValue = 2;
    String oneWord = "[A-Z,ĄŻŚŹĘĆŃÓŁ][a-z,ążśźęćńół]+(([\\-][A-Z,ĄŻŚŹĘĆŃÓŁ][a-z,ążśźęćńół])?[a-z,ążśźęćńół]*)";
    String moreWords = "(^[A-Z,ĄŻŚŹĘĆŃÓŁ][a-z,ążśźęćńół]((?!\\,)(?![0-9,=,$,#,%,!,^,&,*,@]).)*$)";
    String moreWordsLow = "([A-ZĄŻŚŹĘĆŃÓŁa-zążśźęćńół]((?!\\,).)*$)";
    String defaultCountry = "([A-Z,ĄŻŚŹĘĆŃÓŁ][a-z,ążśźęćńół]((?!\\,).)*$)";
    String oneWordLow = "((?!\\,).)*$";
    String integer = "[0-9]*";

    public boolean validateGetShortInt(Integer i) {
        boolean result = i >= minValue && i <= maxValue;
        return result;
    }

    public Integer getShortInt() {
        Integer inputFromUser = getInt();
        boolean testString = false;
        while (!testString) {
            if (validateGetShortInt(inputFromUser)) {
                testString = true;
            } else {
                consolePrinter.printLine("| Wybrałeś liczbę spoza zakresu. Wpisz jeszcze raz.");
                inputFromUser = getInt();
                testString = false;
            }
        }
        return inputFromUser;
    }

    public boolean validateGetInt(String s) {
        boolean result = s.matches(integer);
        return result;
    }

    public Integer getInt() {
        String stringFromUser = getString();
        boolean testString = false;
        while (!testString) {
            if (validateGetInt(stringFromUser)) {
                testString = true;
            } else {
                consolePrinter.printLine("| Proszę wpisać same cyfty.");
                stringFromUser = getString();
                testString = false;
            }
        }
        return Integer.parseInt(stringFromUser);
    }

    public boolean validateGetString(String s) {
        Boolean result = s.trim().isEmpty();
        return result;
    }

    public String getString() {
        String stringFromUser = scanner.nextLine();
        boolean testString = false;
        while (!testString) {
            if (!validateGetString(stringFromUser)) {
                testString=true;
            } else {
                consolePrinter.printLine("| Pole nie może być puste.");
                stringFromUser = scanner.nextLine();
                testString=false;
            }
        }
        return stringFromUser;
    }

    public boolean validateGetStringOneWord(String s) {
        Boolean result = s.trim().matches(oneWord);
                return result;
    }

    public String getStringOneWord() {
        String stringFromUser = getString();
        boolean testString = false;
        while (!testString) {
            if (validateGetStringOneWord(stringFromUser)) {
                testString=true;
            } else {
                consolePrinter.printLine("| Proszę wpisać jeszcze raz dane (wielka litera na poczatku, jeden wyraz, bez cyfr, po myślinku wielka litera)");
                stringFromUser = getString();
                testString=false;
            }
        }
        return stringFromUser;
    }

    public boolean validateGetStringOneWordLow(String s) {
        Boolean result = s.trim().matches(oneWordLow);
        return result;
    }

    public String getStringOneWordLow() {
        String stringFromUser = getString();
        boolean testString = false;
        while (!testString) {
            if (validateGetStringOneWordLow(stringFromUser)) {
                testString=true;
            } else {
                consolePrinter.printLine("| Proszę wpisać jeszcze raz dane (dowolne znaki, bez przecinka)");
                stringFromUser = getString();
                testString=false;
            }
        }
        return stringFromUser;
    }

    public Boolean validateGetStringMoreWords(String s) {
        Boolean result = s.trim().matches(moreWords);
        return result;
    }

    public String getStringMoreWords() {
        String stringFromUser = getString();
        boolean testString = false;
        while (!testString) {
            if (validateGetStringMoreWords(stringFromUser)) {
                testString=true;
            } else {
                consolePrinter.printLine("| Proszę wpisać jeszcze raz dane (wielka litera na poczatku, brak cyfr i znakow specjalnych)");
                stringFromUser = getString();
                testString=false;
            }
        }
        return stringFromUser;
    }

    public Boolean validateGetStringMoreWordsLow(String s) {
        Boolean result = s.trim().matches(moreWordsLow);
        return result;
    }

    public String getStringMoreWordsLow() {
        String stringFromUser = getString();
        boolean testString = false;
        while (!testString) {
            if (validateGetStringMoreWordsLow(stringFromUser)) {
                testString=true;
            } else {
                consolePrinter.printLine("| Proszę wpisać jeszcze raz dane (dowolne znaki, bez przecinka)");
                stringFromUser = getString();
                testString=false;
            }
        }
        return stringFromUser;
    }

    public Boolean validateGetDateStart(String s) {
        Boolean result = LocalDate.parse(s).isAfter(LocalDate.now());
        return result;
    }

    public LocalDate getDateStart() {
        String dateFromUser = getString();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        boolean dateCheck = false;
        while (!dateCheck) {
            try {
                formatter.parse(dateFromUser, LocalDate::from);
                if (validateGetDateStart(dateFromUser)) {
                    dateCheck = true;
                    break;
                } else {
                    consolePrinter.printLine("Data musi być poźniejsza niż data utworzenia delegacji: " + LocalDate.now());
                    dateFromUser = getString();
                    dateCheck = false;
                }
            } catch (DateTimeParseException e) {
                consolePrinter.printLine("Niepoprawny format daty (RRRR-MM-DD).");
                consolePrinter.printLine("Spróbuj jeszcze raz.");
                dateFromUser = getString();
            }
        }
        return LocalDate.parse(dateFromUser);
    }

    public Boolean validateGetStringDefaultCountry(String s) {
        Boolean result = s.trim().matches(defaultCountry);
        return result;
    }

    public String getStringDefaultCountry() {
        String stringFromUser = scanner.nextLine();
        boolean testString = false;
        while (!testString) {
            if (validateGetString(stringFromUser)) {
                return Properties.userDelegationCountry;
            }
            if (validateGetStringDefaultCountry(stringFromUser)) {
                testString=true;
            } else {
                consolePrinter.printLine("| Proszę wpisać jeszcze raz dane (wielka litera na poczatku, brak cyfr.)");
                stringFromUser = scanner.nextLine();
                testString=false;
            }
        }
        return stringFromUser;
    }
}










