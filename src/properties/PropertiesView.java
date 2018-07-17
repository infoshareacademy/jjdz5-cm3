package properties;

import console.ConsolePrinter;

public class PropertiesView {

    ConsolePrinter consolePrinter = new ConsolePrinter();

    public void showProperties(){
        consolePrinter.printLine("Domyślny kraj: " + Properties.userDelegationCountry);
        consolePrinter.printLine("Domyślny folder delegacji: " + Properties.userDelegationPath);
    }
}
