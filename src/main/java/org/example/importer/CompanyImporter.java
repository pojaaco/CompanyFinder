package org.example.importer;

import org.example.model.Company;

import java.util.List;

public abstract class CompanyImporter {
    public final List<Company> importFile(String filePath) {
        openFile(filePath);
        List<Company> companies = parseFile();
        closeFile();
        return companies;
    }

    protected abstract void openFile(String filePath);
    protected abstract List<Company> parseFile();
    protected abstract void closeFile();
}
