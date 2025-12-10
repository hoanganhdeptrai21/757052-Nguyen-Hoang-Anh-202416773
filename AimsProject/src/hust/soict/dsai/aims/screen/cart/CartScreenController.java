package hust.soict.dsai.aims.screen.cart;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.exception.PlayerException;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Playable;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class CartScreenController {

    private Cart cart;

    @FXML private TableView<Media> tblMedia;
    @FXML private TableColumn<Media, String> colMediaTitle;
    @FXML private TableColumn<Media, String> colMediaCategory;
    @FXML private TableColumn<Media, Float> colMediaCost;

    @FXML private Button btnPlay;
    @FXML private Button btnRemove;
    @FXML private Label lblTotalCost;

    public CartScreenController(Cart cart) {
        this.cart = cart;
    }

    @FXML
    private void initialize() {
        colMediaTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
        colMediaCategory.setCellValueFactory(new PropertyValueFactory<>("category"));
        colMediaCost.setCellValueFactory(new PropertyValueFactory<>("cost"));

        tblMedia.setItems(cart.getItemsOrdered());
        updateTotalCost();

        btnPlay.setVisible(false);
        btnRemove.setVisible(false);

        tblMedia.getSelectionModel().selectedItemProperty()
                .addListener((obs, oldVal, newVal) -> {
                    btnRemove.setVisible(newVal != null);
                    btnPlay.setVisible(newVal instanceof Playable);
                });
    }

    @FXML
    private void btnRemovePressed() {
        Media media = tblMedia.getSelectionModel().getSelectedItem();
        if (media != null) {
            cart.removeMedia(media);
            updateTotalCost();
        }
    }

    @FXML
    private void btnPlayPressed() {
        Media media = tblMedia.getSelectionModel().getSelectedItem();
        if (media instanceof Playable playable) {
            try {
                playable.play();
            } catch (PlayerException e) {
                new Alert(Alert.AlertType.ERROR, e.getMessage()).showAndWait();
            }
        }
    }

    @FXML
    private void btnPlaceOrderPressed() {
        if (cart.getItemsOrdered().isEmpty()) {
            new Alert(Alert.AlertType.INFORMATION, "Your cart is empty.").showAndWait();
            return;
        }
        float total = cart.totalCost();
        new Alert(Alert.AlertType.INFORMATION,
                String.format("Order placed.\nTotal: %.2f $", total))
                .showAndWait();
        cart.clearCart();
        updateTotalCost();
    }

    private void updateTotalCost() {
        lblTotalCost.setText(String.format("%.2f $", cart.totalCost()));
    }
}
