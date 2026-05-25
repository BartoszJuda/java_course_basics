package day01.practice.variables_and_types.mix;

import java.util.Scanner;

public class Practice09 {
    /*
     * Zadanie 9 — palindrom tekstowy
     *
     * Sprawdź, czy wprowadzony tekst:
     *
     *
     * jest palindromem.
     *
     * Palindrom to tekst, który czytany od lewej i prawej strony
     * wygląda tak samo.
     *
     * Przykłady palindromów:
     * - kajak
     * - ala
     * - radar
     */
    static void main(String[] args) {
        checkIsPalindrome();
    }

    static void checkIsPalindrome() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Wprowadź słowo do sprawdzenia czy jest palindromem:");
        String word =  scanner.nextLine();

        String trimmedWord = word.replaceAll("\\s+", "");

        String reversedWord = "";

        for (int i = trimmedWord.length() -1; i >= 0; i--) {
            reversedWord += trimmedWord.charAt(i);
        }

        if (word.equals(reversedWord)) {
            System.out.println("Wprowadzony wyraz jest palindromem");
        } else {
            System.out.println("Wprowadzony wyraz nie jest palindromem");
        }
    }
}
