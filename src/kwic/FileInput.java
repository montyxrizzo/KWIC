package kwic;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class  FileInput extends Input {
    public ArrayList<String> fileStrings =  new ArrayList<String>();
    ArrayList<String> currentList = new ArrayList<String>();
    private LineStorage lineStorage = new LineStorage();

    public ArrayList<String> readFile(String path) throws Exception {

        CircularShifter circle = new CircularShifter();

        Scanner in = new Scanner(System.in);

        BufferedReader reader;
        ArrayList<String> currentList;
        try {

            String filePath;

            try {


                if (this.currentList.isEmpty()) {
//                    System.out.println("Please enter the absolute filepath to a .txt file containing the data you would like to shift.");


                     filePath = path;

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
                } else if (this.currentList != null) {

                     filePath = path;

                    reader = new BufferedReader(new FileReader(
                            filePath));

                    String line = reader.readLine();
                    fileStrings.clear();
                    fileStrings.add(line);
                    lineStorage.addLine(line);


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
