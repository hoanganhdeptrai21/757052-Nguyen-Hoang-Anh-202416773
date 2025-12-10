package hust.soict.dsai.aims.screen.store;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.screen.cart.CartScreen;
import hust.soict.dsai.aims.store.Store;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;

public class StoreScreenController {

    private Store store;
    private Cart cart;

    @FXML private FlowPane flowPane;

    public StoreScreenController(Store store, Cart cart) {
        this.store = store;
        this.cart = cart;
    }

    @FXML
    private void initialize() {
        displayStore();
    }

    private void displayStore() {
        flowPane.getChildren().clear();
        for (Media m : store.getItemsInStore()) {
            try {
                FXMLLoader loader = new FXMLLoader(
                        getClass().getResource("MediaItem.fxml"));
                VBox mediaBox = loader.load();

                MediaItemController controller = loader.getController();
                controller.setData(m, cart);

                mediaBox.setOnMouseClicked(e -> store.setSelectedMedia(m));

                flowPane.getChildren().add(mediaBox);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @FXML
    private void viewCart() {
        new CartScreen(cart);
    }
}
