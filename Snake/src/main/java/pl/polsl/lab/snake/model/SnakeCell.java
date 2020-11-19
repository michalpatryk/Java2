package pl.polsl.lab.snake.model;

/**
 * A single cell containing coord2i inside of a board. Overridden use of hashCode and equals
 * @version 1.0
 * @author Michał Urbańczyk
 */
public class SnakeCell {
    private final int x;
    private final int y;
    public SnakeCell(int x_, int y_){
        x = x_;
        y = y_;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    /**
     * Used in hash function. Allows for easy duplicate finding.
     * @return returns binary XOR of x and y
     */
    @Override
    public int hashCode() {
        return x ^ y;
    }

    /**
     * Overridden equals function. Helps in hashing.
     * @param obj object to be evaluated against
     * @return true if equal, else false
     */
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof SnakeCell))
            return false;
        SnakeCell sc = (SnakeCell) obj;
        return sc.x == x && sc.y == y;
    }
}
