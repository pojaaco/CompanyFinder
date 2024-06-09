package org.example.monitor;

import java.nio.file.Path;

public interface Subject {
    void addObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers(Path filePath);
}
