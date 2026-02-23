import csv.MapToList;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import csv.Words;

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
        void TestParserTxt() {

        }
}
