package kwic;

import java.util.ArrayList;

public class ConsoleOutput extends  Output{
    LineStorage lineStore = new LineStorage();
    public void writeToConsole() {

//        circle = new CircularShifter();
        ArrayList<String> list = lineStore.getList();
        for (int i = 0; i < list.size(); i++)
            System.out.println(list.get(i));


    }
}
