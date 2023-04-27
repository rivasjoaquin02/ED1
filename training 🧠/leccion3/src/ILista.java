public interface ILista <T> {
    int length();
    void append(T value);
    void insert(int pos, T value);
    void remove(T value);
    boolean contains(T value);
}
