package pl.polsl.lab.snake.controller;

import pl.polsl.lab.snake.model.DirectionManager;
import pl.polsl.lab.snake.model.Snake;
import pl.polsl.lab.snake.model.SnakeCell;
import pl.polsl.lab.snake.view.SnakeView;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Random;

/**
 * Controls the flow of the application
 * @version 1.0
 * @author Michał Urbańczyk
 */
public class SnakeController {
    private final Snake snake;  // snake model
    private final SnakeView snakeView; // snake view
    private int predictedMoves; // if 0 -> the snake didnt crash
    private int realMoves; // how many moves did the snake do before crashing into itself. if 0 - it didnt crash
    private DirectionManager directionManager = new DirectionManager(); // manages in which direction does the snake go


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
     * Sets the generated game
     * @param generatedGame
     */
    public void setGeneratedGame(String generatedGame){
        snake.setGeneratedGame(generatedGame);
    }
    /**
     * Runs the whole snake game simulation. This function creates a random string conisiting of F, L, R and E.
     * After turning, the snake must either Move or Eat
     */
    public void executeSimulation(){
        StringBuilder movesString = new StringBuilder();
        Random generator = new Random();
        while(snake.getHowManyMovesLeft() > 0){
            int rand = generator.nextInt(100);
            String lastCharacter = "F";
            if(!movesString.toString().isEmpty())
                lastCharacter = movesString.substring(movesString.toString().length() - 1);
            if(rand < 30)
                movesString.append("E");
            else if(rand < 50 && !lastCharacter.equals("L") && !lastCharacter.equals("R"))  //We do not want double
                movesString.append("L");                    //turning. It can lead to our snake doing 360 degrees turn
            else if(rand < 70 && !lastCharacter.equals("L") && !lastCharacter.equals("R"))
                movesString.append("R");
            else
                movesString.append("F");
            snake.decrementMoves();
        }
        snake.setGeneratedGame(movesString.toString());
        snakeView.showSnakeMoves(movesString.toString());
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
        //get real moves calculation here
        realMoves = calculateRealMoves();

        snakeView.checkIfCorrect(realMoves, predictedMoves);
    }

    /**
     * Checks for collisions
     * @return amount of moves before crashing
     */
    private int calculateRealMoves(){
        String gameToSimulate = snake.getGeneratedGame();
        LinkedList<SnakeCell> snakeEntity = new LinkedList<SnakeCell>();
        snakeEntity.add(new SnakeCell(0,0));
        int i = 0;
        for(char currentAction : snake.getGeneratedGame().toCharArray()){
            if (currentAction == 'L'){
                directionManager.turnLeft();
            }
            else if (currentAction == 'R'){
                directionManager.turnRight();
            }
            else if(currentAction == 'F'){// we take the first element and add direction
                snakeEntity.addFirst(new SnakeCell(snakeEntity.getFirst().getX() + directionManager.getHorizontalMath(),
                        snakeEntity.getFirst().getY() + directionManager.getVerticalMath()));
                snakeEntity.removeLast();
            }
            else if(currentAction == 'E'){
                snakeEntity.addFirst(new SnakeCell(snakeEntity.getFirst().getX() + directionManager.getHorizontalMath(),
                        snakeEntity.getFirst().getY() + directionManager.getVerticalMath()));
            }
            //check if we became Ouroboros (ate ourselves)
            HashSet unique = new HashSet();
            for(SnakeCell s : snakeEntity){
                if(!unique.add(s)){
                    return i;
                }
            }
            i++;
        }
        // if we return 0 - there was no crash
        return 0;
    }
}
