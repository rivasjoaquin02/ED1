public class PilaSE <T> {

    private int length = 0;
    private Node <T> head;

    public PilaSE() {
        head = new Node <T> (null);
    }

    public int size() {return length;}
    public boolean isEmpty() {return length == 0;}

    public void push(T value) {
        if (head == null){
            head.data = value;
            return;
        }

        Node newNode = new Node <T> (value);

        newNode.next = head;
        head = newNode;

        length++;
    }

    public void pop() throws Exception {
        if (isEmpty())
            throw new Exception("Stack is empty");

        head = head.next;

        length--;
    }
    public T peek() throws Exception {
        if (isEmpty())
            throw new Exception("Stack is empty");

        return head.data;
    }
    public boolean contains(T value) throws Exception {
        if (isEmpty())
            throw new Exception("Stack is empty");

        Node trav = head;

        while (trav != null) {
            if (trav.data == value)
                return true;
            trav = trav.next;
        }
        return false;
    }

}
