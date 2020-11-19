package pl.polsl.lab.snake.controller;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.polsl.lab.snake.model.Snake;
import pl.polsl.lab.snake.view.SnakeView;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

class SnakeControllerTest {
    //This whole test is to be scrapped. Class executeSimulation and checkAnswer should be moved to model.
    SnakeController snakeController;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    @BeforeEach
    void setUp(){
        snakeController = new SnakeController(new Snake(), new SnakeView());
        snakeController.setAmountOfMoves(20);
        snakeController.setPredictedMoves(20);
        System.setOut(new PrintStream(outContent));
    }

    //
    @Test
    void executeSimulation() {
    }

    @Test
    void checkAnswer() {
        snakeController.getGeneratedGame();
        snakeController.checkAnswer();

    }

    @AfterAll
    void afterTest(){
        System.setOut(originalOut);
    }
}