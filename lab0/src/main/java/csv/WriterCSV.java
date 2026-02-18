package csv;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class WriterCSV implements AutoCloseable {
    private final BufferedWriter csvFile;

    public WriterCSV() throws IOException {
        csvFile = new BufferedWriter(new FileWriter("src/main/resources/Words.csv"));
    }

    public void WriteInCsv(ArrayList<Words> ListWords, int countOfWords) {
        try {
            csvFile.write("Word;count_word;frequency\n");
            for (Words wordsCount : ListWords) {
                double frequency = (wordsCount.count() * 100.0) / countOfWords;
                csvFile.write(wordsCount.word() + ";" + wordsCount.count() + ";" + frequency + "\n");
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    @Override
    public void close() throws IOException {
        if (csvFile != null) {
            csvFile.close();
        }
    }
}
