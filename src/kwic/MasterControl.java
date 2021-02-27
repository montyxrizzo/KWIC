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
        String lineCount = properties.getSetting("lineCount");
        String formatHeader = properties.getSetting("formatHeader");
        String formatFooter = properties.getSetting("formatFooter");
        String outputSetting = properties.getSetting("output");

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
//        System.out.println(sort);
        switch (sort){
            case "kwic.CaseSensitive":
                sortedList = alphabetizer.sortList(shiftedList);
                break;

            default:
                sortedList = alphabetizer.caseInsensitiveSort(shiftedList);
        }
        storage.setList(sortedList);
        OutputDecorator decorator;
        switch (lineCount) {
            case "Before":

                decorator = new LineCounterTop();
                ((LineCounterTop) decorator).addCount(sortedList);
                break;
            default:
                decorator = new LineCounterBottom();
                ((LineCounterBottom) decorator).addCount(sortedList);
                break;
        }
        switch (formatHeader){
            case "True" :
                decorator = new Header();
                ((Header) decorator).addHeader(sortedList);
                break;
            default:
                break;

        }
        switch (formatFooter){
            case "True" :
                decorator = new Footer();
                ((Footer) decorator).addFooter(sortedList);
                break;
            default:
                break;

        }

        Output output;

        switch ( outputSetting){
            case "kwic.FileOutput":
                output = new FileOutput();
                ((FileOutput) output).generateFile(sortedList);
                break;
            default:
                output = new ConsoleOutput();
                ((ConsoleOutput) output).writeToConsole(sortedList);
                break;

        }


        System.out.println("Program Complete");



//        for (String line: sortedList) {
//            System.out.println(line);
//        }










    }


}
