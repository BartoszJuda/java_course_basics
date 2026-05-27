package day03.messaging;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Wybierz język:");
        System.out.println("1. Polski");
        System.out.println("2. Angielski");
        System.out.println("> ");

        String choice = sc.nextLine();

        Locale locale;

        if (choice.equals("2")) {
            locale = Locale.ENGLISH;
        } else {
            locale = new Locale("pl", "PL");
        }

        NotesApp app = new NotesApp(locale);
        app.start();
    }
}
