import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PlanificadorTest {

    Planificador planificador;

    @BeforeEach
    void setUp() {
        planificador = new Planificador();

        planificador.addPrograma(new Programa(1, "linux", 8, 1000.0));
        planificador.addPrograma(new Programa(2, "linux", 4, 100.0));
        planificador.addPrograma(new Programa(3, "linux", 8, 400.0));
        planificador.addPrograma(new Programa(4, "linux", 2, 300.0));
        planificador.addPrograma(new Programa(5, "macos", 1, 20.0));
        planificador.addPrograma(new Programa(6, "windows", 32, 5000.0));

        planificador.addOrdenador(new Ordenador("s1", "linux", 8, 2));
        planificador.addOrdenador(new Ordenador("s2", "windows", 4, 2));
        planificador.addOrdenador(new Ordenador("s3", "linux", 8, 2));
        planificador.addOrdenador(new Ordenador("s4", "linux", 16, 0));

    }

    @Test
    void testCrearTarea() {
        planificador.CrearTarea();
        assertEquals(1, planificador.tareas.size());
        assertEquals(5, planificador.programas.size());
        assertEquals(2, planificador.ordenadores.get(0).getProcesadoresEnUso());
        assertEquals(8, planificador.ordenadores.get(3).getProcesadoresEnUso());
    }

    @Test
    void testCrearTarea2() {
        planificador.CrearTarea();
        planificador.CrearTarea();
        assertEquals(2, planificador.tareas.size());
        assertEquals(4, planificador.programas.size());
        assertEquals(6, planificador.ordenadores.get(0).getProcesadoresEnUso());
        assertEquals(8, planificador.ordenadores.get(3).getProcesadoresEnUso());
    }

    @Test
    void tiempoEstimado() {
        planificador.CrearTarea();
        assertEquals(1000.0, planificador.TiempoEstimado());
    }

    @Test
    void tiempoEstimado2() {
        planificador.CrearTarea();
        planificador.CrearTarea();
        assertEquals(1100.0, planificador.TiempoEstimado());
    }

    @Test
    void tiempoEstimado3() {
        planificador.CrearTarea();
        planificador.CrearTarea();
        planificador.CrearTarea();
        assertEquals(1500.0, planificador.TiempoEstimado());
    }

    @Test
    void ejecutarPrimeroLinux() {
        planificador.EjecutarPrimero("linux");
        assertEquals("linux", planificador.programas.poll().getSistOperativo());
        assertEquals("linux", planificador.programas.poll().getSistOperativo());
        assertEquals("linux", planificador.programas.poll().getSistOperativo());
        assertEquals("linux", planificador.programas.poll().getSistOperativo());
        assertEquals("macos", planificador.programas.poll().getSistOperativo());
        assertEquals("windows", planificador.programas.poll().getSistOperativo());
    }

    @Test
    void ejecutarPrimeroWindows() {
        planificador.EjecutarPrimero("windows");
        assertEquals("windows", planificador.programas.poll().getSistOperativo());
        assertEquals("linux", planificador.programas.poll().getSistOperativo());
        assertEquals("linux", planificador.programas.poll().getSistOperativo());
        assertEquals("linux", planificador.programas.poll().getSistOperativo());
        assertEquals("linux", planificador.programas.poll().getSistOperativo());
        assertEquals("macos", planificador.programas.poll().getSistOperativo());
    }

    @Test
    void ejecutarPrimeroMacos() {
        planificador.EjecutarPrimero("macos");
        assertEquals("macos", planificador.programas.poll().getSistOperativo());
        assertEquals("linux", planificador.programas.poll().getSistOperativo());
        assertEquals("linux", planificador.programas.poll().getSistOperativo());
        assertEquals("linux", planificador.programas.poll().getSistOperativo());
        assertEquals("linux", planificador.programas.poll().getSistOperativo());
        assertEquals("windows", planificador.programas.poll().getSistOperativo());

    }

    @Test
    void ejecutarPrimeroSecuenciales() {
        planificador.EjecutarPrimeroSecuenciales();
        assertEquals(5, planificador.programas.poll().id);
        assertEquals(1, planificador.programas.poll().id);
        assertEquals(2, planificador.programas.poll().id);
        assertEquals(3, planificador.programas.poll().id);
        assertEquals(4, planificador.programas.poll().id);
        assertEquals(6, planificador.programas.poll().id);
    }

    @Test
    void procesadoresLibres() {
        assertEquals(6, planificador.ProcesadoresLibres("s1"));
        assertEquals(2, planificador.ProcesadoresLibres("s2"));
        assertEquals(6, planificador.ProcesadoresLibres("s3"));
        assertEquals(16, planificador.ProcesadoresLibres("s4"));
    }

    @Test
    void procesadoresLibres2() {
        planificador.CrearTarea();
        assertEquals(8, planificador.ProcesadoresLibres("s4"));
        planificador.CrearTarea();
        assertEquals(2, planificador.ProcesadoresLibres("s1"));
        planificador.CrearTarea();
        assertEquals(0, planificador.ProcesadoresLibres("s4"));
    }

}