package kwic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Collections;

public class Alphabetizer extends LineStorage {
    private static ArrayList<String> stopwords;
    LineStorage linestore;
  private  static  ArrayList<String> currentList = new ArrayList<String>();


    public static ArrayList<String> sortList(List<String> list) {
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
        ArrayList<String> stringList = new ArrayList<String>(Arrays.asList(myArray)); //new ArrayList is only needed if you absolutely need an ArrayList

//        String newString = Arrays.toString(myArray);
        return stringList;

    }

    public static ArrayList<String> caseInsensitiveSort(ArrayList<String> list) {
        String[] myArray = new String[list.size()];
        Collections.sort(list, String.CASE_INSENSITIVE_ORDER);
//        list.




        return list;
    }
    public  static  ArrayList<String> removeStopWords(ArrayList<String> list) {
        FileInput stopwordInput = new FileInput();

        try {
            ConfigLoader properties = new ConfigLoader();
            properties.loadProperties();
            String stopPath = properties.getSetting("stopPath");
            stopwords = stopwordInput.readFile(stopPath);
            String stop =  stopwords.get(0);
            stop.replace("]","");
            stop.replace("[","");
            stop.replace(" ","");
            String stopStr[] = stop.split(",");
            List<String> al = new ArrayList<String>();
            stopwords = (ArrayList<String>) al;
            al = Arrays.asList(stopStr);
            for(String s: al){
                System.out.println(s);
            }
            System.out.println("Stop Words: " + al + "\n");
            // Array of prefixes


            List<String> arr = al;
            for (int j = 0; j < list.size(); j++) {
                // Given string
                String str = list.get(j);
                // Check for each prefix element
                for (int i = 0; i < al.size(); i++) {
                    if (str.startsWith(arr.get(i))) {
//                        currentList =  linestore.getList();
                        list.remove(j);
                        j--;
                        break;
                    }
                }
            }
//            linestore.setList(currentList);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;

    }
}
