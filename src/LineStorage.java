import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.*;


public class LineStorage {

    private  List<List<String>> transList = new ArrayList<>();

    private  List<List<String>> transList = new ArrayList<>();
    // Setter

    public void setList(List list) { this.listTrans = list; }

//    public void setList(ArrayList<String> list)
    {
//        this.listTrans.add(list);
    }
    // Getter
    public List getList() {
        return listTrans;
    }

    public static List<String> getWords(String line){
        int count = line.length();
        List<String> list = new ArrayList<String>();
        String [] words = line.split(" ", count );

        for (String word : words) {
            list.add(word);

        }
        return list;
    }



    public static List<String> getRecordFromLine(String line) {
        List<String> values = new ArrayList<String>();
        try (Scanner rowScanner = new Scanner(line)) {
//            System.out.println(line);
            rowScanner.useDelimiter(",");
            while (rowScanner.hasNext()) {
                for(int i=0;i<values.size();i++){
//                    System.out.println(values.get(i));
                }
                values.add(rowScanner.next());

            }
        }
//        System.out.println(values);
        return values;
    }
    public  List saveLine(List line) {

        list.add(line);
        transList.add(line);
        this.setList(transList);


//
        return list;
    }

}
