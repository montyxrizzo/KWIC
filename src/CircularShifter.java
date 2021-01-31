import java.lang.reflect.Array;
import java.util.*;

public class CircularShifter {
    //    private static List<String> tmpLine;
    private static List<String> line;
    private static ArrayList<String> fullList = new ArrayList<String>();
    private static LineStorage linestore = new LineStorage();
    private  static List<String> stopwords;
    public ArrayList<String> getList() {
        return fullList;
    }

    public static ArrayList<String> shiftAtLine(List<String> list) {


        for (int k = 0; k < list.size(); k++) {
            line = linestore.getWords(list.get(k));
            for (int i = 0; i < line.size(); i++) {
                line.add(line.remove(0));
//                tmpLine = line;
                StringBuffer sb = new StringBuffer();
                for (String s : line) {
                    sb.append(s);
                    sb.append(" ");
                }
                String str = sb.toString();
//            str = str.replace(",", "");
                fullList.add(str);
//                fullList.add("\n");

            }
        }

        return fullList;
    }

    public static ArrayList<String> removeStopWords(List<String> list) {
        Input stopwordInput = new Input();

        try {
            stopwords = stopwordInput.readFile();
            stopwords = linestore.getWords(stopwords.get(0));
            System.out.println("Stop Words: " + stopwords);
            // Array of prefixes


            List<String> arr = stopwords;
            for (int j = 0; j < list.size(); j++) {
                // Given string
                String str = list.get(j);

                boolean result = false;

                // Check for each prefix element
                for (int i = 0; i < stopwords.size(); i++) {
//                    System.out.print(arr.get(i));
                    if (str.startsWith(arr.get(i))) {
                        result = true;
                        fullList.remove(j);
                        break;
                    }
                }


//                if (result)
//                    System.out.println("Given String "
//                            + "starts with one of the prefixes, removing row");
//
//                else
//                    System.out.println("Given String do not "
//                            + "starts with one of the prefixes.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return fullList;

    }


}
