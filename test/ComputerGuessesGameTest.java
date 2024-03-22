import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class ComputerGuessesGameTest {

    @Test
    void testSetup() {
        ComputerGuessesGame game = new ComputerGuessesGame();
        assertEquals(1, game.getLowerBound());
        assertEquals(1000, game.getUpperBound());
    }

    @Test
    void testHandleGuessResponse() {
        ComputerGuessesGame game = new ComputerGuessesGame();
        assertEquals(501,game.newGuess());
        game.handleGuessResponse(true); //guess number is higher number than 501

        assertEquals(1000, game.getUpperBound());

        assertEquals(501, game.getLowerBound());

    }

    @Test
    void testNewGuess() {
        ComputerGuessesGame game = new ComputerGuessesGame();
        game.newGuess();
        assertTrue(game.getLastGuess() >= game.getLowerBound() && game.getLastGuess() <= game.getUpperBound());
        game.handleGuessResponse(true);
        game.newGuess();
        assertTrue(game.getLastGuess() >= game.getLowerBound() && game.getLastGuess() <= game.getUpperBound());
        game.handleGuessResponse(true);
        game.newGuess();
        assertTrue(game.getLastGuess() >= game.getLowerBound() && game.getLastGuess() <= game.getUpperBound());
        game.handleGuessResponse(false);
        game.newGuess();

        assertTrue(game.getLastGuess() >= game.getLowerBound() && game.getLastGuess() <= game.getUpperBound());
        game.handleGuessResponse(true);
        game.newGuess();

        assertTrue(game.getLastGuess() >= game.getLowerBound() && game.getLastGuess() <= game.getUpperBound());
        game.handleGuessResponse(false);
        game.newGuess();

        assertTrue(game.getLastGuess() >= game.getLowerBound() && game.getLastGuess() <= game.getUpperBound());
        //guess is in the bounds  always
    }

    @Test
    void testGetGameResult() {
        ComputerGuessesGame game = new ComputerGuessesGame();
        game.newGuess();
        game.handleGuessResponse(true);
        game.newGuess();
        assertEquals(2, game.getNumGuesses());
        assertEquals(751, game.getLastGuess());
    }

}
