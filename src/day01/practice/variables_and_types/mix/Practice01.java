package day01.practice.variables_and_types.mix;

public class Practice01 {
    /*
     * ZADANIE 1 — Budowanie tekstu
     *
     * Dla liczb od 1 do 50:
     * - dopisz A jeśli liczba podzielna przez 2,
     * - B jeśli przez 3,
     * - C jeśli przez 5,
     * - jeśli żaden warunek nie pasuje, wypisz liczbę.
     */
    static void main(String[] args) {
        buildText();
    }

    static void buildText() {
        for (int i = 1; i <= 50; i++) {
            String phrase = "";

            if (i % 2 == 0) {
                phrase += "A";
            }

            if (i % 3 == 0) {
                phrase += "B";
            }

            if (i % 5 == 0) {
                phrase += "C";
            }

            if (phrase.equals("")) {
                phrase = String.valueOf(i);
            }

            System.out.println(i + " -> " + phrase);
        }
    }
}
