import java.util.Scanner;

public class Menu {



    public int readFromConsole() {
        return new Scanner(System.in).nextInt();}

    public int isChoiceNumber(){

        int choice = -1 ;
        boolean isCorect = false;

        while (!isCorect){

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

    public void goMenu(int choice){};

    public void outOfProgramandMainMenu(int choice){
        if (choice == 0) {
            System.out.println("Dziękujemy za skorzystanie z programu. Zapraszamy ponownie.");
            System.exit(1);
        }else {MainMenu mainMenu = new MainMenu();
            mainMenu.goMenu(mainMenu.isChoiceNumber());}
    }




    }


