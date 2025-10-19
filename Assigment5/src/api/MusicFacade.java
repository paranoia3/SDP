package api;

import domain.Song;
import subsystems.AudioPlayer;
import subsystems.Library;
import subsystems.NetworkClient;

public class MusicFacade {
    private final String userId;
    private final Library library = new Library();
    private final NetworkClient net = new NetworkClient();
    private final AudioPlayer audio = new AudioPlayer();

    public MusicFacade(String userId) {
        this.userId = userId;
    }

    public void start() {
        if (!net.isConnected()) net.connect();

        System.out.println("[Session] User: " + userId);
    }

    public void end() {
        audio.pause();
        net.disconnect();

        System.out.println("[Session] End");
    }

    public void playByTitle(String title) {
        Song s = library.findByTitle(title);

        if (s == null) {
            System.out.println("[Facade] Not found: " + title);
            return;
        }

        ensureAuthorizedAndLoad(s);
        audio.play();
    }

    public void pause() {
        audio.pause();
    }

    private void ensureAuthorizedAndLoad(Song s) {
        if (!net.isConnected()) net.connect();

        System.out.println("[DRM] Authorized for " + s.getId());
        audio.load(s);
    }
}