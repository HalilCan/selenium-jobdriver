import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SourceReader {
    String csvPath;
    String splitter = ",";
    String lineBreak = "";

    public SourceReader(String path) {
        this.csvPath = "args[0]";

    }

    List<String> getSourceList() {
        List<String> sourceList = new ArrayList<String>();
        String line = "";

        try (BufferedReader br = new BufferedReader(new FileReader(csvPath))) {
            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] links = line.split(splitter);

                for (int i = 0; i < links.length; i++) {
                    sourceList.add(links[i]);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return sourceList;
    }

    void setSplitter(String splitter) {
        this.splitter = splitter;
    }

    void setLineBreak(String linebreak) {
        this.lineBreak = linebreak;
    }
}
