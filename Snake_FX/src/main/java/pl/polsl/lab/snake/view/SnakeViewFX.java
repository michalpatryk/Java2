package pl.polsl.lab.snake.view;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class SnakeViewFX {
    public void pressStartGameButton(ActionEvent actionEvent){
        Parent root;
        try {
            root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(
                    "/pl.polsl.lab.snake/SnakeGameFXML.fxml")));
            Stage stage = new Stage();
            stage.setTitle("New game!");
            stage.setScene(new Scene(root, 640, 480));
            stage.show();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
