package texteditor.observer;

public class SpellCheckService implements Observer<EditorEvent> {
    private final TextEditor editor;


    public SpellCheckService(TextEditor editor) {
        this.editor = editor;
    }

    @Override
    public void update(EditorEvent event) {
        if (event != EditorEvent.TEXT_EDIT) return;
        boolean hasTypos = hasTypos(editor.getText());
        if (hasTypos) {
            System.out.println("[SpellCheck] Possible typos detected.");
        }
    }

    private boolean hasTypos(String text) {
        String[] tokens = text.split("\\s+");
        for (String t : tokens) {
            if (t.matches(".*[0-9].*")) return true;
        }
        return false;
    }
}