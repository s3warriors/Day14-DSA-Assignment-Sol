import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class BinarySearchWord {
    public static void main(String[] args) throws IOException {
        // Read the words from the file
        BufferedReader br = new BufferedReader(new FileReader("words.txt"));
        String line = br.readLine();
        String[] words = line.split(",");
        br.close();

        // Sort the words
        Arrays.sort(words);

        // Get the word to search
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the word to search:");
        String word = scanner.nextLine();

        // Perform binary search
        int result = Arrays.binarySearch(words, word);
        if (result >= 0) {
            System.out.println("Word found at position " + result);
        } else {
            System.out.println("Word not found.");
        }
    }
}
