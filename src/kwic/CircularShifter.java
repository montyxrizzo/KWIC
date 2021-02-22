package kwic;

import java.util.*;

public class CircularShifter {
    private static List<String> line;
    private static ArrayList<String> fullList = new ArrayList<String>();
    private static LineStorage linestore = new LineStorage();
    private static List<String> stopwords;

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
                fullList.add(str);

            }
        }

        return fullList;
    }

    public static ArrayList<String> removeStopWords(List<String> list) {
        Input stopwordInput = new Input();

        try {
            stopwords = stopwordInput.readFile();
            stopwords = linestore.getWords(stopwords.get(0));
            System.out.println("Stop Words: " + stopwords + "\n");
            // Array of prefixes


            List<String> arr = stopwords;
            for (int j = 0; j < list.size(); j++) {
                // Given string
                String str = list.get(j);
                // Check for each prefix element
                for (int i = 0; i < stopwords.size(); i++) {
                    if (str.startsWith(arr.get(i))) {
                        fullList.remove(j);
                        break;
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return fullList;

    }


}
