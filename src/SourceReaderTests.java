import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SourceReaderTests {

    @Test
    void testBasic() {
        SourceReader sr = new SourceReader("\\Users\\HCM\\eclipse-workspace\\selenium-jobscraper\\sources");
        ArrayList<String> sourceList = sr.getSourceList();
        String firstSource = sourceList.get(0);
        Assertions.assertEquals("", firstSource);
    }

}
