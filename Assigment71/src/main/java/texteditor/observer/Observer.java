package texteditor.observer;

import java.io.IOException;

public interface Observer<T> {
    void update(T event) throws IOException;
}