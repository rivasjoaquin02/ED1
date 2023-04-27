import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ArbolGenealogicoTest {

    ArbolGenealogico root;
    Persona ilianet, gisela, anneris, yaisel, liandry, darlon, irela;

    @BeforeEach
    void setUp() {

        ilianet = new Persona("Ilianet", "Verdes");
        gisela = new Persona("Gisela", "Azules");
        anneris = new Persona("Anneris", "Azules");
        yaisel = new Persona("Yaisel", "Azules");
        liandry = new Persona("Liandry", "Pardos");
        darlon = new Persona("Darlon", "Negros");
        irela = new Persona("Irela", "Azules");

        root = new ArbolGenealogico(
                irela,
                Arrays.asList(
                        new ArbolGenealogico(
                                anneris,
                                Arrays.asList(
                                        new ArbolGenealogico(ilianet),
                                        new ArbolGenealogico(gisela))
                        ),
                        new ArbolGenealogico(
                                liandry,
                                Arrays.asList(
                                        new ArbolGenealogico(yaisel))
                        ),
                        new ArbolGenealogico(darlon)
                )
        );


    }

    @Test
    void testCantidadPersonasConOjosDistintos() {
        assertEquals(4, root.CantidadPersonasConOjosDistintos());
    }

    @Test
    void listaPersonasConOjosDeUnColorAzules() {
        List<Persona> expected = Arrays.asList(irela, anneris, gisela, yaisel);
        List<Persona> actual = root.listaPersonasConOjosDeUnColor("Azules");

        assertEquals(expected, actual);
    }

    @Test
    void listaPersonasConOjosDeUnColorVerdes() {
        List<Persona> expected = Arrays.asList(ilianet);
        List<Persona> actual = root.listaPersonasConOjosDeUnColor("Verdes");

        assertEquals(expected, actual);
    }

    @Test
    void listaPersonasConOjosDeUnColorNegros() {
        List<Persona> expected = Arrays.asList(darlon);
        List<Persona> actual = root.listaPersonasConOjosDeUnColor("Negros");

        assertEquals(expected, actual);
    }

    @Test
    void listaPersonasConOjosDeUnColorPardos() {
        List<Persona> expected = Arrays.asList(liandry);
        List<Persona> actual = root.listaPersonasConOjosDeUnColor("Pardos");

        assertEquals(expected, actual);
    }

    @Test
    void descendencia() {
        assertEquals(3, root.Descendencia());
    }

    void setUp2() {
        irela = new Persona("Irela", "Azules");

        anneris = new Persona("Anneris", "Pardos");
        liandry = new Persona("Liandry", "Azules");

        darlon = new Persona("Darlon", "Negros");
        ilianet = new Persona("Ilianet", "Pardos");

        gisela = new Persona("Gisela", "Verdes");
        Persona jo = new Persona("Jorge", "Azules");
        yaisel = new Persona("Yaisel", "Azules");

        Persona lin = new Persona("Lin", "Azules");

        root = new ArbolGenealogico(
                irela,
                Arrays.asList(
                        new ArbolGenealogico(
                                anneris,
                                Arrays.asList(
                                        new ArbolGenealogico(darlon),
                                        new ArbolGenealogico(ilianet))
                        ),
                        new ArbolGenealogico(
                                liandry,
                                Arrays.asList(
                                        new ArbolGenealogico(gisela),
                                        new ArbolGenealogico(jo),
                                        new ArbolGenealogico(
                                                yaisel,
                                                Arrays.asList(
                                                        new ArbolGenealogico(lin))))
                        )
                )
        );
    }

    @Test
    void descendencia2() {
        setUp2();
        assertEquals(4, root.Descendencia());
    }
}