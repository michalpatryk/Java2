package pl.polsl.lab.snake.model;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Random;

/**
 * Data containing class. Stores generated game and user input about generated moves
 * @version 1.0
 * @author Michał Urbańczyk
 */
public class Snake {
    private DirectionManager directionManager = new DirectionManager(); // manages in which direction does the snake go
    private int howManyMovesLeft;   // moves inputed by user
    private String generatedGame;   // string containing snake game generated by program

    public void setHowManyMovesLeft(int howManyMovesLeft) {
        this.howManyMovesLeft = howManyMovesLeft;
    }

    public int getHowManyMovesLeft() {
        return howManyMovesLeft;
    }

    public String getGeneratedGame(){
        return generatedGame;
    }

    /**
     * Runs the whole snake game simulation. This function creates a random string conisiting of F, L, R and E.
     * After turning, the snake must either Move or Eat
     */
    public void executeSimulation() {
        StringBuilder movesString = new StringBuilder();
        Random generator = new Random();
        while(getHowManyMovesLeft() > 0){
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
            howManyMovesLeft--;
        }
        generatedGame = movesString.toString();
    }

    /**
     * Checks for collisions
     * @return amount of moves before crashing or 0 if no crash
     */
    public int calculateRealMoves(){
        String gameToSimulate = generatedGame;
        LinkedList<SnakeCell> snakeEntity = new LinkedList<SnakeCell>();
        snakeEntity.add(new SnakeCell(0,0));
        int i = 0;
        for(char currentAction : generatedGame.toCharArray()){
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
