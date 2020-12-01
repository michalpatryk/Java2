package pl.polsl.lab.snake.view;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

/**
 * @version 1.0
 * @author Michał Urbańczyk
 */
public class SnakeViewFX {


    /**
     * Creates new stage (window) with game
     * @param actionEvent
     */
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

    /**
     * Generates return String checking correct and user Answers
     * @param correctAnswer
     * @param userAnswer
     * @return
     */
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
