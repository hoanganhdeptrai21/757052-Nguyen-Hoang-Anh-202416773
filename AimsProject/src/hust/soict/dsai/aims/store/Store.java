package hust.soict.dsai.aims.store;

import hust.soict.dsai.aims.media.Media;

import java.util.ArrayList;
import java.util.List;

public class Store {

    public static final int MAX_ITEMS_IN_STORE = 1000;

    private List<Media> itemsInStore = new ArrayList<>();
    private Media selectedMedia;

    public void addMedia(Media media) {
        if (itemsInStore.size() >= MAX_ITEMS_IN_STORE) {
            System.out.println("Store is full.");
            return;
        }
        itemsInStore.add(media);
        System.out.println("Added to store: " + media);
    }

    public void removeMedia(Media media) {
        if (itemsInStore.remove(media)) {
            System.out.println("Removed from store: " + media);
        } else {
            System.out.println("Item not found in store.");
        }
    }

    public List<Media> getItemsInStore() {
        return itemsInStore;
    }

    public Media getSelectedMedia() {
        return selectedMedia;
    }

    public void setSelectedMedia(Media selectedMedia) {
        this.selectedMedia = selectedMedia;
    }
}
