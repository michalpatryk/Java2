package pl.polsl.lab.snake.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SnakeTest {
    Snake snake;

    /**
     * Set ups the snake
     */
    @BeforeEach
    void setup(){
        snake = new Snake();
    }

    /**
     * Tests if generated string is of the right size and of the right alphabet
     * @param candidate
     */
    @ParameterizedTest
    @ValueSource(ints = {10, 40, 100, 1000})
    void executeSimulation(int candidate) {
        snake.setHowManyMovesLeft(candidate);
        snake.executeSimulation();
        assertEquals(snake.getGeneratedGame().length(), candidate);
        assertEquals(snake.getGeneratedGame().matches("[^LRFE]"), false);
    }

    /**
     * Tests for proper game endings
     * @param candidate
     */
    @ParameterizedTest
    @ValueSource(strings = {"FFFFLFRF", "EEEEEELEREEE"})
    void calculateRealMoves(String candidate) {
        snake.setGeneratedGame(candidate);
        assertEquals(snake.calculateRealMoves(), 0);
    }

    /**
     * Tests for correct game ending moves
     * @param game String containing the game
     * @param length String containing the return value of snake.calculateRealMoves9)
     */
    @ParameterizedTest
    @MethodSource("gameTester")
    void calculateRealMovesDoubleArgs(String game, int length) {
        snake.setGeneratedGame(game);
        assertEquals(snake.calculateRealMoves(), length);
    }

    private static Stream<Arguments> gameTester() {
        return Stream.of(
                Arguments.of("EEEELELELE", 9),
                Arguments.of("", 0),
                Arguments.of("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF", 0),
                Arguments.of("EEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEERELERERERE", 64)
        );
    }
}