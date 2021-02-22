package kwic;

import javax.sound.sampled.Line;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MasterControl {
    LineStorage storage = new LineStorage();
    private List stringList = new ArrayList<String>();
    public static void main(String[] args) throws IOException {
//Load Properties
        ConfigLoader properties = new ConfigLoader();
        properties.loadProperties();
        String input_type = properties.getSetting("input");
        if (input_type == "kwic.FileInput") {
            stringList =
        }





    }


}
