public class ColeccionEnteros {
    protected NodoSE head;

    public ColeccionEnteros(NodoSE head) {
        this.head = head;
    }

    public void Intercalar(int pos){
        NodoSE trav = head;
        int c=0;

        while ( c < pos ) {
            if (c == pos-1 && trav.data > trav.next.data) {
                int tmp = trav.data;
                trav.data = trav.next.data;
                trav.next.data = tmp;
            }
            c++;
        }
    }
}
