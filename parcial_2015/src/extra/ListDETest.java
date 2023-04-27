package extra;

import org.junit.jupiter.api.Test;

class ListDETest {

    @Test
    void deleteCenterTestEven() {
        ListDE<Integer> listDE = new ListDE<Integer>();
        listDE.add(1);
        listDE.add(2);
        listDE.add(3);
        listDE.add(4);
        listDE.add(5);

        listDE.deleteCenter();

        System.out.println("debug");
    }

    @Test
    void deleteCenterTestOdd() {
        ListDE<Integer> listDE = new ListDE<Integer>();
        listDE.add(1);
        listDE.add(2);
        listDE.add(3);
        listDE.add(4);

        listDE.deleteCenter();

        System.out.println("debug");
    }

    @Test
    void deleteCenterTest2() {
        ListDE<Integer> listDE = new ListDE<Integer>();
        listDE.add(1);
        listDE.add(2);

        listDE.deleteCenter();

        System.out.println("debug");
    }

    @Test
    void deleteCenterTest1() {
        ListDE<Integer> listDE = new ListDE<Integer>();
        listDE.add(1);

        listDE.deleteCenter();

        System.out.println("debug");
    }
}