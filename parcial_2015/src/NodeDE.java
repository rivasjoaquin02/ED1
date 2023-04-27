package parcial_2015.src;

public class NodeDE <T> {
    protected T data;
    protected NodeDE <T> next;
    protected NodeDE <T> prev;

    public NodeDE(T data) {
        this.data = data;
    }

    public NodeDE(T data, NodeDE<T> prev , NodeDE<T> next) {
        this.data = data;
        this.next = next;
        this.prev = prev;
    }

    public T getData() {
        return data;
    }

    public NodeDE<T> getNext() {
        return next;
    }

    public NodeDE<T> getPrev() {
        return prev;
    }

    public void setNext(NodeDE<T> next) {
        this.next = next;
    }

    public void setPrev(NodeDE<T> prev) {
        this.prev = prev;
    }
}
