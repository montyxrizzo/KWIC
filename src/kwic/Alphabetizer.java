package kwic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Collections;

public class Alphabetizer {
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
}
