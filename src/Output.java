import java.util.InputMismatchException;
import java.util.Scanner;

public class Output {
    private LineStorage list;


    public static void promptUserOutput() {

        Scanner in = new Scanner(System.in);

        System.out.println("Where would you like the output? Press (1) for file, press (2) for console ");

        int userInputChoice = -1;

        try {
            userInputChoice = in.nextInt();

            if (userInputChoice > 2) {

                throw new ArithmeticException("Not a valid selection, try 1 , or 2.");

            } else if (userInputChoice < 1) {

                throw new ArithmeticException("Not a valid selection, try 1, or 2.");

            } else {
                System.out.println("Generating output for option: " + userInputChoice);

                if (userInputChoice == 1) {

                    //File output

                    Output.generateFile();

                } else {
//                  output  console
                    Output.writeToConsole();


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

    private static void generateFile() {


        LineStorage outputList = new LineStorage();
        System.out.println(outputList.getList());


    }

    private static void writeToConsole() {

        LineStorage outputList = new LineStorage();
        System.out.println(outputList.getList());
    }

    public LineStorage getList() {
        return list;
    }

}
