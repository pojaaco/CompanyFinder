package org.example.monitor;

import java.nio.file.Path;

public interface Observer {
    void update(Path filePath);
}
