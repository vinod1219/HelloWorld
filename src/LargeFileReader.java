import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class LargeFileReader {

    public static void main(String[] args) {
        String filePath = "/Users/vinik/IdeaProjects/HelloWorld/Files/largefile.txt";
        Map<String, Integer> lineCountMap = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            int i=1;
            while ((line = reader.readLine()) != null) {
               i=i+1;
                // Process each line and count occurrences
                if (!lineCountMap.containsKey(line)) {
                    //lineCountMap.put(line, lineCountMap.get(line) + 1);
                    lineCountMap.put(line, i);
                } else {
                    //lineCountMap.put(line, 1);
                    System.out.println("Duplicate" + line);
                }
            }
            System.out.println(lineCountMap.entrySet());
            System.out.println(lineCountMap.get("SE*16*0179"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Generate report CSV
        //generateReportCSV(lineCountMap, "report.csv");
    }

    private static void generateReportCSV(Map<String, Integer> lineCountMap, String outputPath) {
        try (FileWriter writer = new FileWriter(outputPath)) {
            //writer.append("Line,Count\n");
            for (Map.Entry<String, Integer> entry : lineCountMap.entrySet()) {
                writer.append(entry.getKey())
                        .append(",")
                        .append(String.valueOf(entry.getValue()))
                        .append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
