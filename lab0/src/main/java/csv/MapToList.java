package csv;

import java.util.ArrayList;
import java.util.Map;

public class MapToList {
    public static ArrayList<Words> toList(Map<String, Integer> MapWords) {
        ArrayList<Words> SortedWords = new ArrayList<>();

        for (Map.Entry<String, Integer> entry : MapWords.entrySet()) {
            SortedWords.add(new Words(entry.getKey(), entry.getValue()));
        }

        SortedWords.sort((a, b) -> a.count() - b.count());
        return SortedWords;
    }
}
