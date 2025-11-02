package texteditor.observer;

import java.io.IOException;

public class AutosaveService implements Observer<EditorEvent> {
    private static final int THRESHOLD = 3;
    private int pendingChanges = 0;

    private final TextEditor editor;

    public AutosaveService(TextEditor editor) {
        this.editor = editor;
    }

    @Override
    public void update(EditorEvent event) throws IOException {
        switch (event) {
            case TEXT_EDIT, FORMAT_CHANGE -> {
                pendingChanges++;
                if (pendingChanges >= THRESHOLD) {
                    editor.save();
                    pendingChanges = 0;
                }
            }
            case SAVE -> pendingChanges = 0;
        }
    }
}