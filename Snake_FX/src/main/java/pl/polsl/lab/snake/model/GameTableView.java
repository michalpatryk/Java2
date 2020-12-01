package pl.polsl.lab.snake.model;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class GameTableView {
    private final SimpleIntegerProperty gameNumber;
    private final SimpleStringProperty generatedGame;

    private GameTableView(Integer gameNumber, String generatedGame){
        this.gameNumber = new SimpleIntegerProperty(gameNumber);
        this.generatedGame = new SimpleStringProperty(generatedGame);
    }
    public Integer getGameNumber(){
        return gameNumber.get();
    }
    public String getGeneratedGame(){
        return generatedGame.get();
    }
    public void setGameNumber(Integer gameNumber){
        this.gameNumber.set(gameNumber);
    }
    public void setGeneratedGame(String generatedGame){
        this.generatedGame.set(generatedGame);
    }

}
