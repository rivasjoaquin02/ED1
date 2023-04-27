import java.util.Arrays;
import java.util.Iterator;

public class TDA_Lista<T> implements ILista <T>, Iterable <T> {

    private int length = 50;
    private int count = 0;
    public T[] elements;

    public TDA_Lista() {
        elements = (T[]) new Object[length];
    }

    public int length() {return count;}

    public void append(T value) {
        if (count + 1 > length)
            resize();
        elements[count++] = value;
    }

    public void insert(int pos, T value) {
        if (count +1 > length)
            resize();

        for (int i=count+1; i > pos; i--)
            elements[i] = elements[i-1];

        elements[pos] = value;
    }

    public void insertOrder(T value){
        int pos = Arrays.binarySearch(elements, value);
        insert(pos, value);
    }

    public void remove(T value) {
        if (!contains(value)) return;

        for (int i=0; i<count; i++){
            if (elements[i].equals(value)){
                for (int j=i; j<count-1; j++)
                    elements[i] = elements[i-1];
            }
        }
    }

    public boolean contains(T value) {
        for (int i=0; i<count; i++)
            if (elements[i].equals(value))
                return true;
        return false;
    }

    private void resize() {
        T[] newElements = (T[]) new Object[length + 50];
        length += 50;

        System.arraycopy(elements, 0, newElements, 0, length);
        elements = newElements;
    }

    @Override public Iterator iterator() {
        return new Iterator() {
            int pos = count-1;

            public boolean hasNext() {return pos >= 0;}
            public T next() {return elements[pos-=2];}
        };
    }
}

