package day03.date_examples;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class CheckDate {
    static void main() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Wprowadź pierwszą datę w formacie RRRR-MM-DD");
        LocalDate date1 = LocalDate.parse(sc.nextLine());

        LocalDate now = LocalDate.now();

        long days = ChronoUnit.DAYS.between(now, date1);

        if (days > 0) {
            System.out.println("Do wydarzenia pozostało " + days + " dni");
        } else if (days == 0) {
            System.out.println("Wydarzenie wypada dzisiaj");
        } else {
            System.out.println("Wydarzenie sie już odbyło");
        }

    }
}
