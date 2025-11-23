package hust.soict.dsai.test.media;

import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Track;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.CompactDisc;
import java.util.ArrayList;
import java.util.List;

public class TestPolymorphism {
    public static void main(String[] args) {
        List<Media> mediaList = new ArrayList<Media>();

        CompactDisc cd = new CompactDisc("Greatest Hits", "Music", "Various Artists", 15.99f, "Taylor Swift");
        CompactDisc cd2 = new CompactDisc("Rock Legends", "Rock", "Various Artists", 12.49f, "Brian Johnson");

        DigitalVideoDisc dvd = new DigitalVideoDisc("Inception", "Science Fiction", "Christopher Nolan", 148, 19.99f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Interstellar", "Science Fiction", "Christopher Nolan", 169, 21.99f);

        Book book = new Book("The Great Gatsby", "Fiction", 10.99f);
        Book book2 = new Book("The Catcher in the Rye", "Fiction", 9.49f);

        book.addAuthor("F. Scott Fitzgerald");
        book.addAuthor("Ernest Hemingway");
        book2.addAuthor("J.D. Salinger");

        Track track1 = new Track("Track 1", 4);
        Track track2 = new Track("Track 2", 5);
        Track t3 = new Track("Thunderstruck", 292);
        Track t4 = new Track("Back in Black", 255);

        cd.addTrack(track1);
        cd.addTrack(track2);

        cd2.addTrack(t3);
        cd2.addTrack(t4);

        mediaList.add(cd);
        mediaList.add(cd2);
        mediaList.add(dvd);
        mediaList.add(dvd2);
        mediaList.add(book);
        mediaList.add(book2);

        for (Media m : mediaList) {
            System.out.println(m.toString());
        }
    }
}
