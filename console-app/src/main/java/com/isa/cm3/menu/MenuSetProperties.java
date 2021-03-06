package com.isa.cm3.menu;


import com.isa.cm3.console.ConsoleClearScreen;
import com.isa.cm3.console.ConsolePrinter;
import com.isa.cm3.properties.Properties;
import com.isa.cm3.properties.PropertiesSaveToJson;
import com.isa.cm3.properties.PropertiesSetCountry;
import com.isa.cm3.properties.PropertiesSetFolder;

public class MenuSetProperties extends MenuProperties {

    int i;
    private PropertiesSetCountry propertiesSetCountry = new PropertiesSetCountry();
    private PropertiesSetFolder propertiesSetFolder = new PropertiesSetFolder();
    private ConsolePrinter consolePrinter = new ConsolePrinter();
    private PropertiesSaveToJson propertiesSaveToJson = new PropertiesSaveToJson();
    private ConsoleClearScreen consoleClearScreen = new ConsoleClearScreen();

    public void MenuChange(int userChoice) {

        while (true) {
            if (userChoice == 1) {
                consolePrinter.printLine("================================");
                consolePrinter.printLine("Obecnie domyślny kraj to: " + Properties.userDelegationCountry);
                consolePrinter.printLine("================================");
                consolePrinter.printLine("| 1. Zmiana");
                consolePrinter.printLine("| 2. Powrót");
                i = 0;
            } else {
                consolePrinter.printLine("================================");
                consolePrinter.printLine("Obecnie domyślny folder to: " + Properties.userDelegationPath);
                consolePrinter.printLine("================================");
                consolePrinter.printLine("| 1. Zmiana");
                consolePrinter.printLine("| 2. Powrót");
                i = 1;
            }


            userChoice = yesNo();

            switch (userChoice) {
                case 1:
                    if (i == 0) {
                        propertiesSetCountry.defaultCountry();
                    } else {
                        propertiesSetFolder.defaultFolder();
                    }
                    propertiesSaveToJson.saveJson();
                    new MenuProperties().showMenu();
                    break;
                default:
                    consoleClearScreen.clrscr();
                    new MenuProperties().showMenu();
                    break;
            }
        }
    }
}

