package DS_Programs;

import java.util.EmptyStackException;

public class Stack<T> {
    private static class Node<T> {
        private T data;
        private Node<T> next;

        public Node(T data) {
            this.data = data;
        }
    }

    private Node<T> top;

    // Push an element onto the stack
    public void push(T data) {
        Node<T> node = new Node<>(data);
        node.next = top;
        top = node;
    }

    // Pop an element from the stack
    public T pop() {
        if (isEmpty()) throw new EmptyStackException();
        T data = top.data;
        top = top.next;
        return data;
    }

    // Peek the top element of the stack
    public T peek() {
        if (isEmpty()) throw new EmptyStackException();
        return top.data;
    }

    // Check if the stack is empty
    public boolean isEmpty() {
        return top == null;
    }

    // Display the stack
    public void display() {
        Node<T> current = top;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println("Stack contents:");
        stack.display();

        System.out.println("Popped element: " + stack.pop());
        System.out.println("Top element: " + stack.peek());

        System.out.println("Stack after pop:");
        stack.display();
    }
}
