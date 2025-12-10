package hust.soict.dsai.aims.media;

import hust.soict.dsai.aims.exception.PlayerException;

import java.util.ArrayList;
import java.util.List;

public class CompactDisc extends Disc implements Playable {

    private String artist;
    private List<Track> tracks = new ArrayList<>();

    public CompactDisc(String title, String category,
                       String director, int length, float cost,
                       String artist) {
        super(title, category, director, length, cost);
        this.artist = artist;
    }

    public String getArtist() {
        return artist;
    }

    public void addTrack(Track track) {
        if (!tracks.contains(track)) {
            tracks.add(track);
        }
    }

    public void removeTrack(Track track) {
        tracks.remove(track);
    }

    @Override
    public int getLength() {
        int total = 0;
        for (Track t : tracks) {
            total += t.getLength();
        }
        return total;
    }

    @Override
    public void play() throws PlayerException {
        if (tracks.isEmpty() || getLength() <= 0) {
            throw new PlayerException("ERROR: CD length is non-positive!");
        }
        System.out.println("Playing CD: " + title);
        System.out.println("CD artist: " + artist);
        for (Track t : tracks) {
            t.play();
        }
    }

    @Override
    public String toString() {
        return String.format("CD - %s - %s - %s - %s - %d - %.2f$",
                title, category, director, artist, getLength(), cost);
    }
}
