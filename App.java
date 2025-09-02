import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class App extends Application {

    public void start(Stage stage) {

        Label title = new Label("CALCULADORA DE IMC");
        title.getStyleClass().add("my-title");
        title.setPadding(new Insets(10, 0, 10, 0));

        HBox titleBox = new HBox(title);
        titleBox.setAlignment(Pos.CENTER);

        Label pesoLabel = new Label("Peso: ");
        pesoLabel.getStyleClass().add("text-box");
        TextField pesoArea = new TextField();
        pesoArea.getStyleClass().add("text-box");
        HBox pesoBox = new HBox(pesoLabel, pesoArea);
        pesoBox.setAlignment(Pos.CENTER);

        Label alturaLabel = new Label("Altura: ");
        alturaLabel.getStyleClass().add("text-box");
        TextField alturaArea = new TextField();
        alturaArea.getStyleClass().add("text-box");
        HBox alturaBox = new HBox(alturaLabel, alturaArea);
        alturaBox.setAlignment(Pos.CENTER);

        Button button = new Button("Calcular IMC");
        button.setAlignment(Pos.CENTER);

        Label result = new Label();
        result.getStyleClass().add("resultado");
        button.setOnAction(e -> {
            double peso = Double.parseDouble(pesoArea.getText());
            double altura = Double.parseDouble(alturaArea.getText());

            double resultado = (peso) / (Math.pow(altura, 2));

            String resultadoLabel = Double.toString(resultado);

            result.setText(resultadoLabel);
            result.setStyle("-fx-font-size: 32px;");
        });

        VBox vBox = new VBox(titleBox, pesoBox, alturaBox, button, result);
        vBox.setSpacing(10);
        vBox.setAlignment(Pos.CENTER);

        Scene scene = new Scene(vBox);
        scene.getStylesheets().add("styles.css");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}