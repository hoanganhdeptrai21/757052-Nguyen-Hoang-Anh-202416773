package hust.soict.dsai.aims.screen.store;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.exception.PlayerException;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Playable;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class MediaItemController {

    private Media media;
    private Cart cart;

    @FXML private Label lblTitle;
    @FXML private Label lblCategory;
    @FXML private Label lblCost;
    @FXML private Button btnAdd;
    @FXML private Button btnPlay;

    public void setData(Media media, Cart cart) {
        this.media = media;
        this.cart = cart;

        lblTitle.setText(media.getTitle());
        lblCategory.setText(media.getCategory());
        lblCost.setText(media.getCost() + " $");

        btnPlay.setVisible(media instanceof Playable);
    }

    @FXML
    private void addToCart() {
        if (cart != null && media != null) {
            cart.addMedia(media);
        }
    }

    @FXML
    private void playMedia() {
        if (media instanceof Playable playable) {
            try {
                playable.play();
            } catch (PlayerException e) {
                new Alert(Alert.AlertType.ERROR, e.getMessage()).showAndWait();
            }
        }
    }
}
