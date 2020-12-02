package pl.polsl.lab.snake.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import pl.polsl.lab.snake.model.GameTableView;
import pl.polsl.lab.snake.model.Snake;
import pl.polsl.lab.snake.view.SnakeViewFX;

/**
 * Controls the flow of the application
 * @version 1.0
 * @author Michał Urbańczyk
 */
public class SnakeControllerFX  {
    private SnakeViewFX snakeViewFX = new SnakeViewFX();
    private Snake snake = new Snake();

    private ObservableList<GameTableView> gamesTableData =
            FXCollections.observableArrayList();

    private Integer generatedGameCounter = 1;

    @FXML
    private Button startGameButton;
    @FXML
    private Button startSimulationButton;
    @FXML
    private Button userAnswerSnakeWontCrashButton;
    @FXML
    private Button userCheckAnswerButton;

    @FXML
    private TextField snakeRunsTextField;
    @FXML
    private TextField userAnswerTextBox;
    @FXML
    private Label resultLabel;

    @FXML
    private TableView<GameTableView> gamesTableView;

    @FXML
    private TableColumn<GameTableView, Integer> gameNumberTableColumn;
    @FXML
    private TableColumn<GameTableView, String> generatedGameTableColumn;


    @FXML
    /**
     * Function executed after clicking "Start game" on main menu
     * @param actionEvent
     */
    private void pressStartGameButton(ActionEvent actionEvent){
        snakeViewFX.pressStartGameButton(actionEvent);
    }


    @FXML
    /**
     * Function executed after clicking "Simulate" on game screen
     * @param actionEvent
     */
    private void pressStartSimulationButton(ActionEvent actionEvent){
        if(!snakeRunsTextField.getText().isEmpty()){

            try {
                snake.setHowManyMovesLeft(Integer.parseInt(snakeRunsTextField.getText()));
                //snake.setHowManyMovesLeft(20);
                snake.executeSimulation();
                gameNumberTableColumn.setCellValueFactory(
                        new PropertyValueFactory<GameTableView, Integer>("gameNumber"));
                generatedGameTableColumn.setCellValueFactory(
                        new PropertyValueFactory<GameTableView, String>("generatedGame"));
                gamesTableView.setItems(gamesTableData);
                gamesTableData.add(new GameTableView(generatedGameCounter, snake.getGeneratedGame()));
                generatedGameCounter++;
            }
            catch (NumberFormatException e){
                final Stage dialog = new Stage();
                dialog.initModality(Modality.APPLICATION_MODAL);
                VBox dialogVbox = new VBox(20);
                dialogVbox.getChildren().add(new Text("Enter a number into the simulation counter!"));
                Scene dialogScene = new Scene(dialogVbox, 300, 20);
                dialog.setScene(dialogScene);
                dialog.show();
            }
        }
    }


    @FXML
    /**
     * Function executed after pressing "Snake won't crash!" on game screen
     * @param actionEvent
     */
    private void pressUserAnswerSnakeWontCrashButton(ActionEvent actionEvent){
        GameTableView gameTableView = gamesTableView.getSelectionModel().getSelectedItem();
        if(gameTableView != null){
            snake.setGeneratedGame(gameTableView.getGeneratedGame());
            resultLabel.setText(snakeViewFX.checkIfCorrect(snake.calculateRealMoves(), 0));
        }
        else {
            resultLabel.setText("Please select a game");
        }
    }


    @FXML
    /**
     * Function executed after pressing "Check your answer:" on game screen
     * @param actionEvent
     */
    private void pressUserCheckAnswerButton(ActionEvent actionEvent){
        GameTableView gameTableView = gamesTableView.getSelectionModel().getSelectedItem();
        if(gameTableView != null){
            snake.setGeneratedGame(gameTableView.getGeneratedGame());
            if(userAnswerTextBox.getText().isEmpty()){
                resultLabel.setText("Enter your answer");
            }
            try {
                resultLabel.setText(snakeViewFX.checkIfCorrect(
                        snake.calculateRealMoves(), Integer.parseInt(userAnswerTextBox.getText())));
            }
            catch (NumberFormatException e){
                resultLabel.setText("Value is not a number!");
            }
        }
        else {
            resultLabel.setText("Please select a game");
        }
    }

}
