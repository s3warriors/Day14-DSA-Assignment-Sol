package DS_Programs;

import java.io.*;
import java.util.LinkedList;

public class OrderedList<T extends Comparable<T>> {
    private LinkedList<T> list = new LinkedList<>();

    // Add an element to the list in sorted order
    public void add(T data) {
        if (list.isEmpty()) {
            list.add(data);
        } else {
            int i = 0;
            while (i < list.size() && list.get(i).compareTo(data) < 0) {
                i++;
            }
            list.add(i, data);
        }
    }

    // Remove an element from the list
    public void remove(T data) {
        list.remove(data);
    }

    // Search for an element
    public boolean search(T data) {
        return list.contains(data);
    }

    // Display the list
    public void display() {
        for (T item : list) {
            System.out.print(item + " ");
        }
        System.out.println();
    }

    // Load numbers from a file
    public void loadFromFile(String filename) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(filename));
        String line = br.readLine();
        br.close();
        for (String item : line.split(" ")) {
            add((T) (Comparable) Integer.parseInt(item));
        }
    }

    // Save the list to a file
    public void saveToFile(String filename) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(filename));
        for (T item : list) {
            bw.write(item.toString() + " ");
        }
        bw.close();
    }

    public static void main(String[] args) throws IOException {
        OrderedList<Integer> orderedList = new OrderedList<>();

        // Load data from file
        orderedList.loadFromFile("C:\\Users\\satve\\IdeaProjects\\Day14-DSA-Assignment-Sol\\src\\DS_Programs\\numbers");

        // Display current list
        System.out.println("Current List:");
        orderedList.display();

        // Search and modify the list
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter a number to search:");
        int searchNum = Integer.parseInt(input.readLine());

        if (orderedList.search(searchNum)) {
            orderedList.remove(searchNum);
            System.out.println("Number found and removed.");
        } else {
            orderedList.add(searchNum);
            System.out.println("Number not found, added to the list.");
        }

        // Save updated list back to file
        orderedList.saveToFile("output_numbers.txt");

        System.out.println("Updated List:");
        orderedList.display();
    }
}


