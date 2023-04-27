public class Node <T> {
    protected T val;
    protected Node <T> left, right;

    public Node(T val) {
        this.val = val;
        left = right = null;
    }

    public Node(T val, Node <T> left, Node <T> right) {
        this.left = left;
        this.right = right;
    }

}
