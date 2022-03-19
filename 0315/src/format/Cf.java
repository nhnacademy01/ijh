package format;

import java.text.ChoiceFormat;
import java.util.Date;

public class Cf {
    public static void main(String[] args) {
        Date date = new Date();

        System.out.println("date: " + date);
        System.out.println("year: " + date.getYear());
        System.out.println("month: " + date.getMonth());
        System.out.println("date: " + date.getDate());
        System.out.println("dayOfWeek: " + date.getDay());
        System.out.println("hours: " + date.getHours());
        System.out.println("minutes: " + date.getMinutes());
        System.out.println("seconds: " + date.getSeconds());

        System.out.println("date.after(new Date()): " + date.after(new Date()));
        System.out.println("date.before(new Date()): " + date.before(new Date()));
        System.out.println("date.getTime(): " + date.getTime());
        System.out.println("date.compareTo(new Date()): " + date.compareTo(new Date())); // Comparable
    }

    void season() {
        double[] monthScopres = {1,3,6,9,12};
        String[] seasons = {"겨울", "봄", "가을", "여름", "가을", "겨울"};
        ChoiceFormat gradesFormat = new ChoiceFormat(monthScopres, seasons);

        for (int i = 0; i <= 12; i++) {
            //System.out.println("%d월의 계절은 %s%n", i, gradesFormat.format(i));;
        }
    }

}
