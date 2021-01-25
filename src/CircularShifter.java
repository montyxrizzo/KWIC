
import java.util.*;


public class CircularShifter {
    private static List shiftedList;
    public static void shiftAtLine(List<String> list) {
        LineStorage line = new LineStorage();

        for (int i = 0; i < list.size(); i++) {
            list.add(list.remove(0));
            System.out.println(list);
            line.saveLine(list);
            shiftedList.add(list);

        }
        System.out.println( shiftedList);


    }


}
