package texteditor.observer;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CloudSyncService implements Observer<EditorEvent> {

    private final texteditor.observer.TextEditor editor;
    private final Path cloudDir;
    private final DateTimeFormatter ts = DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss-SSS");

    public CloudSyncService(texteditor.observer.TextEditor editor, Path cloudDir) {
        this.editor = editor;
        this.cloudDir = (cloudDir != null) ? cloudDir : Paths.get("cloud");
        try {
            Files.createDirectories(this.cloudDir);
        } catch (IOException e) {
            throw new RuntimeException("Failed to create cloud directory: " + this.cloudDir, e);
        }
    }

    @Override
    public void update(EditorEvent event) throws IOException {
        if (event != EditorEvent.SAVE) return;
        String filename = "cloud-copy-" + ts.format(LocalDateTime.now()) + ".txt";
        Path target = cloudDir.resolve(filename);
        Files.writeString(target, editor.getText(), StandardCharsets.UTF_8,
                StandardOpenOption.CREATE_NEW);
        System.out.println("[CloudSync] Uploaded " + target.toAbsolutePath());
    }
}
