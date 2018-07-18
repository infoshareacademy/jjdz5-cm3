package properties;

import console.ConsoleClearScreen;
import console.ConsolePrinter;

public class PropertiesView {

    ConsolePrinter consolePrinter = new ConsolePrinter();
    ConsoleClearScreen consoleClearScreen = new ConsoleClearScreen();

    public void showProperties(){
        consoleClearScreen.clrscr();
        consolePrinter.printLine("=========================================================");
        consolePrinter.printLine("Domyślny kraj: " + Properties.userDelegationCountry);
        consolePrinter.printLine("Domyślny folder delegacji: " + Properties.userDelegationPath);
        consolePrinter.printLine("=========================================================");
    }
}
