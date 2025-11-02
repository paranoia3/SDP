package texteditor.observer;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TextEditor implements Observable<EditorEvent> {
    private final List<Observer<EditorEvent>> observers = new ArrayList<>();
    private final StringBuilder buffer = new StringBuilder();

    private Path savePath;

    public TextEditor() {
        this.savePath = Paths.get("editor-output.txt");
    }

    public TextEditor(Path savePath) {
        this.savePath = (savePath != null) ? savePath : Paths.get("editor-output.txt");
    }

    public void setSavePath(Path savePath) {
        if (savePath != null) this.savePath = savePath;
    }

    public String getText() {
        return buffer.toString();
    }

    public void type(String text) throws IOException {
        if (text == null || text.isEmpty()) return;
        buffer.append(text);
        notifyObservers(EditorEvent.TEXT_EDIT);
    }

    public void bold(int from, int to) throws IOException {
        if (from < 0 || to > buffer.length() || from >= to) return;
        buffer.insert(to, "**");
        buffer.insert(from, "**");
        notifyObservers(EditorEvent.FORMAT_CHANGE);
    }

    public void save() throws IOException {
        try {
            Files.writeString(savePath, buffer.toString(), StandardCharsets.UTF_8,
                    StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
        } catch (IOException e) {
            throw new RuntimeException("Failed to save editor content to " + savePath, e);
        }
        notifyObservers(EditorEvent.SAVE);
    }

    @Override
    public void addObserver(Observer<EditorEvent> observer) {
        if (observer == null) return;
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer<EditorEvent> observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(EditorEvent event) throws IOException {
        List<Observer<EditorEvent>> snapshot = new ArrayList<>(observers);
        for (Observer<EditorEvent> o : snapshot) {
            o.update(event);
        }
    }

    public List<Observer<EditorEvent>> getObservers() {
        return Collections.unmodifiableList(observers);
    }

    public Path getSavePath() {
        return savePath;
    }
}
