package DS_Programs;

import java.util.*;

public class PrimeAnagrams {
    public static void main(String[] args) {
        int[][] primes = PrimeNumbersInRange.getPrimeNumbers();
        ArrayList<Integer> anagrams = new ArrayList<>();
        ArrayList<Integer> nonAnagrams = new ArrayList<>();

        for (int[] range : primes) {
            for (int prime : range) {
                if (isAnagram(prime, range)) {
                    anagrams.add(prime);
                } else {
                    nonAnagrams.add(prime);
                }
            }
        }

        System.out.println("Anagrams: " + anagrams);
        System.out.println("Non-Anagrams: " + nonAnagrams);
    }

    public static boolean isAnagram(int num, int[] range) {
        String str1 = String.valueOf(num);
        char[] arr1 = str1.toCharArray();
        Arrays.sort(arr1);

        for (int other : range) {
            if (num != other) {
                String str2 = String.valueOf(other);
                char[] arr2 = str2.toCharArray();
                Arrays.sort(arr2);
                if (Arrays.equals(arr1, arr2)) {
                    return true;
                }
            }
        }
        return false;
    }

    // Function to find all prime numbers that are anagrams
    public static ArrayList<Integer> getAnagrams() {
        int[][] primes = PrimeNumbersInRange.getPrimeNumbers();
        ArrayList<Integer> anagrams = new ArrayList<>();

        for (int[] range : primes) {
            for (int prime : range) {
                if (isAnagram(prime, range) && !anagrams.contains(prime)) {
                    anagrams.add(prime);
                }
            }
        }

        return anagrams;
    }
}
