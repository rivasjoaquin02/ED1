import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MainTest {

    @Test
    void numberOfDigits() {
        assertEquals(1, numberOfDigits(3));
        assertEquals(4, numberOfDigits(3453));
        assertEquals(6, numberOfDigits(444443));
        assertEquals(2, numberOfDigits(21));

    }

    @Test
    void mcd() {
        assertEquals(2, Main.mcd(2, 6));
    }
}