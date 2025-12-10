package hust.soict.dsai.aims.media;

import hust.soict.dsai.aims.exception.PlayerException;

public class DigitalVideoDisc extends Disc implements Playable {

    public DigitalVideoDisc(String title, String category,
                            String director, int length, float cost) {
        super(title, category, director, length, cost);
    }

    @Override
    public void play() throws PlayerException {
        if (length <= 0) {
            throw new PlayerException("ERROR: DVD length is non-positive!");
        }
        System.out.println("Playing DVD: " + title);
        System.out.println("DVD length: " + length);
    }

    @Override
    public String toString() {
        return String.format("DVD - %s - %s - %s - %d min - %.2f$",
                title, category, director, length, cost);
    }
}
