package kwic;

import java.io.*;
import java.util.ArrayList;


public class Output {
    private CircularShifter circle;
//------------------ Deprecated ---------------------------

    //    public void promptUserOutput() {
//
//        Scanner in = new Scanner(System.in);
//
//        System.out.println("Where would you like the output? Press (1) for file, press (2) for console ");
//
//        int userInputChoice = -1;
//
//        try {
//            userInputChoice = in.nextInt();
//
//            if (userInputChoice > 2) {
//
//                throw new ArithmeticException("Not a valid selection, try 1 , or 2.");
//
//            } else if (userInputChoice < 1) {
//
//                throw new ArithmeticException("Not a valid selection, try 1, or 2.");
//
//            } else {
//                System.out.println("Generating output for option: " + userInputChoice);
//
//                if (userInputChoice == 1) {
//
//
//                    generateFile();
//
//                } else {
////File output
//                    writeToConsole();
//
//
//                }
//            }
//
//
//        } catch (InputMismatchException a) {
//            System.out.print("Problem");
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//
//
//        switch (userInputChoice) {
//            case -1:
//                //No valid input
//                break;
//        }
//    }
//--------------------------------------------------------------
    public void generateFile() throws FileNotFoundException {
        circle = new CircularShifter();
        ConfigLoader props = new ConfigLoader();
        ArrayList<String> list = circle.getList();
//Write txt file
        if (props.lineCountSetting.equals("Before")) {
            props.headerLine += "Line count: " + props.lineCounter + "\n" + "\n";
        } else if (props.lineCountSetting.equals("After")) {
//            props.footerLine += "\nLine count: " + props.lineCounter;
        }

        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter("KWIC_Result_File__HW3_Montreaux_Rodgers.txt"));
            writer.write(props.headerLine);
            for (int i = 0; i < list.size(); i++)
                writer.write(list.get(i) + System.getProperty("line.separator"));

        } catch (IOException e) {
        } finally {
            try {
                if (writer != null)
//                    writer.write(props.footerLine);
                writer.close();
            } catch (IOException e) {
            }
        }
        System.out.println("Your file has been written to  the SRC directory of this project.");


    }

    public void writeToConsole() {

        circle = new CircularShifter();
        ArrayList<String> list = circle.getList();
        for (int i = 0; i < list.size(); i++)
            System.out.println(list.get(i));


    }


}
