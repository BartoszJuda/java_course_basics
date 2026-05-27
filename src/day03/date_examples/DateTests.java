package day03.date_examples;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateTests {

    static void main(String[] args) {
        LocalDateTime dateTime = LocalDateTime.now();
        //System.out.println("Data biezaca: " + dateTime);


        DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("YYYY-MM-dd");
        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("MM/dd/YYYY");
        DateTimeFormatter formatter3 = DateTimeFormatter.ofPattern("HH:mm:ss");
        System.out.println(dateTime.format(formatter1));
        System.out.println(dateTime.format(formatter2));
        System.out.println(dateTime.format(formatter3));
    }
}
