package DS_Programs;

public class CircularLinkedList<T> {
    private static class Node<T> {
        T data;
        Node<T> next;

        public Node(T data) {
            this.data = data;
        }
    }

    private Node<T> tail;

    // Add a node to the circular list
    public void add(T data) {
        Node<T> newNode = new Node<>(data);
        if (tail == null) {
            tail = newNode;
            tail.next = tail; // Points to itself to form a circular structure
        } else {
            newNode.next = tail.next;
            tail.next = newNode;
            tail = newNode; // Update the tail to the new node
        }
    }

    // Display the circular list
    public void display() {
        if (tail == null) return;

        Node<T> current = tail.next;
        do {
            System.out.print(current.data + " ");
            current = current.next;
        } while (current != tail.next);
        System.out.println();
    }

    public static void main(String[] args) {
        CircularLinkedList<Integer> list = new CircularLinkedList<>();
        
        list.add(10);
        list.add(20);
        list.add(30);
        
        System.out.println("Circular Linked List:");
        list.display();
    }
}
