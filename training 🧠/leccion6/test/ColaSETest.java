import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;

public class ColaSETest {

    private ColaSE<Integer> cola = new ColaSE<>();


    @Test
    public void testSize() {
        assertEquals(0, cola.size());
        cola.add(1);
        assertEquals(1, cola.size());
        cola.add(2);
        assertEquals(2, cola.size());
        try {
            cola.pop();
        } catch (Exception ignore) {}
        assertEquals(1, cola.size());
    }

    @Test
    public void testIsEmpty() {
        assertTrue(cola.isEmpty());
        cola.add(1);
        assertFalse(cola.isEmpty());
        try {
            cola.pop();
        } catch (Exception ignore) {}
        assertTrue(cola.isEmpty());
    }

    @Test
    public void testAdd() {
        cola.add(1);
        assertEquals(1, (int) cola.peek());
        cola.add(2);
        assertEquals(1, (int) cola.peek());
        cola.add(3);
        assertEquals(1, (int) cola.peek());
    }


    @Test
    public void testPop() throws Exception {
        try {
            cola.pop();
            fail("Should throw exception");
        } catch (Exception e) {
            // expected
            assertEquals("Queue is empty", e.getMessage());
        }

        cola.add(1);
        cola.add(2);
        cola.pop();
        assertEquals(2, (int) cola.peek());
        cola.pop();
        try {
            cola.pop();
            fail("Should throw exception");
        } catch (Exception e) {
            // expected
            assertEquals("Queue is empty", e.getMessage());
        }

    }

    @Test
    void peek() {
    }

    @Test
    void contains() {
    }
}