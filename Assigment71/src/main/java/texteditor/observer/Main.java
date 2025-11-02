package texteditor.observer;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) throws IOException {
        Path savePath = Paths.get("editor-output.txt");
        TextEditor editor = new TextEditor(savePath);

        AutosaveService autosave = new AutosaveService(editor);
        SpellCheckService spellcheck = new SpellCheckService(editor);
        AnalyticsLogger analytics = new AnalyticsLogger();

        CloudSyncService cloud = new CloudSyncService(editor, Paths.get("cloud"));

        editor.addObserver(autosave);
        editor.addObserver(spellcheck);
        editor.addObserver(analytics);
        editor.addObserver(cloud);

        editor.type("Hello, wor1d! ");
        editor.type("Bold this");
        editor.bold(11, 20);
        editor.type(" and save soon...");

        editor.removeObserver(analytics);
        editor.type(" More text without analytics logging.");
        editor.save();
    }
}
