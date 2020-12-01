package pl.polsl.lab.snake.model;

/**
 * Helper class. Allows for easy interpretation and change of direction on a 2d board.
 * @version 1.0
 * @author Michał Urbańczyk
 */
public class DirectionManager {
    enum Directions {UP, DOWN, LEFT, RIGHT}
    private Directions direction = Directions.UP;

    public void turnLeft(){
        switch (direction){
            case UP: direction = Directions.LEFT; break;
            case LEFT: direction = Directions.DOWN; break;
            case DOWN: direction = Directions.RIGHT; break;
            case RIGHT: direction = Directions.UP; break;
        }
    }

    public void turnRight(){
        switch (direction){
            case UP: direction = Directions.RIGHT; break;
            case RIGHT: direction = Directions.DOWN; break;
            case DOWN: direction = Directions.LEFT; break;
            case LEFT: direction = Directions.UP; break;
        }
    }

    /**
     * gets X axis multiplier
     * @return -1 if going left, +1 if going right
     */
    public int getHorizontalMath(){
        switch (direction){
            case UP: return 0;
            case DOWN: return 0;
            case LEFT: return -1;
            case RIGHT: return 1;
            default: throw new IllegalStateException("Unknown snake direction!");
        }
    }

    /**
     * gets Y axis multiplier
     * @return -1 if going down, +1 if going up
     */
    public int getVerticalMath(){
        switch (direction){
            case UP: return 1;
            case DOWN: return -1;
            case LEFT: return 0;
            case RIGHT: return 0;
            default: throw new IllegalStateException("Unknown snake direction!");
        }
    }
}
