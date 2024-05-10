package chap03.p8;

import java.time.LocalDateTime;

public class Formatter {
    public static String formatLocalDateTime(LocalDateTime localDateTime) {
        return localDateTime.getYear() + "년 " + localDateTime.getDayOfMonth() + "월 " +localDateTime.getDayOfMonth() + "일";
    }
}
