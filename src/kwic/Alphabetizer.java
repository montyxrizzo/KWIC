package kwic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Collections;

public class Alphabetizer extends LineStorage {
    private static List<String> stopwords;
    LineStorage linestore;
    ArrayList<String> currentList;


    public static String sortList(List<String> list) {
        String[] myArray = new String[list.size()];
        myArray = list.toArray(myArray);
        int size = myArray.length;

        for (int i = 0; i < size - 1; i++) {
            for (int j = i + 1; j < myArray.length; j++) {
                if (myArray[i].compareTo(myArray[j]) > 0) {
                    String temp = myArray[i];
                    myArray[i] = myArray[j];
                    myArray[j] = temp;
                }
            }
        }
        List<String> tmpList = new ArrayList<String>(Arrays.asList(myArray));
        myArray = tmpList.toArray(new String[0]);
        Arrays.sort(myArray);
        String newString = Arrays.toString(myArray);
        return newString;

    }

    public static String caseInsensitiveSort(List<String> list) {
        String[] myArray = new String[list.size()];
        Collections.sort(list, String.CASE_INSENSITIVE_ORDER);
        String newString = Arrays.toString(myArray);


        return newString;
    }
    private  ArrayList<String> removeStopWords(List<String> list) {
        FileInput stopwordInput = new FileInput();

        try {
            ConfigLoader properties = new ConfigLoader();
            properties.loadProperties();
            String stopPath = properties.getSetting("stopPath");
            stopwords = stopwordInput.readFile(stopPath);
            stopwords = linestore.getWords(stopwords.get(0));
            System.out.println("Stop Words: " + stopwords + "\n");
            // Array of prefixes


            List<String> arr = stopwords;
            for (int j = 0; j < list.size(); j++) {
                // Given string
                String str = list.get(j);
                // Check for each prefix element
                for (int i = 0; i < stopwords.size(); i++) {
                    if (str.startsWith(arr.get(i))) {
                        currentList =  linestore.getList();
                        currentList.remove(j);

                        break;
                    }
                }
            }
//            linestore.setList(currentList);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return currentList;

    }
}
