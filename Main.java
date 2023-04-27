
public class Main {
    public static void main(String[] args) {

        BST <Integer> tree = new BST<>();

        tree.add(5);
        tree.add(3);
        tree.add(1);
        tree.add(2);
        tree.add(8);
        tree.add(6);
        tree.add(9);

//        System.out.println( tree.kMost(5) );
        tree.postOrder();

    }
}