
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

public class IODecorator {


    String result = "";
    InputStream inputStream;
    public static String lineCounter = "";
    private List transList = new ArrayList<String>();
    public static String headerLine = "";
    public static String footerLine = "";
    public static String lineCountSetting = "";

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
            String formatFooter = prop.getProperty("formatHeaderFooter");
            String output = prop.getProperty("output");
            String lineCount = prop.getProperty("lineCount");
            this.lineCountSetting = lineCount;

            result = "Configurations:" + input + ", " + sort + ", " + circShift + "," + formatFooter + "," + output + ", " + lineCount;
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
// CircShift
            CircularShifter shifter = new CircularShifter();
            if (circShift.equals("kwic.NoStopWordShift")) {
                transList = shifter.shiftAtLine(transList);


            } else if (circShift.equals("kwic.StopWordShift")) {
                transList = shifter.shiftAtLine(transList);
                transList = shifter.removeStopWords(transList);

            } else {
                System.out.println("Invalid CircShift Option");
            }
// Sorting Options
            Alphabetizer sorter = new Alphabetizer();
            if (sort.equals("kwic.CaseSensitive")) {
                sorter.sortList(transList);

            } else {
                sorter.caseInsensitiveSort(transList);
            }


//             ~~~~~   Output ~~~~~~
            int counter = 0;
            for (int i = 0; i < transList.size(); i++)
                if (transList.get(i) != null)
                    counter++;
            this.lineCounter = "There are " + counter + " lines in your output.";
            Output out = new Output();
            if (lineCount.equals("Before")) {

                System.out.println(this.lineCounter);

            }


            if (output.equals("kwic.FileOutput")) {

                if (formatFooter.equals("True")) {
                    String header = "~ KWIC Output Header  ~ ";
                    String footer = " ~ KWIC footer ~ ";

                    System.getProperty("line.separator");
                    headerLine = header + System.getProperty("line.separator") + "\n";
                    footerLine = "\n" + System.getProperty("line.separator") + footer;
                }

                out.generateFile();

            } else if (output.equals("kwic.ConsoleOutput")) {
                out.writeToConsole();

            } else {
                System.out.println("Not a valid output option!");

            }
            if (lineCount.equals("After")) {

                System.out.println("There are " + counter + " lines in your output.");

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

