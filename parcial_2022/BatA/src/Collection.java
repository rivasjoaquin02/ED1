import java.util.Iterator;

public class Collection<T> implements Iterable<T> {
    private int size;
    private NodeSE<T> head;

    public Collection() {
        this.size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(T data) {
        if (head == null) {
            head = new NodeSE<>(data);
            size++;
            return;
        }

        NodeSE<T> newNode = new NodeSE<>(data);
        NodeSE<T> trav = head;

        while (trav.getNext() != null)
            trav = trav.getNext();

        trav.setNext(newNode);
        size++;
    }

    public void jumpNNodes(T value, int cant) {
        NodeSE<T> trav = head;

        // 1. find the node before the node I want to move
        while (!trav.getNext().getData().equals(value) && trav.getNext() != null)
            trav = trav.getNext();

        // 2. delete the node I want to move
        trav.setNext(trav.getNext().getNext());

        // 3. I move to the new position
        while (cant > 0 && trav.getNext() != null) {
            trav = trav.getNext();
            cant--;
        }
        // 4. Place the element after the node the trav is place on
        NodeSE<T> newNode = new NodeSE<>(value, trav.getNext());
        trav.setNext(newNode);
    }


    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            NodeSE <T> trav = head;
            @Override public boolean hasNext() {
                return trav.getNext() != null;
            }

            @Override public T next() {
                T data = trav.getData();
                trav = trav.getNext();
                return data ;
            }
        };
    }
}
