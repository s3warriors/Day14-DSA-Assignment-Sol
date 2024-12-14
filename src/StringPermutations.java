import java.util.ArrayList;
import java.util.List;
public class StringPermutations {
    // Recursive function to generate permutations
    public static void generatePermutationsRecursive(String str, String prefix, List<String> result) {
        if (str.isEmpty()) {
            result.add(prefix);
            return;
        }
        for (int i = 0; i < str.length(); i++) {
            String rem = str.substring(0, i) + str.substring(i + 1);
            generatePermutationsRecursive(rem, prefix + str.charAt(i), result);
        }
    }

    // Iterative function to generate permutations
    public static List<String> generatePermutationsIterative(String str) {
        List<String> permutations = new ArrayList<>();
        permutations.add("");

        for (char ch : str.toCharArray()) {
            List<String> newPermutations = new ArrayList<>();
            for (String perm : permutations) {
                for (int i = 0; i <= perm.length(); i++) {
                    newPermutations.add(perm.substring(0, i) + ch + perm.substring(i));
                }
            }
            permutations = newPermutations;
        }
        return permutations;
    }

    public static void main(String[] args) {
        String input = "abc";

        // Recursive Method
        List<String> recursiveResult = new ArrayList<>();
        generatePermutationsRecursive(input, "", recursiveResult);
        System.out.println("Permutations (Recursive): " + recursiveResult);

        // Iterative Method
        List<String> iterativeResult = generatePermutationsIterative(input);
        System.out.println("Permutations (Iterative): " + iterativeResult);

        // Check if both methods return the same result
        System.out.println("Are results equal? " + recursiveResult.equals(iterativeResult));
    }
}


