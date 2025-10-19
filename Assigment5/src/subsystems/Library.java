package subsystems;

import domain.Song;
import java.util.HashMap;
import java.util.Map;

public class Library {
    private final Map<String, Song> byTitle = new HashMap<>();

    public Library() {
        add(new Song("1", "Levitating", "Dua Lipa"));
        add(new Song("2", "Numb", "Linkin Park"));
        add(new Song("3", "Sunflower", "Post Malone"));
    }

    public void add(Song s) {
        byTitle.put(s.getTitle().toLowerCase(), s);
    }

    public Song findByTitle(String title) {
        return byTitle.get(title.toLowerCase());
    }
}