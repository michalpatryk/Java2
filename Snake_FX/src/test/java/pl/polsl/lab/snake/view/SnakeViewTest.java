package pl.polsl.lab.snake.view;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SnakeViewTest {
    private SnakeView snakeView;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;
    /**
     * Set ups the snakeView
     */
    @BeforeEach
    public void setup(){
        snakeView = new SnakeView();
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    /**
     * Tests if we can accept correct data from user
     * @param candidate
     */
    @ParameterizedTest
    @ValueSource(strings = {"10", "40", "100", "-30", "0"})
    public void testGetParametersNumbers(String candidate) {
        InputStream sysInBackup = System.in; // backup System.in to restore it later
        ByteArrayInputStream in = new ByteArrayInputStream(candidate.getBytes());
        System.setIn(in);
        assertEquals(snakeView.getParameters(), Integer.parseInt(candidate));
    }

//    Doesn't work and I'm not advanced enough to make it work.
//    @ParameterizedTest
//    @ValueSource(strings = {"A"})
//    void stringGetParametersNumbers(String candidate){
//        InputStream sysInBackup = System.in; // backup System.in to restore it later
//        candidate = candidate + "\n 1";
//        ByteArrayInputStream in = new ByteArrayInputStream(candidate.getBytes());
//        System.setIn(in);
//        snakeView.getParameters();
//        assertEquals("Amount of moves must be an integer. Try the command again",
//                errContent.toString());
//    }
    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
        System.setErr(originalErr);
    }

}