module Snake {
    requires javafx.graphics;
    requires javafx.fxml;
    requires javafx.controls;
    requires java.base;

    opens pl.polsl.lab.snake.controller;
    opens pl.polsl.lab.snake.model;     //for GameTableView
    opens pl.polsl.lab.snake;

    exports pl.polsl.lab.snake to javafx.graphics;
    exports pl.polsl.lab.snake.controller to javafx.fxml;


}