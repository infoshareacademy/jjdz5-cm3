import menu.MainMenu;

public class Main {
    public static void main(String[] args) {

        MainMenu mainMenu = new MainMenu();
        mainMenu.showMenu();
        mainMenu.goMenu(mainMenu.isChoiceNumber());

        
    }
}
