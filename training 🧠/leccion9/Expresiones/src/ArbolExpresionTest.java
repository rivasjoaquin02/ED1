import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArbolExpresionTest {

    ArbolExpresion root;

    @BeforeEach
    void setUp() {
        root = new ArbolExpresion(
                new Operador('+'),
                new ArbolExpresion(
                        new Operador('+'),
                        new ArbolExpresion(new Operando(2)),
                        new ArbolExpresion(
                                new Operador('*'),
                                new ArbolExpresion(new Operando(3)),
                                new ArbolExpresion(new Operando(4))
                        )
                ),
                new ArbolExpresion(
                        new Operador('-'),
                        new ArbolExpresion(new Operando(5)),
                        new ArbolExpresion(new Operando(1))
                )
        );

    }

    @Test
    void evaluar() {
        assertEquals(18, root.evaluar());
    }

    @Test
    void esHoja() {
        assertTrue( new ArbolExpresion(new Operando(4)).esHoja() );
        assertFalse(root.esHoja() );
    }
}