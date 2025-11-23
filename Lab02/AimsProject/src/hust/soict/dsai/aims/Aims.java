package hust.soict.dsai.aims;

import java.util.*;
import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Track;
import hust.soict.dsai.aims.store.Store;

public class Aims {

    public static void showMenu() {
        System.out.println("========== AIMS ==========");
        System.out.println("1. View store");
        System.out.println("2. Update store");
        System.out.println("3. View current cart");
        System.out.println("0. Exit program");
        System.out.println("==========================");
        System.out.print("Your choice (0-3): ");
    }

    public static void storeMenu() {
        System.out.println("------ Store options ------");
        System.out.println("1. Show media's details");
        System.out.println("2. Add a media to cart");
        System.out.println("3. Play a media");
        System.out.println("4. View current cart");
        System.out.println("0. Back to main menu");
        System.out.println("---------------------------");
        System.out.print("Your choice (0-4): ");
    }

    public static void mediaDetailsMenu(Media media) {
        System.out.println("---- Media details menu ----");
        System.out.println("1. Add this media to cart");
        if (media instanceof DigitalVideoDisc) {
            System.out.println("2. Play this DVD");
            System.out.println("0. Back");
        } else if (media instanceof CompactDisc) {
            System.out.println("2. Play this CD");
            System.out.println("0. Back");
        } else {
            System.out.println("0. Back");
        }
        System.out.println("----------------------------");
        System.out.print("Your choice: ");
    }

    public static void cartMenu() {
        System.out.println("--------- Cart menu ---------");
        System.out.println("1. Filter medias in cart");
        System.out.println("2. Sort medias in cart");
        System.out.println("3. Remove a media");
        System.out.println("4. Play a media");
        System.out.println("5. Place order");
        System.out.println("0. Back");
        System.out.println("-----------------------------");
        System.out.print("Your choice (0-5): ");
    }

    public static void sortMenu() {
        System.out.println("----- Sorting options -----");
        System.out.println("1. Sort by title");
        System.out.println("2. Sort by cost");
        System.out.println("0. Back");
        System.out.println("---------------------------");
        System.out.print("Your choice (0-2): ");
    }

    public static void filterMenu() {
        System.out.println("----- Filter options -----");
        System.out.println("1. Filter by title");
        System.out.println("2. Filter by ID");
        System.out.println("0. Back");
        System.out.println("--------------------------");
        System.out.print("Your choice (0-2): ");
    }

    public static void main(String[] args) {

        DigitalVideoDisc dvd1  = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        DigitalVideoDisc dvd2  = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 124, 24.95f);
        DigitalVideoDisc dvd3  = new DigitalVideoDisc("Aladdin", "Animation", "John Musker", 90, 18.99f);

        CompactDisc cd1 = new CompactDisc("Hybrid Theory", "Rock", "Linkin Park", 15.99f, "Chester Bennington");
        cd1.addTrack(new Track("Papercut", 185));
        cd1.addTrack(new Track("One Step Closer", 155));
        cd1.addTrack(new Track("With You", 200));

        CompactDisc cd2 = new CompactDisc("Back in Black", "Rock", "AC/DC", 14.99f, "Brian Johnson");
        cd2.addTrack(new Track("Hells Bells", 312));
        cd2.addTrack(new Track("Shoot to Thrill", 315));

        CompactDisc cd3 = new CompactDisc("The Dark Side of the Moon", "Progressive Rock", "Pink Floyd", 16.99f, "David Gilmour");
        cd3.addTrack(new Track("Speak to Me", 90));
        cd3.addTrack(new Track("Breathe", 163));

        Book book1 = new Book("The Great Gatsby", "Fiction", 10.99f);
        book1.addAuthor("F. Scott Fitzgerald");
        Book book2 = new Book("1984", "Dystopian", 8.99f);
        book2.addAuthor("George Orwell");
        Book book3 = new Book("To Kill a Mockingbird", "Fiction", 12.99f);
        book3.addAuthor("Harper Lee");

        Scanner scanner = new Scanner(System.in);

        Cart cart = new Cart();
        cart.addMedia(dvd1);
        cart.addMedia(cd1);
        cart.addMedia(book1);

        Store store = new Store();
        store.addMedia(dvd1);
        store.addMedia(dvd2);
        store.addMedia(dvd3);
        store.addMedia(cd1);
        store.addMedia(cd2);
        store.addMedia(cd3);
        store.addMedia(book1);
        store.addMedia(book2);
        store.addMedia(book3);

        while (true) {
            showMenu();
            int choice = -1;
            try {
                choice = Integer.parseInt(scanner.nextLine().trim());
            } catch (Exception e) {
                choice = -1;
            }

            if (choice == 0) {
                System.out.println("Closing AIMS. Goodbye.");
                break;
            }

            if (choice == 1) {
                boolean backToMain = false;
                while (!backToMain) {
                    store.printStore();
                    storeMenu();
                    int storeChoice = -1;
                    storeChoice = Integer.parseInt(scanner.nextLine().trim());

                    switch (storeChoice) {
                        case 0:
                            backToMain = true;
                            break;
                        case 1: {
                            System.out.print("Enter media title: ");
                            String title = scanner.nextLine().trim();
                            Media found = null;
                            found = store.findMediaByTitle(title, store);
                            if (found == null) {
                                System.out.println("No media with that title.");
                                break;
                            } else {
                                System.out.println(found.getAllInfo());
                            }
                            mediaDetailsMenu(found);
                            int mdChoice = -1;
                            mdChoice = Integer.parseInt(scanner.nextLine().trim());
                            if (mdChoice == 1) {
                                cart.addMedia(found);
                            } else if (mdChoice == 2) {
                                found.play();
                            }
                            break;
                        }
                        case 2: {
                            System.out.print("Enter media title: ");
                            String title = scanner.nextLine().trim();
                            Media found = null;
                            found = store.findMediaByTitle(title, store);
                            if (found == null) {
                                System.out.println("No media with that title.");
                                break;
                            } else {
                                cart.addMedia(found);
                                System.out.println("Items in cart: " + cart.getQtyOrdered());
                            }
                            break;
                        }
                        case 3: {
                            System.out.print("Enter media title: ");
                            String title = scanner.nextLine().trim();
                            Media found = null;
                            found = store.findMediaByTitle(title, store);
                            if (found == null) {
                                System.out.println("No media with that title.");
                            } else {
                                found.play();
                            }
                            break;
                        }
                        case 4: {
                            boolean backToStore = false;
                            while (!backToStore) {
                                cart.printCart();
                                cartMenu();
                                int cartChoice = -1;
                                cartChoice = Integer.parseInt(scanner.nextLine().trim());
                                switch (cartChoice) {
                                    case 0:
                                        backToStore = true;
                                        break;
                                    case 1: {
                                        while (true) {
                                            filterMenu();
                                            int filterChoice = -1;
                                            filterChoice = Integer.parseInt(scanner.nextLine().trim());
                                            if (filterChoice == 0) {
                                                break;
                                            } else if (filterChoice == 1) {
                                                System.out.print("Title to filter: ");
                                                String title = scanner.nextLine().trim();
                                                cart.filterByTitle(title);
                                            } else if (filterChoice == 2) {
                                                System.out.print("ID to filter: ");
                                                int id = Integer.parseInt(scanner.nextLine().trim());
                                                cart.filterById(id);
                                            } else {
                                                System.out.println("Invalid option. Choose 0-1-2.");
                                            }
                                        }
                                        break;
                                    }
                                    case 2: {
                                        while (true) {
                                            sortMenu();
                                            int sortChoice = -1;
                                            sortChoice = Integer.parseInt(scanner.nextLine().trim());
                                            if (sortChoice == 0) {
                                                break;
                                            } else if (sortChoice == 1) {
                                                cart.sortByTitle();
                                                System.out.println("Cart sorted by title.");
                                                break;
                                            } else if (sortChoice == 2) {
                                                cart.sortByCost();
                                                System.out.println("Cart sorted by cost.");
                                                break;
                                            } else {
                                                System.out.println("Invalid option. Choose 0-1-2.");
                                            }
                                        }
                                    }
                                    case 3: {
                                        System.out.print("Enter media title to remove: ");
                                        String title = scanner.nextLine().trim();
                                        Media found = null;
                                        found = store.findMediaByTitle(title, store);
                                        if (found == null) {
                                            System.out.println("No media with that title.");
                                        } else {
                                            cart.removeMedia(found);
                                            System.out.println("Items in cart: " + cart.getQtyOrdered());
                                        }
                                        break;
                                    }
                                    case 4: {
                                        System.out.print("Enter media title: ");
                                        String title = scanner.nextLine().trim();
                                        Media found = null;
                                        found = store.findMediaByTitle(title, store);
                                        if (found == null) {
                                            System.out.println("No media with that title.");
                                        } else {
                                            found.play();
                                        }
                                        break;
                                    }
                                    case 5: {
                                        System.out.println("Order placed successfully.");
                                        cart.clearCart();
                                        System.out.println("Cart is now empty.");
                                        break;
                                    }
                                    default:
                                        System.out.println("Invalid option. Choose 0-1-2-3-4-5.");
                                }
                            }
                            break;
                        }
                        default:
                            System.out.println("Invalid option. Choose 0-1-2-3-4.");
                    }
                }
            } else if (choice == 2) {
                System.out.println("Store update feature is not available yet.");
                break;
            } else if (choice == 3) {
                boolean backToMain = false;
                while (!backToMain) {
                    cartMenu();
                    int cartChoice = -1;
                    cartChoice = Integer.parseInt(scanner.nextLine().trim());
                    switch (cartChoice) {
                        case 0:
                            backToMain = true;
                            break;
                        case 1: {
                            while (true) {
                                filterMenu();
                                int filterChoice = -1;
                                filterChoice = Integer.parseInt(scanner.nextLine().trim());
                                if (filterChoice == 0) {
                                    break;
                                } else if (filterChoice == 1) {
                                    System.out.print("Title to filter: ");
                                    String title = scanner.nextLine().trim();
                                    cart.filterByTitle(title);
                                } else if (filterChoice == 2) {
                                    System.out.print("ID to filter: ");
                                    int id = Integer.parseInt(scanner.nextLine().trim());
                                    cart.filterById(id);
                                } else {
                                    System.out.println("Invalid option. Choose 0-1-2.");
                                }
                            }
                            break;
                        }
                        case 2: {
                            while (true) {
                                sortMenu();
                                int sortChoice = -1;
                                sortChoice = Integer.parseInt(scanner.nextLine().trim());
                                if (sortChoice == 0) {
                                    break;
                                } else if (sortChoice == 1) {
                                    cart.sortByTitle();
                                    System.out.println("Cart sorted by title.");
                                    break;
                                } else if (sortChoice == 2) {
                                    cart.sortByCost();
                                    System.out.println("Cart sorted by cost.");
                                    break;
                                } else {
                                    System.out.println("Invalid option. Choose 0-1-2.");
                                }
                            }
                        }
                        case 3: {
                            System.out.print("Enter media title to remove: ");
                            String title = scanner.nextLine().trim();
                            Media found = null;
                            found = store.findMediaByTitle(title, store);
                            if (found == null) {
                                System.out.println("No media with that title.");
                            } else {
                                cart.removeMedia(found);
                                System.out.println("Items in cart: " + cart.getQtyOrdered());
                            }
                            break;
                        }
                        case 4: {
                            System.out.print("Enter media title: ");
                            String title = scanner.nextLine().trim();
                            Media found = null;
                            found = store.findMediaByTitle(title, store);
                            if (found == null) {
                                System.out.println("No media with that title.");
                            } else {
                                found.play();
                            }
                            break;
                        }
                        case 5: {
                            System.out.println("Order placed successfully.");
                            cart.clearCart();
                            System.out.println("Cart is now empty.");
                            break;
                        }
                        default:
                            System.out.println("Invalid option. Choose 0-1-2-3-4-5.");
                    }
                }
            } else {
                System.out.println("Invalid option. Choose 0-1-2-3.");
            }
        }
        scanner.close();
    }
}
