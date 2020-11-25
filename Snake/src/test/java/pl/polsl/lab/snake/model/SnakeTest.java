package pl.polsl.lab.snake.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SnakeTest {
    Snake snake;

    @BeforeEach
    void setup(){
        snake = new Snake();

    }
    //length test
    @ParameterizedTest
    @ValueSource(ints = {10, 40, 100, 1000})
    void executeSimulation(int candidate) {
        snake.setHowManyMovesLeft(candidate);
        snake.executeSimulation();
        assertEquals(snake.getGeneratedGame().length(), candidate);
        assertEquals(snake.getGeneratedGame().matches("[^LRFE]"), false);
    }

    @ParameterizedTest
    @ValueSource(strings = {"FFFFLFRF"})
    void calculateRealMoves(String candidate) {
        snake.setGeneratedGame(candidate);
        assertEquals(snake.calculateRealMoves(), 0);
    }
}