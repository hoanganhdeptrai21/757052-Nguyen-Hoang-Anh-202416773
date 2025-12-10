package hust.soict.dsai.aims;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.*;
import hust.soict.dsai.aims.store.Store;
import hust.soict.dsai.aims.screen.store.StoreScreen;

public class Aims {

    public static void main(String[] args) {

        System.out.println("=== Initializing AIMS Application ===");
        Store store = new Store();
        Cart cart = new Cart();
        System.out.println("\n=== Adding DVDs to Store ===");

        DigitalVideoDisc dvd1 = new DigitalVideoDisc(
                "The Lion King",
                "Animation",
                "Roger Allers",
                87,
                19.95f
        );

        DigitalVideoDisc dvd2 = new DigitalVideoDisc(
                "Star Wars",
                "Science Fiction",
                "George Lucas",
                124,
                24.99f
        );

        DigitalVideoDisc dvd3 = new DigitalVideoDisc(
                "Aladdin",
                "Fantasy",
                "Guy Ritchie",
                128,
                18.50f
        );

        DigitalVideoDisc dvdBroken = new DigitalVideoDisc(
                "Error Disc",
                "Undefined",
                "Unknown",
                0,          
                5.00f
        );

        store.addMedia(dvd1);
        store.addMedia(dvd2);
        store.addMedia(dvd3);
        store.addMedia(dvdBroken);
        System.out.println("\n=== Adding Books to Store ===");

        Book book1 = new Book("Harry Potter and the Goblet of Fire", "Fantasy", 29.99f);
        book1.addAuthor("J.K. Rowling");

        Book book2 = new Book("Sherlock Holmes Collection", "Detective", 19.49f);
        book2.addAuthor("Arthur Conan Doyle");

        Book book3 = new Book("Dune", "Science Fiction", 34.99f);
        book3.addAuthor("Frank Herbert");

        Book book4 = new Book("The Pragmatic Programmer", "Technology", 45.00f);
        book4.addAuthor("Andrew Hunt");
        book4.addAuthor("David Thomas");

        store.addMedia(book1);
        store.addMedia(book2);
        store.addMedia(book3);
        store.addMedia(book4);
        System.out.println("\n=== Adding CD with Tracks ===");

        CompactDisc cd1 = new CompactDisc(
                "Greatest Hits 2024",
                "Music",
                "Various",
                0,   
                15.99f,
                "Various Artists"
        );

        cd1.addTrack(new Track("Sunrise", 210));
        cd1.addTrack(new Track("Midnight Drive", 300));
        cd1.addTrack(new Track("Starlight", 280));
        cd1.addTrack(new Track("Eclipse", 260));

        store.addMedia(cd1);
        System.out.println("\n=== Adding Second CD ===");

        CompactDisc cd2 = new CompactDisc(
                "Classical Essentials",
                "Classical Music",
                "Various",
                0,
                22.75f,
                "Mozart / Beethoven / Bach"
        );

        cd2.addTrack(new Track("Symphony No.5", 430));
        cd2.addTrack(new Track("Requiem", 520));
        cd2.addTrack(new Track("Goldberg Variations", 610));

        store.addMedia(cd2);
        System.out.println("\n=== STORE INVENTORY ===");
        for (Media m : store.getItemsInStore()) {
            System.out.println(m);
        }
        System.out.println("\n=== Testing Cart Operations ===");

        cart.addMedia(book1);
        cart.addMedia(dvd1);
        cart.addMedia(cd1);

        System.out.println("Current cart total: " + cart.totalCost() + " $");

        cart.removeMedia(dvd1);
        System.out.println("After removal, cart total: " + cart.totalCost() + " $");
        System.out.println("\n=== Launching GUI Store Screen ===");

        new StoreScreen(store, cart);

        System.out.println("\n=== AIMS is running... ===");
    }
}
