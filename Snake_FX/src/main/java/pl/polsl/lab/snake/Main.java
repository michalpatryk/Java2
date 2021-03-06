package pl.polsl.lab.snake;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.net.URL;

public class Main extends javafx.application.Application{
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        URL url1 = getClass().getResource("/SnakeHelloFXML.fxml");
        URL url2 = getClass().getResource("SnakeHelloFXML.fxml");
        URL url3 = getClass().getResource("/pl.polsl.lab.snake/SnakeHelloFXML.fxml");
        URL url4 = getClass().getResource("pl.polsl.lab.snake/SnakeHelloFXML.fxml");
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/pl.polsl.lab.snake/SnakeHelloFXML.fxml"));
        Parent root = fxmlLoader.load();
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }
}
