import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Output {
    private CircularShifter circle;



    public void promptUserOutput() {

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


                    Output.generateFile();

                } else {
//File output
                    writeToConsole();



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
    private static void generateFile(){

//           list = new LineStorage();
//           List<List<String>>  list = list.getList();
            //hurray !


    }
    public  void writeToConsole(){

        circle = new CircularShifter();
        ArrayList<String> list = circle.getList();
        System.out.println(list);
    }


}
