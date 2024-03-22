import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HumanGuessesGameTest {

    @Test
    void constructor1() {
        HumanGuessesGame game = new HumanGuessesGame();
        assertInstanceOf(HumanGuessesGame.class, game);
    }
    @Test
    void constructor2() {
        HumanGuessesGame game = new HumanGuessesGame(500);
        assertInstanceOf(HumanGuessesGame.class, game);
    }
    @Test
    void makeGuessLow() {
        HumanGuessesGame game = new HumanGuessesGame(500);
        assertEquals(GuessResult.LOW, game.makeGuess(1));
    }

    @Test
    void makeGuessHigh() {
        HumanGuessesGame game = new HumanGuessesGame(500);
        assertEquals(GuessResult.HIGH, game.makeGuess(900));
    }
    @Test
    void makeGuessCorrect() {
        HumanGuessesGame game = new HumanGuessesGame(500);
        assertEquals(GuessResult.CORRECT, game.makeGuess(500));
    }

    @Test
    void getNumGuessesMany() {
        HumanGuessesGame game = new HumanGuessesGame(500);
        game.makeGuess(1);
        game.makeGuess(2);
        game.makeGuess(3);
        game.makeGuess(4);
        game.makeGuess(6);
        game.makeGuess(6);
        game.makeGuess(7);
        game.makeGuess(8);
        game.makeGuess(9);
        assertEquals(9, game.getNumGuesses());
    }
    @Test
    void getNumGuessesFew() {
        HumanGuessesGame game = new HumanGuessesGame(500);
        game.makeGuess(1);
        assertEquals(1, game.getNumGuesses());
    }
    @Test
    void getNumGuessesNone() {
        HumanGuessesGame game = new HumanGuessesGame(500);
        assertEquals(0, game.getNumGuesses());
    }

    @Test
    void isDone() {
        HumanGuessesGame game = new HumanGuessesGame(500);
        game.makeGuess(500);
        assertTrue(game.isDone());
    }
    @Test
    void isNotDone() {
        HumanGuessesGame game = new HumanGuessesGame(500);
        game.makeGuess(100);
        assertFalse(game.isDone());
    }
}