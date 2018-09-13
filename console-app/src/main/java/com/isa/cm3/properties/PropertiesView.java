package com.isa.cm3.properties;


import com.isa.cm3.console.ConsoleClearScreen;
import com.isa.cm3.console.ConsolePrinter;

public class PropertiesView {

    private ConsolePrinter consolePrinter = new ConsolePrinter();
    private ConsoleClearScreen consoleClearScreen = new ConsoleClearScreen();

    public void showProperties() {
        consoleClearScreen.clrscr();
        consolePrinter.printLine("=========================================================");
        consolePrinter.printLine("Domyślny kraj: " + Properties.userDelegationCountry);
        consolePrinter.printLine("Domyślny folder delegacji: " + Properties.userDelegationPath);
        consolePrinter.printLine("=========================================================");

    }
}
