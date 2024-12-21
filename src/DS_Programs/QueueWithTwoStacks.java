package DS_Programs;

import java.util.ArrayList;
import java.util.LinkedList;

class Stack2 {
    private LinkedList<Integer> stack = new LinkedList<>();

    public void push(int data) {
        stack.addFirst(data);
    }

    public int pop() {
        if (stack.isEmpty()) throw new RuntimeException("Stack underflow");
        return stack.removeFirst();
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }
}

class QueueUsingTwoStacks {
    private Stack2 stack1 = new Stack2();
    private Stack2 stack2 = new Stack2();

    public void enqueue(int data) {
        stack1.push(data);
    }

    public int dequeue() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        if (stack2.isEmpty()) throw new RuntimeException("Queue underflow");
        return stack2.pop();
    }
}

public class QueueWithTwoStacks {
    public static void main(String[] args) {
        QueueUsingTwoStacks queue = new QueueUsingTwoStacks();
        ArrayList<Integer> anagrams = PrimeAnagrams.getAnagrams();

        for (int num : anagrams) queue.enqueue(num);

        System.out.println("Anagrams:");
        while (true) {
            try {
                System.out.print(queue.dequeue() + " ");
            } catch (RuntimeException e) {
                break;
            }
        }
    }
}
