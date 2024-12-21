package DS_Programs;

import java.util.ArrayList;

class QueueNode {
    int data;
    QueueNode next;

    QueueNode(int data) {
        this.data = data;
        this.next = null;
    }
}

class Queue {
    private QueueNode front, rear;

    public void enqueue(int data) {
        QueueNode node = new QueueNode(data);
        if (rear == null) {
            front = rear = node;
            return;
        }
        rear.next = node;
        rear = node;
    }

    public int dequeue() {
        if (front == null) throw new RuntimeException("Queue underflow");
        int data = front.data;
        front = front.next;
        if (front == null) rear = null;
        return data;
    }

    public boolean isEmpty() {
        return front == null;
    }
}

public class QueueAnagrams {
    public static void main(String[] args) {
        Queue queue = new Queue();
        ArrayList<Integer> anagrams = PrimeAnagrams.getAnagrams();

        for (int num : anagrams) queue.enqueue(num);

        System.out.println("Anagrams in order:");
        while (!queue.isEmpty()) {
            System.out.print(queue.dequeue() + " ");
        }
    }
}
