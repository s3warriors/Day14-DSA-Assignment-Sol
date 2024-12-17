package DS_Programs;

import java.util.Deque;
import java.util.LinkedList;

public class PalindromeChecker<T> {

    // Function to check if a string is a palindrome
    public boolean isPalindrome(String input) {
        Deque<Character> deque = new LinkedList<>();

        // Add characters to deque
        for (char ch : input.toCharArray()) {
            deque.addLast(ch);
        }

        // Check palindrome by comparing characters from front and rear
        while (deque.size() > 1) {
            if (deque.pollFirst() != deque.pollLast()) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        PalindromeChecker<Character> checker = new PalindromeChecker<>();

        System.out.println("Enter a string:");
        java.util.Scanner sc = new java.util.Scanner(System.in);
        String input = sc.nextLine();

        if (checker.isPalindrome(input)) {
            System.out.println("The string is a palindrome.");
        } else {
            System.out.println("The string is not a palindrome.");
        }
    }
}
