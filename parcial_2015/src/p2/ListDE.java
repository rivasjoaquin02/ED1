package parcial_2015.src.p2;
import parcial_2015.src.NodeDE;

public class ListDE <T> {
    protected NodeDE<T> head;
    protected NodeDE <T> tail;
    protected int size;

    public ListDE() {size = 0;}

    public int getSize() {
        return size;
    }
    public boolean isEmpty() {
        return getSize() == 0;
    }

    public void add(T data) {
        if (isEmpty()) {
            head = tail = new NodeDE<>(data);
            head.setNext(tail);
            tail.setPrev(head);
            size++;
            return;
        }
        NodeDE <T> newNode = new NodeDE<>(data, tail, null);
        tail.setNext(newNode);
        tail = tail.getNext();
        size++;
    }

    public void rotateRight() {
        NodeDE <T> tempNode = new NodeDE<>(tail.getData(), null, head);
        head.setPrev( tempNode );
        head = head.getPrev();

        tail = tail.getPrev();
        tail.setNext(null);
    }
}
