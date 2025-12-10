package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.cart.Cart;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javax.swing.*;
import java.io.IOException;

public class CartScreen extends JFrame {

    private Cart cart;

    public CartScreen(Cart cart) {
        this.cart = cart;

        JFXPanel fxPanel = new JFXPanel();
        add(fxPanel);

        setTitle("Cart");
        setSize(1024, 768);
        setLocationRelativeTo(null);
        setVisible(true);

        Platform.runLater(() -> {
            try {
                FXMLLoader loader = new FXMLLoader(
                        getClass().getResource("cart.fxml"));
                loader.setController(new CartScreenController(cart));
                Parent root = loader.load();
                fxPanel.setScene(new Scene(root));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
}
