package kwic;

import java.util.ArrayList;

public class LineCounterTop extends OutputDecorator{






    public void  addCount(ArrayList<String> sortedList) {
        int lineCount = sortedList.size();
        storage.addCountBefore(String.valueOf(lineCount),sortedList);
    }
//    private  int lineCount;
//



}
