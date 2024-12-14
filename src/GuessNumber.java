import java.util.Scanner;

public class GuessNumber {
    public static void guessNumber(int low, int high, Scanner scanner) {
        if (low == high) {
            System.out.println("Your number is " + low);
            return;
        }

        int mid = (low + high) / 2;
        System.out.println("Is your number between " + low + " and " + mid + "? (yes/no)");
        String response = scanner.next();

        if (response.equalsIgnoreCase("yes")) {
            guessNumber(low, mid, scanner);
        } else {
            guessNumber(mid + 1, high, scanner);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Think of a number between 0 and 15.");
        guessNumber(0, 15, scanner);
    }
}
