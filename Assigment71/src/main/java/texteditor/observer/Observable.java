package texteditor.observer;


import java.io.IOException;

public interface Observable<T> {
    void addObserver(Observer<T> observer);
    void removeObserver(Observer<T> observer);
    void notifyObservers(T event) throws IOException;
}