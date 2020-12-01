package pl.polsl.lab.snake.controller;

import pl.polsl.lab.snake.model.Snake;
import pl.polsl.lab.snake.view.SnakeView;

/**
 * Controls the flow of the application
 * @version 1.0
 * @author Michał Urbańczyk
 */
public class SnakeController {
    private final Snake snake;  // snake model
    private final SnakeView snakeView; // snake view
    private int predictedMoves; // if 0 -> the snake didnt crash

    /**
     * Default MVC constructor
     * @param snake MVC model
     * @param snakeView MVC view
     */
    public SnakeController(Snake snake, SnakeView snakeView) {
        this.snake = snake;
        this.snakeView = snakeView;
    }

    /**
     * sets application parameters manually
     */
    public void manuallySetParameters(){
        snake.setHowManyMovesLeft(snakeView.getParameters());
    }
    /**
     * Sets the amount of moves taken from console parameter
     * @param count amount of moves left
     */
    public void setAmountOfMoves(int count){
        snake.setHowManyMovesLeft(count);
    }

    /**
     * Sets the amount of moves predicted by user
     * @param count amount of moves predicted
     */
    public void setPredictedMoves(int count){
        predictedMoves = count;
    }

    /**
     * Gets the generated game
     * @return return generated game
     */
    public String getGeneratedGame(){
        return snake.getGeneratedGame();
    }

    /**
     * Runs the whole snake game simulation. This function creates a random string conisiting of F, L, R and E.
     * After turning, the snake must either Move or Eat
     */
    public void executeSimulation(){
        snake.executeSimulation();
        snakeView.showSnakeMoves(snake.getGeneratedGame());
    }

    /**
     * Gets the moves predicted by users
     */
    public void getUserPrediction(){
        predictedMoves = snakeView.userInputRead();
    }

    /**
     * Checks user answer
     */
    public void checkAnswer() {
        snakeView.checkIfCorrect(snake.calculateRealMoves(), predictedMoves);
    }

    public void showSnakeHello(){

    }
}
