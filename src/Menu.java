import java.util.Scanner;

public class Menu {


    /*metoda wczytuje z konsoli liczbę */
    public int readFromConsole() {
        return new Scanner(System.in).nextInt();
    }

    /*metoda sprawdza czy klieny wpisał lczbę całkowitą - jak nie to czeka do skutku */
    public int isChoiceNumber() {

        int choice = -1;
        boolean isCorect = false;

        while (!isCorect) {

            try {
                choice = readFromConsole();
                isCorect = true;

            } catch (Exception e) {
                System.out.println("to nie jest liczba całkowita wpisz jeszcze raz");
                isCorect = false;
            }
        }
        return choice;
    }

    public void goMenu(int choice) {
    }

    /* metoda sprawdza czy było wybrane 0 lub 9 i odpowiednio przenosi do MainMenu lub kończy program*/
    public void outOfProgramandMainMenu(int choice) {
        if (choice == 0) {
            System.out.println("Dziękujemy za skorzystanie z programu. Zapraszamy ponownie.");
            System.exit(1);
        } else {
            MainMenu mainMenu = new MainMenu();
            mainMenu.goMenu(mainMenu.isChoiceNumber());
        }
    }


}


