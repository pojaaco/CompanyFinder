package org.example;

import org.example.monitor.FileProcessor;
import org.example.monitor.FolderMonitor;

import java.io.IOException;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        long startTime = System.nanoTime();

        String folderPath = "import";

        FolderMonitor folderMonitor = new FolderMonitor(folderPath);
        FileProcessor fileProcessor = new FileProcessor();

        folderMonitor.addObserver(fileProcessor);

        String initialFilePath = "import/companies_big_data.csv";
        fileProcessor.update(Paths.get(initialFilePath));

        long endTime = System.nanoTime();
        System.out.println("Time: " + (endTime - startTime));

        folderMonitor.startMonitoring();
    }
}