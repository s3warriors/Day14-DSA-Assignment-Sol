package DS_Programs;

import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;

public class CalendarProgram {
    public static void printCalendar(int year, int month) {
        LocalDate date = LocalDate.of(year, month, 1);
        int daysInMonth = date.lengthOfMonth();
        int dayOfWeek = date.getDayOfWeek().getValue(); // 1 = Monday, 7 = Sunday

        System.out.println("Calendar for " + date.getMonth().getDisplayName(TextStyle.FULL, Locale.ENGLISH) + " " + year);
        System.out.println("Sun Mon Tue Wed Thu Fri Sat");

        // Print leading spaces
        for (int i = 1; i < dayOfWeek; i++) {
            System.out.print("    ");
        }

        // Print days
        for (int day = 1; day <= daysInMonth; day++) {
            System.out.printf("%3d ", day);
            if ((day + dayOfWeek - 1) % 7 == 0) {
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        java.util.Scanner sc = new java.util.Scanner(System.in);
        System.out.println("Enter year:");
        int year = sc.nextInt();
        System.out.println("Enter month (1-12):");
        int month = sc.nextInt();

        printCalendar(year, month);
    }
}
