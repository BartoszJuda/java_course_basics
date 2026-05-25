package day01.practice.variables_and_types.scanner;

import java.util.Scanner;

public class Practice01 {

    /*
    ZADANIE 1: Napisz program, który:
    pobierze z konsoli tekst
    odwraca napis,
    wypisuje odwrócony tekst
    */
    static void main(String[] args) {
        reverseWord();
    }

    static void reverseWord() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj dowolny wyraz:");
        String word = scanner.nextLine();

        String reversedWord = "";

        for (int i = word.length() -1; i >= 0; i--) {
            reversedWord += word.charAt(i);
        }

        System.out.println("Odwrócony wyraz: " + reversedWord);
    }
}
