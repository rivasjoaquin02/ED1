import java.util.Stack;

public class BST<T extends Comparable<T>> {
    private int size;
    protected Node<T> root;

    public BST() {
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public void add(T value) {
        root = add(root, value);
        size++;
    }

    private Node<T> add(Node<T> node, T value) {
        if (node == null)
            return new Node<T>(value);
        if (value.compareTo(node.val) < 0)
            node.left = add(node.left, value);
        else
            node.right = add(node.right, value);
        return node;
    }

    public void remove(T value) {
        root = remove(root, value);
        size--;
    }

    private Node<T> remove(Node<T> node, T value) {
        if (node == null) return null;

        if (value.equals(node.val)) {
            if (node.left == null && node.right == null) return null;
            if (node.left == null) return node.right;
            if (node.right == null) return node.left;

            Node<T> leftMost = node.right;
            while (leftMost.left != null)
                leftMost = leftMost.left;

            node.val = leftMost.val;
            node.right = remove(node.right, leftMost.val);
        } else if (value.compareTo(node.val) < 0)
            node.left = remove(node.left, value);
        else
            node.right = remove(node.right, value);
        return node;
    }

    public boolean contains(T value) {
        return contains(root, value);
    }

    private boolean contains(Node<T> node, T value) {
        if (node == null)
            return false;

        if (node.val.equals(value))
            return true;
        if (value.compareTo(node.val) < 0)
            return contains(node.left, value);

        return contains(node.right, value);
    }

    public T greatest() {
        Node<T> ans = root;
        while (ans.right != null)
            ans = ans.right;
        return ans.val;
    }

    public T smallest() {
        Node<T> ans = root;
        while (ans.left != null)
            ans = ans.left;
        return ans.val;
    }

    public Node<T> kthSmallest(int k) {
        return kthSmallest(root, k);
    }

    private Node<T> kthSmallest(Node<T> node, int k) {
        Stack<Node<T>> stack = new Stack<>();

        while (true) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }

            node = stack.pop();
            if (--k == 0) return node;
            node = node.right;
        }
    }
}
