package kwic;

import javax.sound.sampled.Line;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MasterControl {
    private static ArrayList<String> stringList;

    public static void main(String[] args) throws Exception {
        LineStorage storage = new LineStorage();

//Load Properties
        ConfigLoader properties = new ConfigLoader();
        properties.loadProperties();
        String input_type = properties.getSetting("input");
        Input input;
       ArrayList<String> stringList;
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
        ArrayList<String> shiftedList =  circle.shiftAtLine(stringList);

        System.out.println(shiftedList);









    }


}
