import java.util.Iterator;

public class Coleccion implements Iterable {
    protected NodoSE head;

    public Coleccion(NodoSE head) {
        this.head = head;
    }

    public boolean esZigsag() {
        NodoSE trav = head;
        int c=0;

        while (trav != null){
            if (c % 2 == 0 && trav.data % 2 != 0) return false;
            else if (c % 2 != 0 && trav.data % 2 == 0) return false;
            trav = trav.next;
            c++;
        }
        return true;
    }

    @Override public Iterator iterator() {
        return new Iterator() {
            @Override public boolean hasNext() {
                return head.next != null;
            }
            @Override public Object next() {
                return head.next;
            }
        };
    }
}
