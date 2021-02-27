package kwic;

import java.util.ArrayList;

public class Header extends OutputDecorator{
    ConfigLoader properties = new ConfigLoader();

    public void addHeader(ArrayList<String> list) {
        String header = properties.getSetting("headerText");
        LineStorage storage = new LineStorage();
                storage.addCountAfter(header ,list);

    }
}
