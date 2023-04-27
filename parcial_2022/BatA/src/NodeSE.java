public class NodeSE <T> {
    private T data;
    private NodeSE <T> next;

    public NodeSE(T data) {
        this.data = data;
    }

    public NodeSE(T data, NodeSE<T> next) {
        this.data = data;
        this.next = next;
    }

    public T getData() {
        return data;
    }

    public NodeSE<T> getNext() {
        return next;
    }

    public void setNext(NodeSE<T> next) {
        this.next = next;
    }
}
