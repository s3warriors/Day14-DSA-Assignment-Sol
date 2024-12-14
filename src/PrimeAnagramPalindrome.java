import java.util.ArrayList;
import java.util.Arrays;

public class PrimeAnagramPalindrome {

    // Check if a number is prime
    public static boolean isPrime(int n) {
        if (n <= 1) return false;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    // Check if a number is a palindrome
    public static boolean isPalindrome(int n) {
        String str = String.valueOf(n);
        String reversed = new StringBuilder(str).reverse().toString();
        return str.equals(reversed);
    }

    // Check if two numbers are anagrams
    public static boolean areAnagrams(int n1, int n2) {
        char[] arr1 = String.valueOf(n1).toCharArray();
        char[] arr2 = String.valueOf(n2).toCharArray();
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        return Arrays.equals(arr1, arr2);
    }

    public static void main(String[] args) {
        ArrayList<Integer> primes = new ArrayList<>();
        ArrayList<Integer> anagramPrimes = new ArrayList<>();
        ArrayList<Integer> palindromePrimes = new ArrayList<>();

        // Collect primes
        for (int i = 0; i <= 1000; i++) {
            if (isPrime(i)) primes.add(i);
        }

        // Check for anagrams
        for (int i = 0; i < primes.size(); i++) {
            for (int j = i + 1; j < primes.size(); j++) {
                if (areAnagrams(primes.get(i), primes.get(j))) {
                    anagramPrimes.add(primes.get(i));
                    anagramPrimes.add(primes.get(j));
                }
            }
        }

        // Check for palindromes
        for (int prime : primes) {
            if (isPalindrome(prime)) {
                palindromePrimes.add(prime);
            }
        }

        System.out.println("Primes: " + primes);
        System.out.println("Anagram Primes: " + anagramPrimes);
        System.out.println("Palindrome Primes: " + palindromePrimes);
    }
}
