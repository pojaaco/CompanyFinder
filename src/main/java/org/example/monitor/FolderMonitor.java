package org.example.monitor;

import java.io.IOException;
import java.nio.file.*;
import java.util.*;

public class FolderMonitor implements Subject {
    private final List<Observer> observers = new ArrayList<>();
    private final Path folderPath;

    public FolderMonitor(String folderPath) {
        this.folderPath = Paths.get(folderPath);
    }

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(Path filePath) {
        for (Observer observer : observers) {
            observer.update(filePath);
        }
    }

    public void startMonitoring() throws IOException, InterruptedException {
        WatchService watchService = FileSystems.getDefault().newWatchService();
        folderPath.register(watchService, StandardWatchEventKinds.ENTRY_CREATE, StandardWatchEventKinds.ENTRY_MODIFY);

        int count = 0;
        WatchKey key;
        while ((key = watchService.take()) != null) {
            System.out.println("========== START " + count + " ==========");
            for (WatchEvent<?> event : key.pollEvents()) {
                if (event.kind() == StandardWatchEventKinds.ENTRY_CREATE
                        || event.kind() == StandardWatchEventKinds.ENTRY_MODIFY) {
                    Path changedFilePath = folderPath.resolve((Path) event.context());
                    System.out.println("File changed: " + changedFilePath);
                    notifyObservers(changedFilePath);
                }
            }

            key.reset();
            System.out.println("========== END ==========\n");
            count++;
        }
    }
}
