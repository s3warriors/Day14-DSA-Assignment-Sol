package DS_Programs;

import java.util.ArrayList;

class StackNode {
    int data;
    StackNode next;

    StackNode(int data) {
        this.data = data;
        this.next = null;
    }
}

class Stack {
    private StackNode top;

    public void push(int data) {
        StackNode node = new StackNode(data);
        node.next = top;
        top = node;
    }

    public int pop() {
        if (top == null) throw new RuntimeException("Stack underflow");
        int data = top.data;
        top = top.next;
        return data;
    }

    public boolean isEmpty() {
        return top == null;
    }
}

public class StackAnagrams {
    public static void main(String[] args) {
        Stack stack = new Stack();
        ArrayList<Integer> anagrams = PrimeAnagrams.getAnagrams();

        for (int num : anagrams) stack.push(num);

        System.out.println("Anagrams in reverse order:");
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }
}
