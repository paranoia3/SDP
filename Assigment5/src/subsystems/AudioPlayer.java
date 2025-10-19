package subsystems;

import domain.Song;

public class AudioPlayer {
    private Song current;
    private boolean playing;

    public void load(Song song) {
        current = song;

        System.out.println("[Audio] Loaded: " + song);
    }

    public void play() {
        if (current == null) {
            System.out.println("[Audio] Nothing to play");
            return;
        }
        playing = true;

        System.out.println("[Audio] Playing: " + current);
    }

    public void pause() {
        if (playing) {
            playing = false;
            System.out.println("[Audio] Paused");
        }
    }

    public Song current() {
        return current;
    }
}