package day01.practice.variables_and_types.mix;

public class Practice03 {
    /*
     * Zadanie 3 — Samogłoski
     *
     * Program ma:
     * - zadeklarować dowolny tekst
     * - wypisać każdą literę tekstu,
     * - policzyć samogłoski,
     * - policzyć spółgłoski.
     * - samogłoski : aeiouyóąę
     */
    static void main(String[] args) {
        checkLetters("aaaaaa");
    }

    static void checkLetters(String word) {
        int vovelCounter = 0;
        int consonantCounter = 0;

        for (char c : word.toCharArray()) {
            System.out.println(c);

            if ("aeiouyóąę".contains(String.valueOf(c))) {
                vovelCounter++;
            } else {
                consonantCounter++;
            }
        }

        System.out.println("Liczba spółglosek: " + consonantCounter);
        System.out.println("Liczba samogłosek: " + vovelCounter);
    }
}
