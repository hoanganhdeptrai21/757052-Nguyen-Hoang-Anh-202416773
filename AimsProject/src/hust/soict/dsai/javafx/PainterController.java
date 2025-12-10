package hust.soict.dsai.javafx;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;

public class PainterController {

    @FXML
    private Pane drawingAreaPane;   

    @FXML
    private RadioButton radioPen;

    @FXML
    private RadioButton radioEraser;

    @FXML
    private ToggleGroup toolGroup;

    private static final double RADIUS = 4;

    @FXML
    private void drawingAreaMouseDragged(MouseEvent event) {
        double x = event.getX();
        double y = event.getY();

        Circle dot = new Circle(x, y, RADIUS);

        if (radioEraser != null && radioEraser.isSelected()) {
            dot.setFill(Color.WHITE);
        }

        ObservableList<Node> children = drawingAreaPane.getChildren();
        children.add(dot);
    }

    @FXML
    private void clearButtonPressed(ActionEvent event) {
        drawingAreaPane.getChildren().clear();
    }
}
