package org.example.monitor;

import org.example.analyzer.CompanyAnalyzer;
import org.example.importer.CompanyImporter;
import org.example.importer.CompanyImporterFactory;
import org.example.model.Company;

import java.nio.file.Path;
import java.util.List;

public class FileProcessor implements Observer {
    @Override
    public void update(Path filePath) {
        try {
            CompanyImporter importer = CompanyImporterFactory.getImporter(filePath.toString());
            List<Company> companies = importer.importFile(filePath.toString());

            System.out.println("Total capital: " + CompanyAnalyzer.getTotalCapitalOfHQInCH(companies));
            System.out.println("Companies in CH sorted by capital: ");
            for (String name : CompanyAnalyzer.getNameOfCompaniesInCHSortedByCapital(companies)) {
                System.out.println(name);
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
