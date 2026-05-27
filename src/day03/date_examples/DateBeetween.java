package day03.date_examples;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class DateBeetween {

    static void main() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Wprowadź pierwszą datę w formacie RRRR-MM-DD");
        LocalDate date1 = LocalDate.parse(scanner.nextLine());
        System.out.println("Wprowadź drugą datę w formacie RRRR-MM-DD");
        LocalDate date2 = LocalDate.parse(scanner.nextLine());

        long days = ChronoUnit.DAYS.between(date1, date2);

        System.out.println("Ilość dni między datami wynosi:" + Math.abs(days));
    }
}
