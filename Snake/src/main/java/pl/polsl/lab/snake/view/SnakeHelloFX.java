package pl.polsl.lab.snake.view;

import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

public class SnakeHelloFX {
    private final BorderPane rootPane ;
    SnakeHelloFX(){
        rootPane = new BorderPane();
    }
    public Pane getRootPane(){
        return rootPane;
    }
    Button gameStartButton = new Button("Start game");


}
