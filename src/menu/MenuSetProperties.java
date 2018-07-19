package menu;

import console.ConsolePrinter;
import properties.Properties;
import properties.PropertiesSaveToJson;
import properties.PropertiesSetCountry;
import properties.PropertiesSetFolder;

public class MenuSetProperties extends MenuProperties {

    private PropertiesSetCountry propertiesSetCountry = new PropertiesSetCountry();
    private PropertiesSetFolder propertiesSetFolder = new PropertiesSetFolder();
    private ConsolePrinter consolePrinter = new ConsolePrinter();
    private PropertiesSaveToJson propertiesSaveToJson = new PropertiesSaveToJson();

    int i;

    public void MenuChange(int userChoice) {

        while (true) {
            if (userChoice == 1) {
                consolePrinter.printLine("================================");
                consolePrinter.printLine("Obecnie domyślny kraj to: " + Properties.userDelegationCountry);
                consolePrinter.printLine("================================");
                consolePrinter.printLine("1. Zmiana | 2. Powrót");
                i = 0;
            } else {
                consolePrinter.printLine("================================");
                consolePrinter.printLine("Obecnie domyślny folder to: " + Properties.userDelegationPath);
                consolePrinter.printLine("================================");
                consolePrinter.printLine("1. Zmiana | 2. Powrót");
                i = 1;
            }

            userChoice = new MenuSetProperties().isChoiceNumber();
            while (userChoice != 1 && userChoice != 2) {
                consolePrinter.printLine("Wybór spoza zakresu");
                userChoice = new MenuSetProperties().isChoiceNumber();
            }


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

