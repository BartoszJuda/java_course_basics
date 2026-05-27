package day03.date_examples;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class DatesInZones {
    static void main(String[] args) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("YYYY-MM-dd HH:mm:ss");

        ZonedDateTime warsawDateTime = ZonedDateTime.now(ZoneId.of("Europe/Warsaw"));
        String warsawLocalDate = warsawDateTime.format(formatter);

        ZonedDateTime nyDateTime = ZonedDateTime.now(ZoneId.of("America/New_York"));
        String nyLocalDate = nyDateTime.format(formatter);

        ZonedDateTime tokyoDateTime = ZonedDateTime.now(ZoneId.of("Asia/Tokyo"));
        String tokyoLocalDate = tokyoDateTime.format(formatter);

        System.out.println("Czas warszawski: " + warsawLocalDate);
        System.out.println("Czas w Nowym Jorku: " + nyLocalDate);
        System.out.println("Czas w Tokio: " + tokyoLocalDate);
    }

}
