package texteditor.observer;

public class AnalyticsLogger implements Observer<EditorEvent> {
    @Override
    public void update(EditorEvent event) {
        System.out.println("[Analytics] Event: " + event);
    }
}