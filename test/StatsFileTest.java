import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;

import static org.junit.jupiter.api.Assertions.*;

class StatsFileTest {
    private StatsFile statsFile;

    @BeforeEach
    public void setUp() {
        statsFile = new StatsFile();
    }
    @Test
    void numGames() {
    }

    @Test
    void maxNumGuesses() {
    }

    @Test
    public void testParseLocalDateTime() {
        //using dependency injection
        LocalDateTime dateTime = statsFile.parseLocalDateTime("2024-03-20T20:09:21.190258900");
        assertEquals(2024, dateTime.getYear());
        assertEquals(3, dateTime.getMonthValue());
        assertEquals(20, dateTime.getDayOfMonth());
        assertEquals(20, dateTime.getHour());
        assertEquals(9, dateTime.getMinute());
        assertEquals(21, dateTime.getSecond());
        assertEquals(190258900, dateTime.getNano());
    }

    @Test
    public void testBadDate() {
        assertThrows(DateTimeParseException.class, () -> statsFile.parseLocalDateTime("string_invalid_datetime"));
    }


}