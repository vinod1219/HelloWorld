import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LargeFileReaderSam {
    public static void main(String[] args) {
        String filePath = "/Users/vinik/IdeaProjects/HelloWorld/Files/largefile.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Process each line of the file here
                // Example: Print each line
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}