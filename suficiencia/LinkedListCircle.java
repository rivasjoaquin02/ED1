package suficiencia;

public class LinkedListCircle {

    protected Node head;
    protected int size=0;

    public LinkedListCircle() {}
    public void add(int data){
        if (head == null) {
            head = new Node(data);
            size++;
            return;
        }
        if (size == 1)
            head.next = head;

        Node trav = head;
        while (trav.next != head)
            trav = trav.next;

        trav.next = new Node(data, head);
        size++;
    }

    // move head to node equal to data
    public void modeHead(int data){
        Node trav = head;
        for (int i = 0; i < size; i++) {
            if (trav.data == data) {
                head = trav;
                return;
            }
            trav = trav.next;
        }
    }

    public static void main(String[] args) {
        LinkedListCircle list = new LinkedListCircle();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        list.modeHead(3);
        System.out.println(list);
    }
}
