public class ColaSE <T> {

    private int length = 0;
    private Node <T> head;
    private Node <T> tail;

    public ColaSE() {
        head = tail = new Node<>(null);
    }

    public int size() {return length;}
    public boolean isEmpty() {return length == 0;}

    public void add(T value){
        Node <T> newNode = new Node <> (value);
        if (isEmpty()) {
            head = newNode;
            return;
        }

        tail.next = newNode;
        tail = tail.next;
        length++;
    }

    public void pop() {
        if (isEmpty()) return;

        head = head.next;
        length--;
    }

    public T peek()  {
        return head.data;
    }

    public boolean contains(T value) throws Exception {
        if (isEmpty())
            throw new Exception("Stack is empty");

        Node trav = head;

        while (trav != tail) {
            if (trav.data == value)
                return true;
            trav = trav.next;
        }
        return false;
    }
}
