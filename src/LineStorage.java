import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.*;


public class LineStorage {

    private   List<List<String>> listTrans;




    public  List<String> getWords(String line){
        int count = line.length();
        List<String> list = new ArrayList<String>();
        String [] words = line.split(" ", count );

        for (String word : words) {
            list.add(word);

        }
        return list;
    }



    public  List<String> getRecordFromLine(String line) {
        List<String> values = new ArrayList<String>();
        try (Scanner rowScanner = new Scanner(line)) {
            rowScanner.useDelimiter(",");
            while (rowScanner.hasNext()) {
                for(int i=0;i<values.size();i++){
                }
                values.add(rowScanner.next());

            }
        }

        return values;
    }

}
