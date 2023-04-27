public class Node <T> {
    protected T data;
    protected Node <T> left;
    protected Node <T> right;

    public Node(T data) {
        this.data = data;
        left = right = null;
    }
}
