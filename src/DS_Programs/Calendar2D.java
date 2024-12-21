package DS_Programs;

import java.util.Calendar;

public class Calendar2D {
    public static void main(String[] args) {
        int month = 12; // December (1-12)
        int year = 2024; // Any year

        String[][] calendar = generateCalendar(month, year);
        System.out.println("S  M  T  W  T  F  S");
        for (String[] week : calendar) {
            for (String day : week) {
                System.out.print((day == null ? "   " : day + " "));
            }
            System.out.println();
        }
    }

    public static String[][] generateCalendar(int month, int year) {
        String[][] calendar = new String[6][7];
        Calendar cal = Calendar.getInstance();
        cal.set(year, month - 1, 1);

        int firstDay = cal.get(Calendar.DAY_OF_WEEK) - 1;
        int daysInMonth = cal.getActualMaximum(Calendar.DAY_OF_MONTH);

        int row = 0, col = firstDay;
        for (int date = 1; date <= daysInMonth; date++) {
            calendar[row][col] = String.format("%2d", date);
            col++;
            if (col == 7) {
                col = 0;
                row++;
            }
        }
        return calendar;
    }
}
