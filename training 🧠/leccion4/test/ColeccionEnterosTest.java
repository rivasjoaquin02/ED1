import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ColeccionEnterosTest {

    ColeccionEnteros coleccion;

    @Test
    void testIntercalarNull() {
        // Crear una colección vacía
        coleccion = new ColeccionEnteros(null);
        // Intentar intercalar en la posición 0
        coleccion.Intercalar(0);
        // Comprobar que la colección sigue vacía
        assertNull(coleccion.head);
    }

    @Test
    void testIntercalar01() {
        // Crear una colección con un solo elemento
        coleccion = new ColeccionEnteros(new NodoSE(1));
        // Intentar intercalar en la posición 0 o 1
        coleccion.Intercalar(0);
        assertThrows(NullPointerException.class, () -> coleccion.Intercalar(1));

        // Comprobar que la colección sigue con el mismo elemento
        assertEquals(1, coleccion.head.data);
    }

    @Test
    void testIntercalar1234() {
        // Crear una colección con varios elementos ordenados de forma ascendente
        coleccion = new ColeccionEnteros(new NodoSE(1,
                new NodoSE(2,
                        new NodoSE(3,
                                new NodoSE(4)))));
        // Intentar intercalar en cualquier posición
        for (int i = 0; i < 4; i++) {
            coleccion.Intercalar(i);
            // Comprobar que la colección sigue ordenada de forma ascendente
            assertEquals(1, coleccion.head.data);
            assertEquals(2, coleccion.head.next.data);
            assertEquals(3, coleccion.head.next.next.data);
            assertEquals(4, coleccion.head.next.next.next.data);
        }
    }

    @Test
    void testIntercalar() {
        // Crear una colección con varios elementos ordenados de forma descendente
        coleccion = new ColeccionEnteros(new NodoSE(4,
                new NodoSE(3,
                        new NodoSE(2,
                                new NodoSE(1)))));

        coleccion.Intercalar(1);
        coleccion.Intercalar(3);

        assertEquals(3, coleccion.head.data);
        assertEquals(4, coleccion.head.next.data);
        assertEquals(1, coleccion.head.next.next.data);
        assertEquals(2, coleccion.head.next.next.next.data);

    }
}