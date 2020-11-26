package pl.polsl.lab.snake.model;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SnakeCellTest {

    /**
     * Test check if .equals() and .hashCode() works properly
     * @param x1 x parameter for first SnakeCell
     * @param y1 y parameter for first SnakeCell
     * @param x2 x parameter for second SnakeCell
     * @param y2 y parameter for second SnakeCell
     * @param isEqual parameter checking whether data should assert true or false
     */
    @ParameterizedTest
    @MethodSource("hashAndEqualsProvider")
    void testEqualsAndHash(int x1, int y1, int x2, int y2, boolean isEqual) {
        SnakeCell snakeCell1 = new SnakeCell(x1, y1);
        SnakeCell snakeCell2 = new SnakeCell(x2, y2);
        assertEquals(snakeCell1.equals(snakeCell2) && snakeCell2.equals(snakeCell1), isEqual);
        assertEquals(snakeCell1.hashCode() == snakeCell2.hashCode(), isEqual);
    }

    /**
     * Provides a stream of data for testHashAndEqauls
     * @return Stream of test arguments
     */
    private static Stream<Arguments> hashAndEqualsProvider() {
        return Stream.of(
                Arguments.of(1, 1, 1, 1, true),
                Arguments.of(1, 2, 2, 1, false),
                Arguments.of(0, 0, 0, 0, true),
                Arguments.of(-1, -1, 1, 1, false),
                Arguments.of(1, -1, -1, 1, false),
                Arguments.of(21111, 37777, 502932573, 0, false)
        );
    }
}