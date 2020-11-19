package pl.polsl.lab.snake.view;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SnakeViewTest {
    private SnakeView snakeView = new SnakeView();

    @ParameterizedTest
    @ValueSource(strings = {"10", "40", "100", "-30", "0"})
    void testGetParametersNumbers(String candidate) {
        InputStream sysInBackup = System.in; // backup System.in to restore it later
        ByteArrayInputStream in = new ByteArrayInputStream(candidate.getBytes());
        System.setIn(in);
        assertEquals(snakeView.getParameters(), Integer.parseInt(candidate));
    }

    @Test
    void userInputRead() {
    }

    @Test
    void checkIfCorrect() {
    }
}