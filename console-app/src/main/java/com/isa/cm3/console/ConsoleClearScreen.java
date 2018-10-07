package com.isa.cm3.console;

public class ConsoleClearScreen {

    public void clrscr() {
        for (int clear = 0; clear < 2; clear++) {
            System.out.println("");
        }
        System.out.println("\b\b\b");
    }

    public void pressAnyKeyToContinue() {
        System.out.println("\n Naciśnij dowolny klawisz aby kontynuować...");
        try {
            System.in.read();
        } catch (Exception e) {
        }

    }
}


