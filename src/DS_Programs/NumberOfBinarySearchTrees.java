package DS_Programs;

import java.util.Scanner;

public class NumberOfBinarySearchTrees {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of nodes: ");
        int n = scanner.nextInt();
        System.out.println("Number of BSTs: " + numberOfBST(n));
        scanner.close();
    }

    public static long numberOfBST(int n) {
        long[] catalan = new long[n + 1];
        catalan[0] = 1;
        catalan[1] = 1;

        for (int i = 2; i <= n; i++) {
            catalan[i] = 0;
            for (int j = 0; j < i; j++) {
                catalan[i] += catalan[j] * catalan[i - j - 1];
            }
        }
        return catalan[n];
    }
}
