package hust.soict.dsai.aims.screen.store;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.store.Store;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javax.swing.JFrame;

public class StoreScreen extends JFrame {

    public StoreScreen(Store store, Cart cart) {
        JFXPanel fxPanel = new JFXPanel();
        this.add(fxPanel);

        this.setTitle("AIMS Store");
        this.setSize(1024, 768);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Platform.runLater(() -> {
            try {
                FXMLLoader loader = new FXMLLoader(
                        getClass().getResource("store.fxml"));
                loader.setController(new StoreScreenController(store, cart));
                Parent root = loader.load();
                fxPanel.setScene(new Scene(root));
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
