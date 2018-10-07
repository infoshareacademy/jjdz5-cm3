package com.isa.cm3.properties;


import com.isa.cm3.console.ConsoleClearScreen;
import com.isa.cm3.console.ConsolePrinter;
import com.isa.cm3.console.ConsoleReader;

public class PropertiesSetCountry {

    private ConsolePrinter consolePrinter = new ConsolePrinter();
    private ConsoleReader consoleReader = new ConsoleReader();
    private ConsoleClearScreen consoleClearScreen = new ConsoleClearScreen();

    public void defaultCountry() {

        consolePrinter.printLine("Podaj kraj (przerwanie operacji wybierz 3):");
        String userCountry = consoleReader.getString();
        if (userCountry.equalsIgnoreCase("3")){return;}
        while (true) {
            if (userCountry.matches("^[A-Z,ĄŻŚŹĘĆŃÓŁ][a-z,ążśźęćńół]{3,100}")) {
                Properties.userDelegationCountry = userCountry;
                consoleClearScreen.clrscr();
                consolePrinter.printLine("Domyślny kraj ustawiono na: " + Properties.userDelegationCountry);
                consoleClearScreen.pressAnyKeyToContinue();
                consoleClearScreen.clrscr();
                break;
            } else {
                consolePrinter.printLine("Błąd: Kraj podajemy z dużej litery i conajmniej 4 znaki. Podaj jeszce raz ");
                userCountry = consoleReader.getString();
                continue;
            }
        }
    }
}

