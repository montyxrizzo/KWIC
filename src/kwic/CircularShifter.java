package kwic;

import java.util.*;

public class CircularShifter {
    private  ArrayList<String> line;
    private static LineStorage linestore = new LineStorage();




    public ArrayList<String> shiftAtLine(ArrayList<String> list) {

        ArrayList<String> newList = new ArrayList<>();
        for (int k = 0; k < list.size(); k++) {
            line = linestore.getWords(list.get(k));
            for (int i = 0; i < line.size(); i++) {
                line.add(line.remove(0));
//                tmpLine = line;
                StringBuffer sb = new StringBuffer();
                for (String s : line) {
                    sb.append(s);
                    sb.append(" ");
                }
                String str = sb.toString();
                newList.add(str);
//                break;


            }


        }
//        newList = list;



        return newList ;
    }




}
