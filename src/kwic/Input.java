package kwic;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Input {

//    interface


    private ArrayList inputList = new ArrayList<String>();

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

                    inputList.add(line);

                    while (line != null) {

                        line = reader.readLine();
                        if (line == null) {
                            return inputList;
                        }
                        inputList.add(line);

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
                    inputList.clear();
                    inputList.add(line);


                }
            } catch (IOException e) {
                e.printStackTrace();

            }
        } catch (NullPointerException e) {
            return inputList;

        } catch (Exception e) {

        }

        return inputList;


    }


    public List<String> readConsoleInput() throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        LineStorage lineStorage = new LineStorage();
            try {

                System.out.println("Please enter the sentences you would like to Circularly shift, separated by comma.");

                for (String line = in.readLine(); line != ""; line = in.readLine()) {
//                    System.out.println(line);


                    lineStorage.getRecordFromLine(line);
                    List lineArray = lineStorage.getRecordFromLine(line);
                    inputList.add(line);

                    StringBuffer sb = new StringBuffer();

                    for (Object s : lineArray) {
                        sb.append(s);
                        sb.append(" ");
                    }
                    if (line.equals("")) {
                        return inputList;
                    }
//
//
                }

                in.close();

            } catch (IOException e) {
                e.printStackTrace();

            }
        catch (NullPointerException e) {
            System.out.println("NullPointerException thrown!");

        }

        return inputList;

    }

}

