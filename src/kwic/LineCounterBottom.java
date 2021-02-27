package kwic;

import java.util.ArrayList;

public class LineCounterBottom extends OutputDecorator  {


    public void  addCount(ArrayList<String> list) {
        int lineCount = list.size();
        storage.addCountAfter(String.valueOf(lineCount),list);
    }

}
