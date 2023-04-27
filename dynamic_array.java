import java.util.Arrays;
import java.util.Iterator;

public class dynamic_array <T> implements Iterable <T> {
    T[] elements;
    int real_size = 50;
    int size = 0;

    public dynamic_array() {
        elements = (T[]) new Object[real_size];
    }

    public int size() {return size;}
    public boolean isEmpty() {return size() == 0;}

    public void push(T data){
        if (size + 1 > real_size)
            resize();
        elements[size++] = data;
    }

    public void remove(int pos) throws Exception {
        if (isEmpty())
            throw new Exception("array is empty");

        for (int i = pos; i < size-1; i++)
            elements[i] = elements[i+1];
    }

    public void insert(int pos, T data){
        if (size + 1 > real_size)
            resize();
        for (int i=size; i > pos; i--)
            elements[i] = elements[i+1];
        elements[pos] = data;
        size++;
    }

    private void resize(){
        T[] newArray = (T[]) new Object[real_size + 50];
        real_size += 50;
        newArray = Arrays.copyOf(elements, size);
        elements = newArray;
    }

    public Iterator<T> iterator() {
        return new Iterator<T>() {
            int i=0;
            @Override public boolean hasNext() {
                return i < size;
            }

            @Override public T next() {
                return elements[i++];
            }
        };
    }
}
