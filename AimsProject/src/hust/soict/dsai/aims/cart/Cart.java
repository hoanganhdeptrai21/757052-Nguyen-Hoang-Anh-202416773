package hust.soict.dsai.aims.cart;

import hust.soict.dsai.aims.media.Media;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Cart {

    public static final int MAX_NUMBERS_ORDERED = 20;

    private ObservableList<Media> itemsOrdered = FXCollections.observableArrayList();

    public ObservableList<Media> getItemsOrdered() {
        return itemsOrdered;
    }

    public void addMedia(Media media) {
        if (itemsOrdered.size() >= MAX_NUMBERS_ORDERED) {
            System.out.println("The cart is full.");
            return;
        }
        if (!itemsOrdered.contains(media)) {
            itemsOrdered.add(media);
            System.out.println("Added to cart: " + media);
        } else {
            System.out.println("Item already in cart.");
        }
    }

    public void removeMedia(Media media) {
        if (itemsOrdered.remove(media)) {
            System.out.println("Removed from cart: " + media);
        } else {
            System.out.println("Item not found in cart.");
        }
    }

    public void clearCart() {
        itemsOrdered.clear();
    }

    public float totalCost() {
        float sum = 0;
        for (Media m : itemsOrdered) {
            sum += m.getCost();
        }
        return sum;
    }
}
