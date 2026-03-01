import csv.MapToList;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import csv.Words;
import csv.Parser_txt;
import csv.WriterCSV;

class TestCsvParser {

    @Test
    void TestMapToList() {
        Map<String, Integer> testMap = new HashMap<>();
        testMap.put("Hello", 5);
        testMap.put("World", 3);
        testMap.put("9", 8);
        ArrayList<Words> testArray = MapToList.toList(testMap);
        Words result = testArray.get(1);
        assertEquals("Hello", result.word());
        assertEquals(5, result.count());
    }

    @Test
    void TestParserTxt() {
        String TestLine = "Hello, world! 923-435";
        Parser_txt TestParser = new Parser_txt();
        int count = TestParser.add_words(TestLine);
        Map<String, Integer> TestMap = TestParser.get_map();
        assertEquals(4, count);
        assertEquals(1, TestMap.get("923"));
    }
}
