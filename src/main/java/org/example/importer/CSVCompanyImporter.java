package org.example.importer;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import org.example.model.Company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVCompanyImporter extends CompanyImporter {
    private CSVReader reader;

    @Override
    protected void openFile(String filePath) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))) {
            reader = new CSVReader(bufferedReader);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected List<Company> parseFile() {
        List<Company> companies = new ArrayList<>();
        try {
            String[] line;
            while ((line = reader.readNext()) != null) {
                if (!line[0].equalsIgnoreCase("ID")) {
                    int id = Integer.parseInt(line[0]);
                    String name = line[1];
                    String foundationDate = line[2];
                    double capital = Double.parseDouble(line[3]);
                    String country = line[4];
                    boolean isHQ = (line.length >= 6 && line[5].compareTo("1") == 0);
                    companies.add(new Company(id, name, foundationDate, capital, country, isHQ));
                }
            }
        } catch (IOException | CsvValidationException e) {
            e.printStackTrace();
        }
        return companies;
    }

    @Override
    protected void closeFile() {
        try {
            if (reader != null) {
                reader.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
