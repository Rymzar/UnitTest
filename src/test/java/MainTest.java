import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest {

    Main sut;

    @BeforeEach
    public void init() {
        System.out.println("tests started");
        sut = new Main();
    }

    @BeforeAll
    public static void started() {
        System.out.println("test start");
    }

    @AfterAll
    public static void finished() {
        System.out.println("test completed");
    }

    @AfterAll
    public static void finishedAll() {
        System.out.println("test completed");
    }

    @Test
    public void testTaxEarningsMinusSpendings() {

        int earnings = 1500, spendings = 1000, expected = 75;

        int result = sut.taxEarningsMinusSpendings(earnings, spendings);

        assertEquals(expected, result);
    }

    @Test
    public void testTaxEarningsMinus() {
        int earnings = 1500, spendings = 2500, expected = 0;

        int result = sut.taxEarningsMinusSpendings(earnings, spendings);

        assertEquals(expected, result);
    }

    @Test
    public void testTaxEarnings() {

        int earnings = 1500, expected = 90;

        int result = sut.taxEarnings(earnings);

        assertEquals(expected, result);
    }
}
