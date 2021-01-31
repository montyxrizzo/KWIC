
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

public class PropertyLoader {


    String result = "";
    InputStream inputStream;
    private List transList = new ArrayList<String>();
    ;


    public String getPropValues() throws IOException {

        try {

            Properties prop = new Properties();
            String propFileName = "config.properties";


            inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);

            if (inputStream != null) {
                prop.load(inputStream);
            } else {
                throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
            }

            Date time = new Date(System.currentTimeMillis());

            // get the property value and print it out
            String input = prop.getProperty("input");
            String sort = prop.getProperty("sort");
            String circShift = prop.getProperty("circShift");
            String formatFooter = prop.getProperty("formatFooter");
            String output = prop.getProperty("output");
            String lineCount = prop.getProperty("lineCount");


            result = "Configurations:" + input + ", " + sort + ", " + circShift + "," + formatFooter + "," + output + ", " + "," + lineCount;
//            ~~~~   Strategy Pattern ~~
            Input inputChoice = new Input();
//                System.out.println(input);
//            Input
            if (input.equals("kwic.FileInput")) {


                transList = inputChoice.readFile();
                System.out.println(transList);

            } else if (input.equals("kwic.ConsoleInput")) {
                transList = inputChoice.readConsoleInput();


            } else {
                System.out.println("Not a valid input option!");

            }
//                CircShift ~~~~
            CircularShifter shifter = new CircularShifter();
            if (circShift.equals("kwic.NoStopWordShift")) {
                transList = shifter.shiftAtLine(transList);


            } else if (circShift.equals("kwic.StopWordShift")) {
                transList = shifter.shiftAtLine(transList);
                transList =  shifter.removeStopWords(transList);

            } else {
                System.out.println("Invalid CircShift Option");
            }
// Sorting Options
            if (sort.equals("kwic.CaseSensitive")) {


            } else {

            }


//             ~~~~~   Output ~~~~~~
            Output out = new Output();
//                    out.promptUserOutput();
            if (output.equals("kwic.FileOutput")) {


                out.generateFile();

            } else if (output.equals("kwic.ConsoleOutput")) {
                out.writeToConsole();

            } else {
                System.out.println("Not a valid output option!");

            }


            System.out.println("Config Options: " + result);
        } catch (Exception e) {
            System.out.println("Exception: " + e);
        } finally {
            inputStream.close();
        }
        return result;
    }
}

