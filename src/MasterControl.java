
import java.io.IOException;

public class MasterControl {
    public static void main(String[] args) throws IOException {


        IODecorator properties = new IODecorator();
        properties.getPropValues();

    }


}
