package pl.polsl.lab.snake.model;

import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

public class DirectionManagerTest {
    private DirectionManager directionManager;

    /**
     * Set ups the directionManager
     */
    @BeforeEach
    public void setUp(){
        directionManager = new DirectionManager();
    }

    /**
     * Left turning test and getHorizontalMath()/getVericalMath() test
     */
    @org.junit.jupiter.api.Test
    public void turnLeft() {
        assertEquals(directionManager.getHorizontalMath(), 0, "We are facing up");
        assertEquals(directionManager.getVerticalMath(), 1, "We are facing up");
        directionManager.turnLeft();
        assertEquals(directionManager.getHorizontalMath(), -1, "We are facing left");
        assertEquals(directionManager.getVerticalMath(), 0, "We are facing left");
        directionManager.turnLeft();
        assertEquals(directionManager.getHorizontalMath(), 0, "We are facing down");
        assertEquals(directionManager.getVerticalMath(), -1, "We are facing down");
        directionManager.turnLeft();
        assertEquals(directionManager.getHorizontalMath(), 1, "We are facing right");
        assertEquals(directionManager.getVerticalMath(), 0, "We are facing right");
    }

    /**
     * Right turning test and getHorizontalMath()/getVericalMath() test
     */
    @org.junit.jupiter.api.Test
    public void turnRight() {
        assertEquals(directionManager.getHorizontalMath(), 0, "We are facing up");
        assertEquals(directionManager.getVerticalMath(), 1, "We are facing up");
        directionManager.turnRight();
        assertEquals(directionManager.getHorizontalMath(), 1, "We are facing right");
        assertEquals(directionManager.getVerticalMath(), 0, "We are facing right");
        directionManager.turnRight();
        assertEquals(directionManager.getHorizontalMath(), 0, "We are facing down");
        assertEquals(directionManager.getVerticalMath(), -1, "We are facing down");
        directionManager.turnRight();
        assertEquals(directionManager.getHorizontalMath(), -1, "We are facing left");
        assertEquals(directionManager.getVerticalMath(), 0, "We are facing left");
    }
}