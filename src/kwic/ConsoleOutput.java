package kwic;

import java.util.ArrayList;

public class ConsoleOutput extends  Output{
    public void writeToConsole(ArrayList<String> list) {

        for (int i = 0; i < list.size(); i++)
            System.out.println(list.get(i));


    }
}
