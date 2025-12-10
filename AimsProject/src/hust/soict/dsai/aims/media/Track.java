package hust.soict.dsai.aims.media;

import hust.soict.dsai.aims.exception.PlayerException;

public class Track implements Playable {

    private String title;
    private int length; 

    public Track(String title, int length) {
        this.title = title;
        this.length = length;
    }

    public String getTitle() {
        return title;
    }

    public int getLength() {
        return length;
    }

    @Override
    public void play() throws PlayerException {
        if (length <= 0) {
            throw new PlayerException("ERROR: Track length is non-positive!");
        }
        System.out.println("Playing Track: " + title);
        System.out.println("Track length: " + length);
    }

    @Override
    public String toString() {
        return "Track - " + title + " - " + length;
    }
}
