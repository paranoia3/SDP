import org.junit.jupiter.api.Test;
import texteditor.observer.TextEditor;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;

import static org.junit.jupiter.api.Assertions.*;

class TextEditorTest {

    @Test
    void saveWritesFileWithContent() throws Exception {
        Path tempDir = Files.createTempDirectory("editor-test-");
        Path savePath = tempDir.resolve("output.txt");

        TextEditor editor = new TextEditor(savePath);
        editor.type("Hello");
        editor.type(" World");
        editor.save();

        assertTrue(Files.exists(savePath), "Save file must exist");
        String content = Files.readString(savePath, StandardCharsets.UTF_8);
        assertEquals("Hello World", content);
    }
}
