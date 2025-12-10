package hust.soict.dsai.aims.screen.cart;

import hust.soict.dsai.aims.cart.Cart;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javax.swing.JFrame;

public class CartScreen extends JFrame {

    public CartScreen(Cart cart) {
        JFXPanel fxPanel = new JFXPanel();
        this.add(fxPanel);

        this.setTitle("Cart");
        this.setSize(800, 600);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        Platform.runLater(() -> {
            try {
                FXMLLoader loader = new FXMLLoader(
                        getClass().getResource("cart.fxml"));
                loader.setController(new CartScreenController(cart));
                Parent root = loader.load();
                fxPanel.setScene(new Scene(root));
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
