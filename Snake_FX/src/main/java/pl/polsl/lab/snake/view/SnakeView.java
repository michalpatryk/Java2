package pl.polsl.lab.snake.view;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Console version View
 * @version 1.0
 * @author Michał Urbańczyk
 */
public class SnakeView{



    public int getParameters(){
        while(true) {
            System.out.println("Enter snake runs: ");

            Scanner scanner = new Scanner(System.in);
            try{
                return scanner.nextInt();
            }
            catch (InputMismatchException e) {
                System.err.println("Amount of moves must be an integer. Try the command again");
            }
        }
    }

    public int userInputRead(){
        System.out.println("Will the snake crash or no? Type [Yes/No] [amount of moves to crash]");
        while(true){
            Scanner scanner = new Scanner(System.in);
            String userInput = scanner.next();

            if(userInput.equals("Yes")){
                try{
                    return scanner.nextInt();
                }
                catch (InputMismatchException e) {
                    System.err.println("Amount of moves must be an integer. Try the command again");
                }
            }
            else if(userInput.equals("No")) {
                return 0;
            }
            else {
                System.out.println("Select either Yes or No");
            }
        }
    }

    public void showSnakeMoves(String moves){
        System.out.println("Generated moves are: ");
        System.out.println(moves);
    }

    public void checkIfCorrect(int correctAnswer, int userAnswer){
        if(correctAnswer - userAnswer == 0){
            System.out.println("You were correct");
        }
        else if (correctAnswer == 0 && userAnswer != 0){
            System.out.println("You were wrong. The snake did not crash");
        }
        else if (userAnswer == 0){
            System.out.println("You were wrong. The snake crashed at " + correctAnswer);
        }
        else {
            System.out.println("You were wrong by " + Math.abs(userAnswer - correctAnswer));
        }
    }

}
