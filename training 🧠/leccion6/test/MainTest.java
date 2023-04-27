import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void bingo() {

        assertTrue( Main.Bingo("aabb"));
        assertTrue( Main.Bingo("aaabbb"));
        assertTrue( Main.Bingo("ab"));

        assertFalse( Main.Bingo("aba") );
        assertFalse( Main.Bingo("aaab") );
        assertFalse( Main.Bingo("abbb") );
        assertFalse( Main.Bingo("aabbaabb") );

    }
}