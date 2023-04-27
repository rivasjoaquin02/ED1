package extra;

import org.w3c.dom.Node;
import parcial_2015.src.NodeDE;

public class ListDE<T> {
    protected NodeDE<T> head;
    protected NodeDE<T> tail;
    protected int size;

    public ListDE() {
        size = 0;
    }

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
        NodeDE<T> newNode = new NodeDE<>(data, tail, null);
        tail.setNext(newNode);
        tail = tail.getNext();
        size++;
    }

    public void deleteCenter() {
        if (size == 1) {
            head = tail = null;
            return;
        }

        if (size == 2) {
            head = tail;
            tail.setPrev(head);
            return;
        }

        boolean isPair = size % 2 == 0;
        int center = isPair
                ? size / 2 - 2
                : size / 2 - 1;

        NodeDE<T> trav = head;
        while (center > 0) {
            trav = trav.getNext();
            center--;
        }

        // case: size == 2
        // trav <-> * <-> * <-> travConex

        NodeDE<T> travConex = isPair
                ? trav.getNext().getNext().getNext()
                : trav.getNext().getNext();
        trav.setNext(travConex);
        trav.getNext()
                .setPrev(trav);
    }

}
