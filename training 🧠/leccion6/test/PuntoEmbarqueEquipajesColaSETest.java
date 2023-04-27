import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PuntoEmbarqueEquipajesColaSETest {

    PuntoEmbarqueEquipajesColaSE p;

    @Test
    void testLlenarCarro1() {
        p =  new PuntoEmbarqueEquipajesColaSE();
        p.addEstera1(new Equipaje(1, 30.0));
        p.addEstera1(new Equipaje(2, 60.0));

        p.addEstera2(new Equipaje(3, 40.0));
        p.addEstera2(new Equipaje(4, 10.0));

        p.addEstera3(new Equipaje(5, 500.0));
        p.addEstera3(new Equipaje(6, 60.0));

        assertEquals(3, p.LlenarCarro(100.0));
    }

    @Test
    void testLlenarCarro2() {
        p =  new PuntoEmbarqueEquipajesColaSE();

        p.addEstera1(new Equipaje(1, 30.0));
        p.addEstera1(new Equipaje(2, 60.0));

        p.addEstera2(new Equipaje(3, 40.0));
        p.addEstera2(new Equipaje(4, 10.0));

        p.addEstera3(new Equipaje(5, 500.0));
        p.addEstera3(new Equipaje(6, 60.0));

        assertEquals(2, p.LlenarCarro(70.0));
    }

    @Test
    void testLlenarCarro3() {
        p =  new PuntoEmbarqueEquipajesColaSE();

        p.addEstera1(new Equipaje(1, 30.0));
        p.addEstera1(new Equipaje(2, 60.0));

        p.addEstera2(new Equipaje(3, 40.0));
        p.addEstera2(new Equipaje(4, 10.0));

        p.addEstera3(new Equipaje(5, 500.0));
        p.addEstera3(new Equipaje(6, 60.0));

        assertEquals(1, p.LlenarCarro(60.0));
    }

    @Test
    void testLlenarCarro4() {
        p =  new PuntoEmbarqueEquipajesColaSE();

        p.addEstera1(new Equipaje(1, 30.0));
        p.addEstera1(new Equipaje(2, 60.0));

        p.addEstera2(new Equipaje(3, 40.0));
        p.addEstera2(new Equipaje(4, 10.0));

        p.addEstera3(new Equipaje(5, 500.0));
        p.addEstera3(new Equipaje(6, 60.0));

        assertEquals(0, p.LlenarCarro(20.0));
    }

    @Test
    void testLlenarCarro5() {
        p =  new PuntoEmbarqueEquipajesColaSE();

        p.addEstera1(new Equipaje(1, 30.0));
        p.addEstera1(new Equipaje(2, 60.0));

        p.addEstera2(new Equipaje(3, 40.0));
        p.addEstera2(new Equipaje(4, 10.0));

        p.addEstera3(new Equipaje(5, 500.0));
        p.addEstera3(new Equipaje(6, 60.0));

        assertEquals(4, p.LlenarCarro(570.0));
    }

}