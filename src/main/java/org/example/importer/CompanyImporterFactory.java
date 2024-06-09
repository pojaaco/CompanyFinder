package org.example.importer;

public class CompanyImporterFactory {
    public static CompanyImporter getImporter(String filePath) {
        if (filePath.endsWith(".csv")) {
            return new CSVCompanyImporter();
        }
        throw new IllegalArgumentException("Unsupported file type: " + filePath);
    }
}
