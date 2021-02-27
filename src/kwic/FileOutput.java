package kwic;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class FileOutput extends Output{
    public void generateFile(ArrayList<String> list) throws FileNotFoundException {
        LineStorage lineStore = new LineStorage();
        ConfigLoader props = new ConfigLoader();

//Write txt file
        if (props.lineCountSetting.equals("Before")) {
            props.headerLine += "Line count: " + props.lineCounter + "\n" + "\n";
        } else if (props.lineCountSetting.equals("After")) {
//            props.footerLine += "\nLine count: " + props.lineCounter;
        }

        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter("KWIC_Result_File__HW2_Refactored_Montreaux_Rodgers.txt"));
            writer.write(props.headerLine);
            for (int i = 0; i < list.size(); i++)
                writer.write(list.get(i) + System.getProperty("line.separator"));

        } catch (IOException e) {
        } finally {
            try {
                if (writer != null)
//                    writer.write(props.footerLine);
                    writer.close();
            } catch (IOException e) {
            }
        }
        System.out.println("Your file has been written to  the SRC directory of this project.");


    }

}
