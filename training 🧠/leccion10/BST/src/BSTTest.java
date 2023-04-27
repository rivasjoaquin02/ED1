import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BSTTest {

    BST <Integer> tree;

    @BeforeEach
    void setUp(){
        tree = new BST <> ();
    }

    @Test
    void add() {
        tree.add(44);
        assertEquals( 44, tree.root.val );
        tree.add(27);
        assertEquals( 27 , tree.root.left.val);
        tree.add(1);
        assertEquals( 1 , tree.root.left.left.val);
        tree.add(39);
        assertEquals( 39 , tree.root.left.right.val);
        tree.add(68);
        assertEquals( 68, tree.root.right.val);
        tree.add(51);
        assertEquals( 51, tree.root.right.left.val);
        tree.add(79);
        assertEquals(79, tree.root.right.right.val);
    }

    @Test
    void add2() {
        tree.add(35);
        assertEquals( 35, tree.root.val );
        tree.add(84);
        assertEquals( 84 , tree.root.right.val);
        tree.add(51);
        assertEquals( 51 , tree.root.right.left.val);
        tree.add(68);
        assertEquals( 68 , tree.root.right.left.right.val);
        tree.add(79);
        assertEquals( 79, tree.root.right.left.right.right.val);
        tree.add(44);
        assertEquals( 44, tree.root.right.left.left.val);

    }

    @Test
    void remove() {
        tree.add(44);
        tree.add(27);
        tree.add(1);
        tree.add(39);
        tree.add(68);
        tree.add(51);
        tree.add(79);

        tree.remove(44);
        assertEquals( 51, tree.root.val );
        assertEquals( 27 , tree.root.left.val);
        assertEquals( 1 , tree.root.left.left.val);
        tree.remove(27);
        assertEquals( 39 , tree.root.left.val);
        assertEquals( 68, tree.root.right.val);
        tree.remove(51);
        assertEquals( 68, tree.root.val );
        assertEquals( 79, tree.root.right.val);
    }

    @Test
    void contains() {
        tree.add(44);
        tree.add(27);
        tree.add(1);
        tree.add(39);
        tree.add(68);
        tree.add(51);
        tree.add(79);
        assertTrue( tree.contains(44) );
        assertTrue( tree.contains(1) );
        assertTrue( tree.contains(79) );
        assertFalse( tree.contains(789) );
        assertFalse( tree.contains(89) );
        assertFalse( tree.contains(52) );
    }

    @Test
    void greatest(){
        tree.add(50);
        tree.add(45);
        tree.add(63);
        tree.add(38);
        tree.add(49);
        tree.add(71);

        assertEquals(71, tree.greatest());
        tree.remove(71);
        assertEquals(63, tree.greatest());
        tree.remove(63);
        assertEquals(50, tree.greatest());
        tree.remove(50);
        assertEquals(49, tree.greatest());
    }

    @Test
    void smallest(){
        tree.add(50);
        tree.add(45);
        tree.add(63);
        tree.add(38);
        tree.add(49);
        tree.add(71);

        assertEquals(38, tree.smallest());
        tree.remove(38);
        assertEquals(45, tree.smallest());
        tree.remove(45);
        assertEquals(49, tree.smallest());
        tree.remove(49);
        assertEquals(50, tree.smallest());
    }

    @Test
    void kthSmallest(){
        tree.add(50);
        tree.add(45);
        tree.add(63);
        tree.add(38);
        tree.add(49);
        tree.add(71);

        assertEquals( 38, tree.kthSmallest(1).val );
        assertEquals( 45, tree.kthSmallest(2).val );
        assertEquals( 50, tree.kthSmallest(4).val );
        assertEquals( 63, tree.kthSmallest(5).val );
    }

}