package pl.polsl.lab.snake.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import pl.polsl.lab.snake.model.GameTableView;
import pl.polsl.lab.snake.model.Snake;
import pl.polsl.lab.snake.view.SnakeViewFX;

public class SnakeControllerFX  {
    private SnakeViewFX snakeViewFX = new SnakeViewFX();
    private Snake snake = new Snake();

    private TableView<GameTableView> gamesTable = new TableView<>();
    private ObservableList<GameTableView> gamesTableData =
            FXCollections.observableArrayList();

    private Integer generatedGameCounter = 1;

    @FXML
    public Button startGameButton;
    @FXML
    public Button startSimulationButton;
    @FXML
    public Button userAnswerSnakeWontCrashButton;
    @FXML
    public Button userCheckAnswerButton;

    @FXML
    public TextField snakeRunsTextField;
    @FXML
    public TextField userAnswerTextBox;

    @FXML
    TableView gamesTableView;

    @FXML
    TableColumn<GameTableView, Integer> gameNumberTableColumn;
    @FXML
    TableColumn<GameTableView, String> generatedGameTableColumn;

    @FXML
    public void pressStartGameButton(ActionEvent actionEvent){
        snakeViewFX.pressStartGameButton(actionEvent);
        gamesTable.setEditable(true);
    }
    @FXML
    public void pressStartSimulationButton(ActionEvent actionEvent){
        if(!snakeRunsTextField.getText().isEmpty()){
            snake.setHowManyMovesLeft(20);
            snake.executeSimulation();
            gameNumberTableColumn.setCellValueFactory(new PropertyValueFactory<GameTableView, Integer>("gameNumber"));
            generatedGameTableColumn.setCellValueFactory(new PropertyValueFactory<GameTableView, String>("generatedGame"));
            gamesTableView.setItems(gamesTableData);
            gamesTableData.add(new GameTableView(generatedGameCounter, snake.getGeneratedGame()));
            generatedGameCounter++;
        }
    }


}
