import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class TextColorSelector extends Application {

    private Text text;

    @Override
    public void start(Stage primaryStage) {
        // Create the text
        text = new Text("Colorful Text");
        text.setFont(new Font(40));

        // Create sliders
        Slider redSlider = createSlider();
        Slider greenSlider = createSlider();
        Slider blueSlider = createSlider();
        Slider opacitySlider = createSlider();

        // Bind sliders to the color properties of the text
        redSlider.valueProperty().addListener((observable, oldValue, newValue) -> updateColor());
        greenSlider.valueProperty().addListener((observable, oldValue, newValue) -> updateColor());
        blueSlider.valueProperty().addListener((observable, oldValue, newValue) -> updateColor());
        opacitySlider.valueProperty().addListener((observable, oldValue, newValue) -> updateColor());

        // Create labels
        Label redLabel = new Label("Red");
        Label greenLabel = new Label("Green");
        Label blueLabel = new Label("Blue");
        Label opacityLabel = new Label("Opacity");

        // Create a grid pane to hold the sliders and labels
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(5);
        gridPane.setVgap(5);

        // Add sliders and labels to the grid pane
        gridPane.add(redLabel, 0, 0);
        gridPane.add(redSlider, 1, 0);
        gridPane.add(greenLabel, 0, 1);
        gridPane.add(greenSlider, 1, 1);
        gridPane.add(blueLabel, 0, 2);
        gridPane.add(blueSlider, 1, 2);
        gridPane.add(opacityLabel, 0, 3);
        gridPane.add(opacitySlider, 1, 3);

        // Create a vertical box to hold the text and the grid pane
        GridPane root = new GridPane();
        root.setAlignment(Pos.CENTER);
        root.setVgap(20);
        root.add(text, 0, 0);
        root.add(gridPane, 0, 1);

        // Create a scene and place it in the stage
        Scene scene = new Scene(root, 500, 400);
        primaryStage.setTitle("Text Color Selector");
        primaryStage.setScene(scene);
        primaryStage.show();

        // Initialize the text color
        updateColor();
    }

    private Slider createSlider() {
        Slider slider = new Slider(0, 1, 0.5);
        slider.setShowTickLabels(true);
        slider.setShowTickMarks(true);
        slider.setMajorTickUnit(0.1);
        slider.setMinorTickCount(5);
        slider.setBlockIncrement(0.1);
        return slider;
    }

    private void updateColor() {
        // Get the slider values
        double red = ((Slider) ((GridPane) ((GridPane) text.getParent()).getChildren().get(1)).getChildren().get(1)).getValue();
        double green = ((Slider) ((GridPane) ((GridPane) text.getParent()).getChildren().get(1)).getChildren().get(3)).getValue();
        double blue = ((Slider) ((GridPane) ((GridPane) text.getParent()).getChildren().get(1)).getChildren().get(5)).getValue();
        double opacity = ((Slider) ((GridPane) ((GridPane) text.getParent()).getChildren().get(1)).getChildren().get(7)).getValue();

        // Set the text color
        text.setFill(new Color(red, green, blue, opacity));
    }

    public static void main(String[] args) {
        launch(args);
    }
}
