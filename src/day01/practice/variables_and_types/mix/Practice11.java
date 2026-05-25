package day01.practice.variables_and_types.mix;

public class Practice11 {/*
    * Zadanie 11 — zliczanie liter
    *
    * Dla tekstu:
    * String text = "programowanie";
    *
    * Policz, ile razy występuje każda litera.
    *
    * Każdą literę wypisz tylko raz.
    *
    * Przykładowy format:
    * p -> 1
    * r -> 2
    * o -> 2
    */

    static void main(String[] args) {
        checkCharNumber("Najczestszy");
    }

    static void checkCharNumber(String text) {
        for (int i = 0; i < text.length(); i++) {

            char currentChar = text.charAt(i);
            int counter = 0;
            boolean wasPrinted = false;

            for (int j = 0; j < i; j++) {
                if (text.charAt(j) == currentChar) {
                    wasPrinted = true;
                    break;
                }
            }

            if (wasPrinted) {
                continue;
            }
            for (int j = 0; j < text.length(); j++) {
                if (text.charAt(j) == currentChar) {
                    counter++;
                }
            }
            System.out.println(currentChar + "->" + counter);
        }
    }

}
