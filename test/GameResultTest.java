import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameResultTest {

    @Test
    void constructor() {
        GameResult gameResult = new GameResult(true, 1, 1);
        assertInstanceOf(GameResult.class, gameResult);
    }

    @Test
    void humanWasPlaying() {
        GameResult gameResult = new GameResult(true, 1, 1);
        assertTrue(gameResult.humanWasPlaying());
    }

    @Test
    void correctValue() {
        GameResult gameResult = new GameResult(true, 1, 1);
        assertEquals(1, gameResult.correctValue());
    }

    @Test
    void numGuesses() {
        GameResult gameResult = new GameResult(true, 1, 1);
        assertEquals(1, gameResult.numGuesses());
    }

    @Test
    void equivalentRecord() {
        GameResult gameResult1 = new GameResult(true, 1, 1);
        GameResult gameResult2 = new GameResult(true, 1, 1);
        assertEquals(gameResult1, gameResult2);
    }
}