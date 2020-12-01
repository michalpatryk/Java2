package pl.polsl.lab.snake;

import javafx.stage.Stage;
import pl.polsl.lab.snake.controller.SnakeControllerFX;

import java.io.File;
import java.net.URL;

/**
 * Starts up the application. Controls arguments and controller flow.
 * @version 1.0
 * @author Michał Urbańczyk
 */
public class Application extends javafx.application.Application {

    /**
     * startup function
     * @param args 1st argument is the length of the game
     */
    public static void main(String[] args) {
        launch(args);
//        Snake snake = new Snake();
//        SnakeView snakeView = new SnakeView();
//        SnakeController snakeController = new SnakeController(snake, snakeView);
//
//        // Load parameters - how many moves should the app calculate
//        if (args.length != 1) {
//            System.out.println("Invalid arguments! Input the arguments manually");  // not sure if this should be placed in view.
//            snakeController.manuallySetParameters();
//        }
//        for(String s: args){
//            try {
//                int arg = Integer.parseInt(s);
//                snakeController.setAmountOfMoves(arg);
//            }
//            catch (NumberFormatException e){
//                System.err.println("Argument" + args[0] + " must be an integer");   // same as above
//            }
//
//        }
//
//        // Output our calculated moves
//        snakeController.executeSimulation();
//        // Load user prediction
//        snakeController.getUserPrediction();
//        // Output the result
//        snakeController.checkAnswer();
//        return;

    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        //Snake snake = new Snake();
        //SnakeView snakeView = new SnakeView();
        //SnakeController snakeController = new SnakeController(snake, snakeView);
        SnakeControllerFX snakeControllerFX = new SnakeControllerFX();
//
//        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/src/main/java/pl/polsl/lab/snake/view/SnakeHelloFXML.fxml"));
//        Parent root = fxmlLoader.load();
//        Parent root = (Parent)fxmlLoader.load();
        //SnakeControllerFX controllerFX = (SnakeControllerFX)
        //snakeControllerFX.setStage(primaryStage);
        URL url1 = getClass().getResource("pl.polsl.lab.snake/SnakeHelloFXML.fxml");
        URL url2 = getClass().getResource("SnakeHelloFXML.fxml");
        URL url3 = getClass().getResource("/pl.polsl.lab.snake/SnakeHelloFXML.fxml");
        URL url4 = getClass().getResource("/SnakeHelloFXML.fxml");
        URL url = new File("src/main/java/pl/polsl/lab/snake/view/SnakeHelloFXML.fxml").toURI().toURL();
        //Parent root = FXMLLoader.load(getClass().getResource("view/SnakeHelloFXML.fxml"));
//        Parent root = FXMLLoader.load(url);
//        primaryStage.setScene(new Scene(root, 640, 480));

//        primaryStage.show();


    }
}
