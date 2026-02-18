package csv;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import java.util.ArrayList;
import java.util.Map;

public class Main_class {
    static void main(String args[]) {
        if (args.length == 0) {
            System.err.println("Не передан путь к файлу");
            return;
        }
        try (FileReader fileR = new FileReader(args[0]);
             BufferedReader TxtFile = new BufferedReader(fileR)) {
            String line = TxtFile.readLine();
            int count = 0;
            Parser_txt words = new Parser_txt();
            while (line != null) {
                count += words.add_words(line);
                line = TxtFile.readLine();
            }
            Map<String, Integer> mapWords = words.get_map();
            ArrayList<Words> sortedWords;
            sortedWords = MapToList.toList(mapWords);
            try (WriterCSV csvFile = new WriterCSV()) {
                csvFile.WriteInCsv(sortedWords, count);
            }

        } catch (IOException e) {
            System.err.println(e.getMessage());
        }

    }
}
