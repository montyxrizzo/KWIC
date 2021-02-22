package kwic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ConsoleInput extends Input {
    private ArrayList<String> fileStrings =  new ArrayList<String>();

        public List<String> readConsoleInput() throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        LineStorage lineStorage = new LineStorage();
        try {

            System.out.println("Please enter the sentences you would like to Circularly shift, separated by comma.");

            for (String line = in.readLine(); line != ""; line = in.readLine()) {
//                    System.out.println(line);


                lineStorage.getRecordFromLine(line);
                List lineArray = lineStorage.getRecordFromLine(line);
                fileStrings.add(line);

                StringBuffer sb = new StringBuffer();

                for (Object s : lineArray) {
                    sb.append(s);
                    sb.append(" ");
                }
                if (line.equals("")) {
                    return fileStrings;
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

        return fileStrings;

    }
}
