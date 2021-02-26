package kwic;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.*;


public class LineStorage {

    private   List<List<String>> listTrans;
    private static ArrayList<String>  fullList ;
    private  ArrayList<String>  shiftedLines ;
    private static ArrayList<String>  shiftedlist;

    public LineStorage() {
    }


    public  ArrayList<String> getWords(String line){
        int count = line.length();
        ArrayList<String> list = new ArrayList<String>();
        String [] words = line.split(" ", count );

        for (String word : words) {
            list.add(word);


        }
        return list;
    }
    public ArrayList<String> getList() {
        return fullList;
    }
    public void setList(ArrayList<String> list ) {

        fullList = list;
    }
    public void clearList(ArrayList<String> list ) {

         fullList.clear();
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

    public void addLine(String line) {
        fullList.add(line);
    }
    public  void addShiftedLine(String line) {
        shiftedLines.add(line);
    }
}
