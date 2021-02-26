package kwic;

import javax.sound.sampled.Line;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MasterControl {
    private static ArrayList<String> stringList;
    ArrayList<String> shiftedList;
    public static void main(String[] args) throws Exception {
        LineStorage storage = new LineStorage();
        Alphabetizer alphabetizer = new Alphabetizer();
//Load Properties
        ConfigLoader properties = new ConfigLoader();
        properties.loadProperties();
        String input_type = properties.getSetting("input");
        String stopWords  = properties.getSetting("circShift");
        String sort = properties.getSetting("sort");

        Input input;
       ArrayList<String> stringList;
        ArrayList<String> shiftedList;
        switch (input_type){
            case "kwic.ConsoleInput":
                input = new ConsoleInput();
                stringList = (ArrayList<String>) ((ConsoleInput) input).readConsoleInput();
                break;

            default:
                input = new FileInput();
                String file = properties.getSetting("path");
                stringList = ((FileInput) input).readFile(file);
                break;
        }
        CircularShifter circle = new CircularShifter();
         shiftedList =  circle.shiftAtLine(stringList);


        switch (stopWords){
            case "kwic.StopWordShift":
                shiftedList = alphabetizer.removeStopWords(shiftedList);
                break;
            default:
                break;
        }
        ArrayList<String> sortedList;
        switch (sort){
            case "kwic.CaseSensitive":
                sortedList = alphabetizer.sortList(shiftedList);

            default:
                sortedList = alphabetizer.caseInsensitiveSort(shiftedList);
        }
System.out.println(sortedList);

//        for (String line: sortedList) {
//            System.out.println(line);
//        }










    }


}
