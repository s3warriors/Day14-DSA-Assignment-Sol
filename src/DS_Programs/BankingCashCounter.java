package DS_Programs;

import java.util.LinkedList;
import java.util.Queue;

public class BankingCashCounter {
    private static int cashBalance = 10000; // Initial bank balance
    private Queue<Integer> queue = new LinkedList<>();

    // Add a person to the queue
    public void enqueue(int amount) {
        queue.add(amount);
    }

    // Process the queue (Deposit or Withdraw)
    public void processQueue() {
        while (!queue.isEmpty()) {
            int amount = queue.poll();
            if (amount > 0) {
                cashBalance += amount;
                System.out.println("Deposited: " + amount);
            } else {
                if (cashBalance + amount < 0) {
                    System.out.println("Withdrawal failed due to insufficient balance.");
                } else {
                    cashBalance += amount;
                    System.out.println("Withdrawn: " + Math.abs(amount));
                }
            }
            System.out.println("Current Cash Balance: " + cashBalance);
        }
    }

    public static void main(String[] args) {
        BankingCashCounter counter = new BankingCashCounter();

        counter.enqueue(500); // Deposit 500
        counter.enqueue(-1000); // Withdraw 1000
        counter.enqueue(2000); // Deposit 2000
        counter.enqueue(-1500); // Withdraw 1500

        counter.processQueue();
    }
}
