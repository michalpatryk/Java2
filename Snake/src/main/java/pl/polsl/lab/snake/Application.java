package pl.polsl.lab.snake;

import pl.polsl.lab.snake.controller.SnakeController;
import pl.polsl.lab.snake.model.Snake;
import pl.polsl.lab.snake.view.SnakeView;

/**
 * Starts up the application. Controls arguments and controller flow.
 * @version 1.0
 * @author Michał Urbańczyk
 */
public class Application {
    /**
     * startup function
     * @param args 1st argument is the length of the game
     */
    public static void main(String[] args) {

        Snake snake = new Snake();
        SnakeView snakeView = new SnakeView();
        SnakeController snakeController = new SnakeController(snake, snakeView);
        
        // Load parameters - how many moves should the app calculate
        if (args.length != 1) {
            System.out.println("Invalid arguments! Input the arguments manually");  // not sure if this should be placed in view.
            snakeController.manuallySetParameters();
        }
        for(String s: args){
            try {
                int arg = Integer.parseInt(s);
                snakeController.setAmountOfMoves(arg);
            }
            catch (NumberFormatException e){
                System.err.println("Argument" + args[0] + " must be an integer");   // same as above
            }

        }

        // Output our calculated moves
        snakeController.executeSimulation();
        // Load user prediction
        snakeController.getUserPrediction();
        // Output the result
        snakeController.checkAnswer();
        return;

    }
}
