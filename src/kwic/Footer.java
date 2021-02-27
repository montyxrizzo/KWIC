package kwic;

import java.util.ArrayList;

public class Footer extends  OutputDecorator{
    ConfigLoader properties = new ConfigLoader();

    public ArrayList<String> addFooter(ArrayList<String> list){
        String footer = properties.getSetting("footerText");
        LineStorage storage = new LineStorage();
        list.add(footer);
    return list;
    }
}
