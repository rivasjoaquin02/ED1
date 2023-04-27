import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TDA_ListaTest {

    @Test
    public void testAppend() {
        // Crear una lista vacía
        TDA_Lista<String> lista = new TDA_Lista<>();

        // Comprobar que la lista tiene tamaño 0
        assertEquals(0, lista.length());

        // Añadir un elemento a la lista
        lista.append("Hola");

        // Comprobar que la lista tiene tamaño 1 y el elemento añadido
        assertEquals(1, lista.length());
        assertEquals("Hola", lista.elements[0]);

        // Añadir otro elemento a la lista
        lista.append("Mundo");

        // Comprobar que la lista tiene tamaño 2 y los elementos añadidos
        assertEquals(2, lista.length());
        assertEquals("Hola", lista.elements[0]);
        assertEquals("Mundo", lista.elements[1]);
    }


    @Test
    void insert() {
    }

    @Test
    void remove() {
    }

    @Test
    void contains() {
    }
}