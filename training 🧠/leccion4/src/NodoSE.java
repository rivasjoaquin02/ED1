public class NodoSE {
    protected int data;
    protected NodoSE next;

    public NodoSE(int data, NodoSE next) {
        this.data = data;
        this.next = next;
    }

    public NodoSE(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public NodoSE getNext() {
        return next;
    }

    public void setData(int data) {
        this.data = data;
    }

    public void setNext(NodoSE next) {
        this.next = next;
    }
}
