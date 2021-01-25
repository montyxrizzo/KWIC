import java.util.*;

public class CircularShifter {
    private static List<String> tmpLine;
    private static ArrayList<List<String>> testArray = new ArrayList<List<String>>();

    private static LineStorage line = new LineStorage();
    private static ArrayList<List<String>> fullList = new ArrayList<List<String>>();
    public ArrayList<List<String>>  getList() { return fullList; }
    static void shiftAtLine(List<String> list){


        for(int i = 0; i < list.size();i++) {
            list.add(list.remove(0));
            System.out.println(list);
            tmpLine = list;
            fullList.add(tmpLine);
//            testArray.set(i, tmpLine);
//            System.out.println(fullList);
        }
//        System.out.println(testArray);


    }


}
