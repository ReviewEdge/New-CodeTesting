public class ComputerGuessesGame {
    private static final int UPPER_BOUND = 1000;
    private static final int LOWER_BOUND = 1;

    private int numGuesses;
    private int lastGuess;

    // upperBound and lowerBound track the computer's knowledge about the correct number
    // They are updated after each guess is made
    private int upperBound; // correct number is <= upperBound
    private int lowerBound; // correct number is >= lowerBound

    ComputerGuessesGame() {
        newGame();
    }

    private void newGame() {
        numGuesses = 0;
        upperBound = UPPER_BOUND;
        lowerBound = LOWER_BOUND;
    }

    public void handleGuessResponse(boolean isHigh) {
        if (isHigh) {
            lowerBound = Math.max(lowerBound, lastGuess + 1);
        } else {
            upperBound = Math.min(upperBound, lastGuess);
        }
    }

    public int newGuess() {
        lastGuess = (lowerBound + upperBound + 1) / 2;
        numGuesses += 1;
        return lastGuess;
    }

    public GameResult getGameResult() {
        return new GameResult(false, lastGuess, numGuesses);

    }
}
