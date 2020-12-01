package pl.polsl.lab.snake.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import pl.polsl.lab.snake.Application;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Objects;

public class SnakeControllerFX extends Application {

    private Stage stage;
    public void setStage(Stage stage){
        this.stage=stage;
    }


    @FXML
    public Button startGameButton;

    @FXML
    public void pressStartGameButton(ActionEvent actionEvent){
        Parent root;
        try {
            URL url = new File("src/main/java/pl/polsl/lab/snake/view/SnakeGameFXML.fxml").toURI().toURL();
            root = FXMLLoader.load(Objects.requireNonNull(url));
            Stage stage = new Stage();
            stage.setTitle("My New Stage Title");
            stage.setScene(new Scene(root, 640, 480));
            stage.show();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
