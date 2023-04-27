import java.util.Stack;

public class BST <T extends Comparable<T>>  {
    protected Node <T> root;
    int size = 0;

    public BST(){}

    public boolean isLeaf(){return root.left == null && root.right == null;}
    public int height(){
        return height(root);
    }
    private int height(Node <T> node){
        if (node == null) return 0;
        return Math.max(height(node.left), height(node.right)) + 1;
    }

    public int size(){return size;}
    public boolean isEmpty(){return size() == 0;}

    public void add(T data){
        root = add(root, data);
    }

    private Node<T> add(Node <T> node, T data){
        if (node == null){
            size++;
            return new Node<>(data);
        }

        int cmp = data.compareTo(node.data);
        if (cmp <= 0)
            node.left = add(node.left, data);
        else
            node.right = add(node.right, data);

        return node;
    }

    public void remove(T data){
        root = remove(root, data);
    }

    private Node <T> remove(Node<T> node, T data){
        if (isEmpty())
            return null;

        int cmp = data.compareTo(node.data);
        if (cmp < 0)
            node.left = remove(node.left, data);
        else if (cmp > 0)
            node.right = remove(node.right, data);
        else {
            if (node.left == null) return node.right;
            if (node.right == null) return node.left;

            Node <T> leftMost = node.right;
            while (leftMost.left != null)
                leftMost = leftMost.left;
            node.data = leftMost.data;

            node.right = remove(node.right, leftMost.data);
        }

        return node;
    }

    public T kMost(int k){
        Node<T> trav = root;
        Stack<Node<T>> q = new Stack<>();

        while (true) {
            while (trav != null){
                q.push(trav);
                trav = trav.left;
            }

            trav = q.pop();
            if (--k == 0) return trav.data;
            trav = trav.right;
        }
    }


    public void preOrder(){
        preOrder(root);
    }
    public void preOrder(Node <T> node){
        if (node == null) return;

        preOrder(node.left);
        System.out.println(node.data);
        preOrder(node.right);
    }

    public void inOrder(){
        inOrder(root);
    }
    private void inOrder(Node <T> node){
        if (node == null)
            return;

        inOrder(node.left);
        System.out.println(node.data);
        inOrder(node.right);
    }

    public void postOrder(){
        postOrder(root);
    }
    private void postOrder(Node <T> node){
        if (node == null) return;

        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.data + " ");
    }
}
