import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CajeroAutomaticoTest {

    @Test
    void testSurtirCajero400() {
        CajeroAutomatico cajero = new CajeroAutomatico(10, 20, 20);
        cajero.SurtirCajero(400);
        assertEquals(60, cajero.cantidadBilletes5());
        assertEquals(40, cajero.cantidadBilletes10());
        assertEquals(20, cajero.cantidadBilletes20());
    }

    @Test
    void testSurtirCajero150() {
        CajeroAutomatico cajero = new CajeroAutomatico(10, 20, 20);
        cajero.SurtirCajero(150);
        assertEquals(40, cajero.cantidadBilletes5());
        assertEquals(20, cajero.cantidadBilletes10());
        assertEquals(20, cajero.cantidadBilletes20());
    }

    @Test
    void testSurtirCajero10() {
        CajeroAutomatico cajero = new CajeroAutomatico();
        cajero.SurtirCajero(10);
        assertEquals(1, cajero.cantidadBilletes10());
        assertEquals(0, cajero.cantidadBilletes20());
        assertEquals(1, cajero.cantidadBilletes5());
    }

    @Test
    void testSurtirCajero20() {
        CajeroAutomatico cajero = new CajeroAutomatico();
        cajero.SurtirCajero(20);
        assertEquals(2, cajero.cantidadBilletes10());
        assertEquals(1, cajero.cantidadBilletes20());
        assertEquals(3, cajero.cantidadBilletes5());
    }
}