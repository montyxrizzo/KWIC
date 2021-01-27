import java.io.*;
import java.util.ArrayList;
import java.util.InputMismatchException;

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


                    generateFile();

                } else {
//File output
                    writeToConsole();


                }
            }


        } catch (InputMismatchException a) {
            System.out.print("Problem");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


        switch (userInputChoice) {
            case -1:
                //No valid input
                break;
        }
    }

    private void generateFile() throws FileNotFoundException {
        circle = new CircularShifter();
        ArrayList<String> list = circle.getList();
//        System.out.println("\n");
        String listString = Alphabetizer.sortList(list);

//        for (String s : list) {
//            listString += s + "\t";
//        }
//Write txt file
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter("KWIC_Result_File__HW1_Montreaux_Rodgers.txt"));
            writer.write(listString);

        } catch (IOException e) {
        } finally {
            try {
                if (writer != null)
                    writer.close();
            } catch (IOException e) {
            }
        }
        System.out.println("Your file has been written to  the SRC directory of this project.");


    }

    public void writeToConsole() {

        circle = new CircularShifter();
        ArrayList<String> list = circle.getList();

        String listString = Alphabetizer.sortList(list);
//
//        for (String s : list) {
//            listString += s + "\t";
//        }
//        System.out.println("\n");
        System.out.println(listString);
    }


}
