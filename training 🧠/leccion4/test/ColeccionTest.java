import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ColeccionTest {
    Coleccion coleccion = new Coleccion(null);

    @Test
    void testEsZigsagNull() {
        // Crear una colección vacía
        Coleccion coleccion = new Coleccion(null);
        assertTrue(coleccion.esZigsag());
    }

    @Test
    void testEsZigsag2() {
        // Crear una colección con un solo elemento par
        coleccion = new Coleccion(new NodoSE(2));
        assertTrue(coleccion.esZigsag());
    }

    @Test
    void testEsZigsag3() {
        // Crear una colección con un solo elemento impar
        coleccion = new Coleccion(new NodoSE(3));
        assertFalse(coleccion.esZigsag());
    }

    @Test
    void testEsZigsag2547() {
        // Crear una colección con varios elementos pares e impares alternados
        coleccion = new Coleccion(new NodoSE(2,
                new NodoSE(5,
                        new NodoSE(4,
                                new NodoSE(7)))));
        assertTrue(coleccion.esZigsag());
    }

    @Test
    void testEsZigsag2467() {
        // Crear una colección con varios elementos pares e impares no alternados
        coleccion = new Coleccion(new NodoSE(2,
                new NodoSE(4,
                        new NodoSE(6,
                                new NodoSE(7)))));
        // Comprobar que no es zigsag
        assertFalse(coleccion.esZigsag());
    }

}