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

    public String checkIfCorrect(int correctAnswer, int userAnswer){
        if(correctAnswer - userAnswer == 0){
            return "You were correct";
        }
        else if (correctAnswer == 0 && userAnswer != 0){
            return  "You were wrong. The snake did not crash";
        }
        else if (userAnswer == 0){
            return  ("You were wrong. The snake crashed at " + correctAnswer);
        }
        else {
            return  ("You were wrong by " + Math.abs(userAnswer - correctAnswer));
        }
    }
}
