package csv;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Parser_txt {
    private Map<String, Integer> map_words;

    public Parser_txt() {
        map_words = new HashMap<>();
    }

    public int add_words(String line) {
        int count = 0;
        String [] words = line.split("[^a-zA-Z0-9']+");
        for (String i : words) {
            map_words.merge(i, 1, (oldValue, newValue) -> oldValue + newValue);
            count++;
        }
        return count;
    }

    public Map<String, Integer> get_map() {
        return map_words;
    }

}
