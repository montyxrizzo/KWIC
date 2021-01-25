import com.sun.tools.javac.util.ArrayUtils;

import javax.sound.sampled.Line;
import java.util.*;

import static java.util.Collections.swap;
public class CircularShifter {
    private static ArrayList<List<String>> fullList = new ArrayList<List<String>>();
    public ArrayList<List<String>>  getList() { return fullList; }
    public static void shiftAtLine (List<String> list){
       LineStorage line = new LineStorage();

        for(int i = 0; i < list.size();i++) {
            list.add(list.remove(0));
            System.out.println(list);
            line.saveLine(list);
            fullList.add(list);

        }



    }


}
