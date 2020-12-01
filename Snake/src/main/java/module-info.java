module Snake {
    requires javafx.graphics;
    requires javafx.fxml;
    requires javafx.controls;

    exports pl.polsl.lab.snake to javafx.graphics;
    exports pl.polsl.lab.snake.controller to javafx.fxml;
    opens pl.polsl.lab.snake.controller;
    opens pl.polsl.lab.snake;

}