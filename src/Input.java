import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;





public class Input {


    public static void promptUser() {

        Scanner in = new Scanner(System.in);

        System.out.println("To perform a circular shift from your CSV file, press (1). For console input, press (2)");

        int userInputChoice = -1;

        try {
            userInputChoice = in.nextInt();

            if (userInputChoice > 2) {

                throw new ArithmeticException("Not a valid selection, try 1 , or 2.");

            } else if (userInputChoice < 1) {

                throw new ArithmeticException("Not a valid selection, try 1, or 2.");

            } else {
                System.out.println("Running Circular shift for option: " + userInputChoice);

                if (userInputChoice == 1) {

                    Input.readFile();

                } else {

                    Input.readConsoleInput();
                }
            }
        } catch (InputMismatchException a) {
            System.out.print("Problem");
        }


        switch (userInputChoice) {
            case -1:
                //No valid input
                break;
        }
    }

        public static void readFile() {

            Scanner in = new Scanner(System.in);

            BufferedReader reader;
            try{
            try {

                System.out.println("Please enter the absolute filepath to a CSV file containing the data you would like to shift.");

                String filePath = in.nextLine();

                reader = new BufferedReader(new FileReader(
                        filePath));

                String line = reader.readLine();
                LineStorage.getRecordFromLine(line);
                List lineArray = LineStorage.getRecordFromLine(line);
//                int count = 1;
                List list =  LineStorage.getWords(line);
                CircularShifter.shiftAtLine(list);
                while (line != null) {
//                    count++;
//                    System.out.println(line);
                      // read next line
                    line = reader.readLine();
                    list =  LineStorage.getWords(line);
                    CircularShifter.shiftAtLine(list);
                    lineArray = LineStorage.getRecordFromLine(line);

                     }
                     reader.close();
                } catch (IOException e) {
                e.printStackTrace();

            }
            }
            catch(NullPointerException e) {
//                System.out.println("NullPointerException thrown!");
                Output.promptUserOutput();

            }
        }


    public static void readConsoleInput(){
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//        String text = in.readLine();
    }


//    public  static String addExclamationPoint(String s) {
//        return s + "!";
//    }
}

