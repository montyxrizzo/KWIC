package kwic;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class  FileInput implements Input {
    private ArrayList<String> fileStrings =  new ArrayList<String>();

    public ArrayList<String> readFile() throws Exception {

        CircularShifter circle = new CircularShifter();

        Scanner in = new Scanner(System.in);
        LineStorage lineStorage = new LineStorage();
        ArrayList<String> currentList = new ArrayList<String>();

        BufferedReader reader;
        try {
            try {
                currentList = circle.getList();
                if (currentList.isEmpty()) {

                    System.out.println("Please enter the absolute filepath to a .txt file containing the data you would like to shift.");


                    String filePath = in.nextLine();

                    reader = new BufferedReader(new FileReader(
                            filePath));

                    String line = reader.readLine();
                    lineStorage.getRecordFromLine(line);

                    fileStrings.add(line);

                    while (line != null) {

                        line = reader.readLine();
                        if (line == null) {
                            return fileStrings;
                        }
                        fileStrings.add(line);

//

                    }

//
                    reader.close();
                } else if (currentList != null) {
                    System.out.println("Please enter the absolute filepath to a .txt file containing the STOPWORDS you would like to ommit.");

                    String filePath = in.nextLine();

                    reader = new BufferedReader(new FileReader(
                            filePath));

                    String line = reader.readLine();
                    fileStrings.clear();
                    fileStrings.add(line);


                }
            } catch (IOException e) {
                e.printStackTrace();

            }
        } catch (NullPointerException e) {
            return fileStrings;

        } catch (Exception e) {

        }

        return fileStrings;


    }
}
