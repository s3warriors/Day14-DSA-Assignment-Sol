package DS_Programs;

import java.util.*;

public class PrimeAnagram2D {
    public static boolean isPrime(int num) {
        if (num <= 1) return false;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }

    public static boolean areAnagrams(String str1, String str2) {
        char[] arr1 = str1.toCharArray();
        char[] arr2 = str2.toCharArray();
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        return Arrays.equals(arr1, arr2);
    }

    public static void main(String[] args) {
        List<Integer> primes = new ArrayList<>();
        for (int i = 2; i < 1000; i++) {
            if (isPrime(i)) primes.add(i);
        }

        // Find prime anagrams
        List<int[]> anagrams = new ArrayList<>();
        for (int i = 0; i < primes.size(); i++) {
            for (int j = i + 1; j < primes.size(); j++) {
                if (areAnagrams(String.valueOf(primes.get(i)), String.valueOf(primes.get(j)))) {
                    anagrams.add(new int[]{primes.get(i), primes.get(j)});
                }
            }
        }

        // Display prime anagrams in pairs
        System.out.println("Prime Anagrams:");
        for (int[] pair : anagrams) {
            System.out.println(Arrays.toString(pair));
        }
    }
}
