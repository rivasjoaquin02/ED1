import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PilaSETest {

    @Test
    void size() {
        PilaSE <Character> pila = new PilaSE<>();
        assertEquals(0, pila.size());
    }

    @Test
    public void testPush() {
        // Crear una pila vacía
        PilaSE<Integer> pila = new PilaSE<>();

        // Añadir un elemento a la pila
        pila.push(10);

        // Comprobar que la pila no está vacía y que su tamaño es 1
        assertFalse(pila.isEmpty());
        assertEquals(1, pila.size());

        // Comprobar que el elemento añadido es el que está en la cima de la pila
        try {
            assertEquals(10, pila.peek());
        } catch (Exception e) {
            fail("La pila no debería lanzar una excepción");
        }
    }

    @Test
    void pop() {
    }

    @Test
    void peek() {
    }

    @Test
    void contains() {
    }
}