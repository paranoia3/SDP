package app;

import api.MusicFacade;

public class App {
    public static void main(String[] args) {
        MusicFacade music = new MusicFacade("user-1");
        music.start();
        music.playByTitle("Levitating");
        music.pause();
        music.playByTitle("Numb");
        music.end();
    }
}