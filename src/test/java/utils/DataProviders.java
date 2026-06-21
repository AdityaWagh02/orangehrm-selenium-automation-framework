package utils;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class DataProviders {

    @org.testng.annotations.DataProvider(name = "loginDataInline")
    public static Object[][] loginDataInline() {
        return new Object[][]{
            {"Admin", "admin123"},
            {"wrong", "wrong"},
            {"", "admin123"},
            {"Admin", ""}
        };
    }

    // CSV-based provider: expects src/test/resources/data/login.csv (no header, username,password)
    @org.testng.annotations.DataProvider(name = "loginDataCsv")
    public static Object[][] loginDataCsv() throws IOException, CsvException {
        String csvPath = "src/test/resources/data/login.csv";
        try (CSVReader reader = new CSVReader(new FileReader(csvPath))) {
            List<String[]> rows = reader.readAll();
            Object[][] data = new Object[rows.size()][2];
            for (int i = 0; i < rows.size(); i++) {
                String[] row = rows.get(i);
                data[i][0] = row.length > 0 ? row[0] : "";
                data[i][1] = row.length > 1 ? row[1] : "";
            }
            return data;
        }
    }
}