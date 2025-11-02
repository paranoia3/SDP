import org.junit.jupiter.api.Test;
import texteditor.observer.CloudSyncService;
import texteditor.observer.TextEditor;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class CloudSyncServiceTest {

    @Test
    void cloudSyncCreatesCopyOnSave() throws Exception {
        Path tempDir = Files.createTempDirectory("cloud-test-");
        Path savePath = tempDir.resolve("local.txt");
        Path cloudDir = tempDir.resolve("cloud");

        TextEditor editor = new TextEditor(savePath);
        CloudSyncService cloud = new CloudSyncService(editor, cloudDir);
        editor.addObserver(cloud);

        editor.type("Sync me");
        editor.save();

        assertTrue(Files.isDirectory(cloudDir), "Cloud directory must exist");
        try (Stream<Path> files = Files.list(cloudDir)) {
            Path copy = files.findFirst().orElse(null);
            assertNotNull(copy, "Cloud copy must be created");
            String cloudText = Files.readString(copy, StandardCharsets.UTF_8);
            assertEquals("Sync me", cloudText);
        }
    }
}
