package console;

public class ConsoleClearScreen {

        public void clrscr() {
            for (int clear = 0; clear < 2; clear++) {
                System.out.println("");
            }
            System.out.println("\b\b\b");
        }

        public void pressAnyKeyToContinue()
        {
            System.out.println("\n Press Enter key to continue...");
            try
            {
                System.in.read();
            }
            catch(Exception e)
            {}

        }
    }


