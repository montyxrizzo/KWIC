import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;


public class Input {


    public void promptUser() {

        Scanner in = new Scanner(System.in);
        Input reader = new Input();
        System.out.println("To perform a circular shift from your .txt file, press (1). For console input, press (2)");

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

                    reader.readFile();

                } else {

                    reader.readConsoleInput();
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

    public void readFile() {

        CircularShifter circle = new CircularShifter();

        Scanner in = new Scanner(System.in);
        LineStorage lineStorage = new LineStorage();

        BufferedReader reader;
        try {
            try {

                System.out.println("Please enter the absolute filepath to a .txt file containing the data you would like to shift.");

                String filePath = in.nextLine();

                reader = new BufferedReader(new FileReader(
                        filePath));

                String line = reader.readLine();
                lineStorage.getRecordFromLine(line);
                List lineArray = lineStorage.getRecordFromLine(line);
                List list = lineStorage.getWords(line);
                circle.shiftAtLine(list);
                while (line != null) {

                    line = reader.readLine();
                    list = lineStorage.getWords(line);
                    circle.shiftAtLine(list);
                    lineArray = lineStorage.getRecordFromLine(line);

                }
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();

            }
        } catch (NullPointerException e) {
//                System.out.println("NullPointerException thrown!");
            Output out = new Output();
            out.promptUserOutput();

        }
    }


    public static void readConsoleInput() {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        CircularShifter circle = new CircularShifter();
        LineStorage lineStorage = new LineStorage();

        BufferedReader reader;
        try {
            String line;
            try {

                System.out.println("Please enter the sentences you would like to Circularly shift, separated by comma.");
                while ((line = in.readLine()) != null) {
                    String[] tokens = line.split("\\s");
                    lineStorage.getRecordFromLine(line);
                    List lineArray = lineStorage.getRecordFromLine(line);


                    StringBuffer sb = new StringBuffer();

                    for (Object s : lineArray) {
                        sb.append(s);
                        sb.append(" ");
                    }
                    List list = lineStorage.getWords(line);
                    circle.shiftAtLine(list);
                    Output out = new Output();
                    out.promptUserOutput();

//
                }

                in.close();
            } catch (IOException e) {
                e.printStackTrace();

            }
        } catch (NullPointerException e) {
//                System.out.println("NullPointerException thrown!");
            Output out = new Output();
            out.promptUserOutput();

        }
    }

}

