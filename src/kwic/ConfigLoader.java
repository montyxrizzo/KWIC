package kwic;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

public class ConfigLoader {


    String result = "";
    InputStream inputStream;
    public static String lineCounter = "";
    public static String headerLine = "";
    public static String lineCountSetting = "";
    private static final Properties prop = new Properties();

    public String loadProperties() throws IOException {

        try {
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
            String formatHeader = prop.getProperty("formatHeader");

            String output = prop.getProperty("output");
            String lineCount = prop.getProperty("lineCount");
            this.lineCountSetting = lineCount;

            result = "Configurations:" + input + ", " + sort + ", " + circShift + "," + formatFooter + "," + output + ", " + lineCount;


            Input inputChoice = new Input();

            System.out.println("Config Options: " + result);
        } catch (Exception e) {
            System.out.println("Exception: " + e);
        } finally {
            inputStream.close();

        }
        return result;
    }
    public static String getSetting(String key) {
        return prop.getProperty(key);
    }
}

