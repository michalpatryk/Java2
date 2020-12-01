package pl.polsl.lab.snake.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import pl.polsl.lab.snake.Main;
import pl.polsl.lab.snake.model.Snake;
import pl.polsl.lab.snake.view.SnakeViewFX;

public class SnakeControllerFX extends Main {
    private SnakeViewFX snakeViewFX = new SnakeViewFX();
    private Snake snake = new Snake();



    @FXML
    public Button startGameButton;
    public Button startSimulationButton;
    public Button userAnswerSnakeWontCrashButton;
    public Button userCheckAnswerButton;

    @FXML
    public TextField snakeRunsTextField;
    public TextField userAnswerTextBox;

    @FXML
    TableView gamesTableView;

    @FXML
    public void pressStartGameButton(ActionEvent actionEvent){
        snakeViewFX.pressStartGameButton(actionEvent);
    }
    @FXML
    public void pressStartSimulationButton(ActionEvent actionEvent){
        if(!snakeRunsTextField.getText().isEmpty()){
            int res = Integer.parseInt(snakeRunsTextField.getText());
            System.out.println(res);
            snake.setHowManyMovesLeft(20);
            snake.executeSimulation();
            String game = snake.getGeneratedGame();

        }
    }


}
