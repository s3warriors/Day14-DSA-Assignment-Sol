import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class TaskScheduling {

    // Class to represent a task with deadline and duration
    static class Task {
        int deadline;
        int duration;

        public Task(int deadline, int duration) {
            this.deadline = deadline;
            this.duration = duration;
        }
    }

    // Function to schedule tasks and minimize maximum deadline overshoot
    public static int[] minimizeOvershoot(Task[] tasks) {
        // Sort tasks by deadline in ascending order
        Arrays.sort(tasks, Comparator.comparingInt(task -> task.deadline));

        // To store the result: maximum overshoot for the first i tasks
        int[] overshootResults = new int[tasks.length];
        int currentTime = 0;
        int maxOvershoot = 0;

        for (int i = 0; i < tasks.length; i++) {
            // Add the current task's duration to the total time
            currentTime += tasks[i].duration;

            // Calculate the overshoot for the current task
            int overshoot = Math.max(0, currentTime - tasks[i].deadline);

            // Update the maximum overshoot encountered so far
            maxOvershoot = Math.max(maxOvershoot, overshoot);

            // Store the maximum overshoot after scheduling i+1 tasks
            overshootResults[i] = maxOvershoot;
        }

        return overshootResults;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input the number of tasks
        System.out.println("Enter the number of tasks:");
        int n = scanner.nextInt();

        Task[] tasks = new Task[n];

        // Input task deadlines and durations
        System.out.println("Enter deadline and duration for each task (D M):");
        for (int i = 0; i < n; i++) {
            int deadline = scanner.nextInt();
            int duration = scanner.nextInt();
            tasks[i] = new Task(deadline, duration);
        }

        // Get the overshoot results
        int[] overshootResults = minimizeOvershoot(tasks);

        // Output the results
        System.out.println("Maximum overshoot after scheduling tasks:");
        for (int i = 0; i < overshootResults.length; i++) {
            System.out.println("After " + (i + 1) + " tasks: " + overshootResults[i]);
        }
    }
}
