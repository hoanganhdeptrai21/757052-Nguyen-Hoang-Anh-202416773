package hust.soict.dsai.swing;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.exception.PlayerException;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Playable;

import javax.swing.*;
import java.awt.*;

public class MediaStoreSwing extends JPanel {
    private Media media;
    private Cart cart;

    public MediaStoreSwing(Media media, Cart cart) {
        this.media = media;
        this.cart = cart;
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JLabel title = new JLabel(media.getTitle());
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 20));
        title.setAlignmentX(CENTER_ALIGNMENT);

        JLabel cost = new JLabel(media.getCost() + " $");
        cost.setAlignmentX(CENTER_ALIGNMENT);

        JPanel container = new JPanel();
        container.setLayout(new FlowLayout(FlowLayout.CENTER));

        JButton btnAddToCart = new JButton("Add to cart");
        btnAddToCart.addActionListener(e -> {
            cart.addMedia(media);
            JOptionPane.showMessageDialog(
                    null,
                    "Added: " + media.getTitle(),
                    "Cart",
                    JOptionPane.INFORMATION_MESSAGE
            );
        });
        container.add(btnAddToCart);

        if (media instanceof Playable) {
            JButton btnPlay = new JButton("Play");
            btnPlay.addActionListener(e -> showPlayDialog());
            container.add(btnPlay);
        }

        this.add(Box.createVerticalGlue());
        this.add(title);
        this.add(cost);
        this.add(Box.createVerticalGlue());
        this.add(container);

        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }

    private void showPlayDialog() {
        if (!(media instanceof Playable)) return;

        JDialog dialog = new JDialog((Frame) null, "Playing: " + media.getTitle(), true);
        dialog.setSize(350, 220);
        dialog.setLocationRelativeTo(null);

        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);

        try {
            ((Playable) media).play();
            textArea.setText("Playing: " + media.getTitle()
                    + "\n\nCheck console for detailed output.");
        } catch (PlayerException e) {
            textArea.setText("Cannot play this media.\nReason: " + e.getMessage());
        }

        dialog.add(new JScrollPane(textArea));
        dialog.setVisible(true);
    }
}
