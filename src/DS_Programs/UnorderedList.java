package DS_Programs;

import java.io.*;
import java.util.LinkedList;

public class UnorderedList<T> {
    private LinkedList<T> list = new LinkedList<>();

    // Add an element to the list
    public void add(T data) {
        list.add(data);
    }

    // Search for an element
    public boolean search(T data) {
        return list.contains(data);
    }

    // Remove an element from the list
    public void remove(T data) {
        list.remove(data);
    }

    // Save the list to a file
    public void saveToFile(String filename) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(filename));
        for (T item : list) {
            bw.write(item.toString() + " ");
        }
        bw.close();
    }

    // Load the list from a file
    public void loadFromFile(String filename) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(filename));
        String line = br.readLine();
        br.close();
        for (String item : line.split(" ")) {
            add((T) item);
        }
    }

    // Display the list
    public void display() {
        for (T item : list) {
            System.out.print(item + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) throws IOException {
        UnorderedList<String> unorderedList = new UnorderedList<>();

        // Load data from file
        unorderedList.loadFromFile("C:\\Users\\satve\\IdeaProjects\\Day14-DSA-Assignment-Sol\\src\\DS_Programs\\input");

        // Display current list
        System.out.println("Current List:");
        unorderedList.display();

        // Search and modify the list
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter a word to search:");
        String searchWord = input.readLine();

        if (unorderedList.search(searchWord)) {
            unorderedList.remove(searchWord);
            System.out.println("Word found and removed.");
        } else {
            unorderedList.add(searchWord);
            System.out.println("Word not found, added to the list.");
        }

        // Save updated list back to file
        unorderedList.saveToFile("output.txt");

        System.out.println("Updated List:");
        unorderedList.display();
    }
}


