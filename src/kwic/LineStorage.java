package kwic;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.*;


public class LineStorage extends Line{

    public  ArrayList<String>  fullList ;
    public  int lineCount;

    public LineStorage(ArrayList<String> lines) {
        super(lines);
    }

    public LineStorage() {

    }

//    public LineStorage() {
//        super();
//    }


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
        countLines(fullList.size());


    }
    public void clearList(ArrayList<String> list ) {

         fullList.clear();
    }
    public int getLineCount(){

            return lineCount;
    }
    private void countLines (int count){
        this.lineCount = count;
        Line lines = new Line(fullList);
        lines.setLineCount(count);
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
    public void addCountBefore(String count, ArrayList<String> list) {
        this.fullList = list;
        fullList.add(0,count);
    }
    public void addCountAfter(String count,ArrayList<String> list)  {
        this.fullList = list;
        fullList.add(0,count);
    }


}
