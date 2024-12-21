package DS_Programs;

import java.util.Calendar;
import java.util.LinkedList;

class WeekDay {
    String day;
    String date;

    WeekDay(String day, String date) {
        this.day = day;
        this.date = date;
    }
}

class Week {
    LinkedList<WeekDay> days;

    Week() {
        this.days = new LinkedList<>();
    }

    void addDay(WeekDay weekDay) {
        days.add(weekDay);
    }
}

class CalendarQueue {
    public static void main(String[] args) {
        int month = 12;
        int year = 2024;

        Week[] weeks = generateWeeks(month, year);
        for (Week week : weeks) {
            if (week == null) continue;
            for (WeekDay day : week.days) {
                System.out.print(day.date + " ");
            }
            System.out.println();
        }
    }

    public static Week[] generateWeeks(int month, int year) {
        String[] weekDays = {"S", "M", "T", "W", "Th", "F", "S"};
        Calendar cal = Calendar.getInstance();
        cal.set(year, month - 1, 1);

        int firstDay = cal.get(Calendar.DAY_OF_WEEK) - 1;
        int daysInMonth = cal.getActualMaximum(Calendar.DAY_OF_MONTH);

        Week[] weeks = new Week[6];
        for (int i = 0; i < 6; i++) weeks[i] = new Week();

        int row = 0, col = firstDay;
        for (int date = 1; date <= daysInMonth; date++) {
            weeks[row].addDay(new WeekDay(weekDays[col], String.valueOf(date)));
            col++;
            if (col == 7) {
                col = 0;
                row++;
            }
        }
        return weeks;
    }
}
