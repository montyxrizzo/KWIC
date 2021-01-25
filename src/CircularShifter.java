import java.util.*;

public class CircularShifter {
    private static List<String> tmpLine;
    private static LineStorage line = new LineStorage();
    private static ArrayList<String> fullList =  new ArrayList<String>();

    public ArrayList<String>  getList() { return fullList; }

    static void shiftAtLine(List<String> list){


        for(int i = 0; i < list.size();i++) {
            list.add(list.remove(0));
//            System.out.println(list);
            tmpLine = list;
//            Cast to string
//            Turn list string to new string
            StringBuffer sb = new StringBuffer();

            for (String s : tmpLine) {
                sb.append(s);
                sb.append(" ");
            }

            String str = sb.toString();
            str = str.replace(",", "");
//            System.out.println(str);
            fullList.add(str);
            fullList.add("\n");
//            testArray.set(i, tmpLine);
//            System.out.println(fullList);
        }
//        System.out.println(testArray);


    }


}
