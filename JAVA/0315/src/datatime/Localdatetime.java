package datatime;

import java.time.*;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;

public class Localdatetime {
    public static void main(String[] args) {
        Localdatetime dt = new Localdatetime();
        dt.convert();
    }
    void test() {
        LocalDate nowDate = LocalDate.now();
        LocalTime nowTime = LocalTime.now();

        LocalDateTime now = LocalDateTime.of(nowDate, nowTime);
        LocalDateTime now2 = LocalDateTime.now();

        LocalDateTime dateTime = LocalDateTime.of(2022, 2, 14, 20, 30, 40);

        System.out.println(now);
        System.out.println(now2);
        System.out.println(now.equals(now2));
        System.out.println(dateTime);
    }

    void test2() {
        LocalDateTime dt = LocalDateTime.now();
        // 1초를 더하는 여러가지 방법
        LocalDateTime dt2 = dt.minus(1L, ChronoUnit.SECONDS);
        LocalDateTime dt3 = dt.minusSeconds(1L);
        LocalDateTime dt4 = dt.minus(Duration.ofSeconds(1));

        System.out.println(dt);
        System.out.println(dt2);
        System.out.println(dt3);
        System.out.println(dt4);
    }

    void convert() {
        Date date = new Date();
        Calendar cal = Calendar.getInstance();

        LocalDateTime dt1 = LocalDateTime.ofInstant(date.toInstant(), ZoneOffset.UTC);
        OffsetDateTime odt1 = OffsetDateTime.ofInstant(cal.toInstant(), ZoneId.systemDefault());
        ZonedDateTime zdt1 = ZonedDateTime.ofInstant(cal.toInstant(), ZoneId.systemDefault());

        System.out.println(date + " " + date.getTimezoneOffset());
        System.out.println(cal.getTime() + " " + cal.getTimeZone().getID());
        System.out.println(dt1);
        System.out.println(odt1);
        System.out.println(zdt1);
    }

}
