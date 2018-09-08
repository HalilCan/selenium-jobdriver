import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

@SuppressWarnings("unused")
class SourceReaderTests {

    @Test
    void testBasic() {
        SourceReader sr = new SourceReader("\\Users\\HCM\\eclipse-workspace\\selenium-jobscraper\\sources\\uni-sources.csv");
        ArrayList<String> sourceList = sr.getSourceList();
        String firstSource = sourceList.get(1);
        Assertions.assertEquals("https://www.airbnb.com/careers/university", firstSource);
    }

}
