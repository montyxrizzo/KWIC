
import java.io.IOException;
import java.util.List;

public class MasterControl {
    public static void main(String[] args) throws IOException {
//        Input input = new Input();

        PropertyLoader properties = new PropertyLoader();
        properties.getPropValues();
        String result = properties.result;

    }



}
