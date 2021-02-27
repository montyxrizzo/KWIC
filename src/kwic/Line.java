package kwic;

import java.util.ArrayList;

public class Line {
    public  int lineCount;
    private ArrayList<String> lines;


    public Line(ArrayList<String> lines){
        this.lines = lines;
    }
    public  ArrayList<String> getLines(){
        return lines;
    }


    public Line() {

    }
    public void setLineCount(int count){
        lineCount = count;
    }


}
