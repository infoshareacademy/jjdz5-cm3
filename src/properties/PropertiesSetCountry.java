package properties;

import console.ConsolePrinter;

public class PropertiesSetCountry {

    ConsolePrinter consolePrinter = new ConsolePrinter();
    Properties properties = new Properties();


    public void defaultCountry() {

        consolePrinter.printLine("Podaj domyślny kraj: ");

    }
}
