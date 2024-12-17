package DS_Programs;

import java.util.LinkedList;

public class HashingFunction<T> {
    private LinkedList<T>[] hashTable;

    // Constructor to initialize hash table
    public HashingFunction(int size) {
        hashTable = new LinkedList[size];
        for (int i = 0; i < size; i++) {
            hashTable[i] = new LinkedList<>();
        }
    }

    // Hash function to calculate slot
    private int hash(T value) {
        return Math.abs(value.hashCode()) % hashTable.length;
    }

    // Add a value to the hash table
    public void add(T value) {
        int slot = hash(value);
        if (!hashTable[slot].contains(value)) {
            hashTable[slot].add(value);
        }
    }

    // Search for a value
    public boolean search(T value) {
        int slot = hash(value);
        return hashTable[slot].contains(value);
    }

    // Remove a value
    public void remove(T value) {
        int slot = hash(value);
        hashTable[slot].remove(value);
    }

    // Display the hash table
    public void display() {
        for (int i = 0; i < hashTable.length; i++) {
            System.out.println("Slot " + i + ": " + hashTable[i]);
        }
    }

    public static void main(String[] args) {
        HashingFunction<Integer> hashFunction = new HashingFunction<>(10);

        hashFunction.add(10);
        hashFunction.add(20);
        hashFunction.add(30);
        hashFunction.add(40);
        hashFunction.add(50);

        System.out.println("Hash Table:");
        hashFunction.display();

        System.out.println("Search 30: " + hashFunction.search(30));
        System.out.println("Remove 30.");
        hashFunction.remove(30);
        System.out.println("Search 30: " + hashFunction.search(30));
    }
}
