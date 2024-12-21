package DS_Programs;

import java.util.ArrayList;

public class PrimeNumbersInRange {
    public static void main(String[] args) {
        int[][] primeNumbers = getPrimeNumbers();
        for (int i = 0; i < primeNumbers.length; i++) {
            System.out.println("Range " + (i * 100) + "-" + ((i + 1) * 100 - 1) + ":");
            for (int prime : primeNumbers[i]) {
                System.out.print(prime + " ");
            }
            System.out.println();
        }
    }

    public static int[][] getPrimeNumbers() {
        ArrayList<ArrayList<Integer>> primes = new ArrayList<>();
        for (int i = 0; i < 10; i++) primes.add(new ArrayList<>());

        for (int num = 2; num < 1000; num++) {
            if (isPrime(num)) {
                primes.get(num / 100).add(num);
            }
        }

        int[][] primeArray = new int[10][];
        for (int i = 0; i < primes.size(); i++) {
            primeArray[i] = primes.get(i).stream().mapToInt(Integer::intValue).toArray();
        }
        return primeArray;
    }

    public static boolean isPrime(int num) {
        if (num < 2) return false;
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
}
