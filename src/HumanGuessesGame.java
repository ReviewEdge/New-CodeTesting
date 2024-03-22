import java.util.Random;

/**
 * A game where a human guesses a number between 1 and UPPER_BOUND
 * Tracks the target, the number of guesses made, and if the number has been guessed
 *
 * NOTE: You can refactor and edit this file if needed
 */
public class HumanGuessesGame {
    public final static int UPPER_BOUND = 1000;

    private final int target;
    private int numGuesses;
    private boolean gameIsDone; // true iff makeGuess has been called with the target value

    //TODO: will need dependency injection stuff
    HumanGuessesGame(){
        this.target = getRandomTarget();

        numGuesses = 0;
        gameIsDone = false;
    }

    HumanGuessesGame(int target){
        this.target = target;

        numGuesses = 0;
        gameIsDone = false;
    }


    private int getRandomTarget() {
        Random randGen = new Random();
        return randGen.nextInt(UPPER_BOUND) + 1;
    }

    GuessResult makeGuess(int value){
        numGuesses += 1;

        if(value < target){
            return GuessResult.LOW;
        }
        if(value > target){
            return GuessResult.HIGH;
        }

        return GuessResult.CORRECT;
    }

    int getNumGuesses(){
        return numGuesses;
    }

    boolean isDone(){
        return gameIsDone;
    }
}
