package properties;

import console.ConsolePrinter;
import console.ConsoleReader;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PropertiesSetFolder {

    ConsolePrinter consolePrinter = new ConsolePrinter();
    ConsoleReader consoleReader = new ConsoleReader();
    File[] discs = File.listRoots();
    Properties properties = new Properties();

    public void propertiesFolder() {
        System.out.println("Ustawiania folderu");
        String userPath  = consoleReader.readLine();
        if (userPath.matches("[a-z A-Z]\\:\\\\.*")){
            Path user = Paths.get(userPath);
            System.out.println(user);
            System.out.println(Files.notExists(user));
        }else {consolePrinter.printLine("blad");}
        System.out.println(System.getProperties());
        System.out.println(path);
    }
}
