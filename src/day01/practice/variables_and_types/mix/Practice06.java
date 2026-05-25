package day01.practice.variables_and_types.mix;

public class Practice06 {
    /*
     * Zadanie 6 — najczęstszy znak
     *
     * Dla tekstu:
     * String text = "abrakadabra";
     *
     * Znajdź znak, który występuje najczęściej,
     * oraz wypisz liczbę jego wystąpień.
     *
     * Oczekiwany wynik:
     * a -> 5
     */
    static void main(String[] args) {
        mostCommonChar("abrakadabra");
    }


    static void mostCommonChar(String text) {

        char mostCommon = text.charAt(0);
        int maxCounter = 0;

        for (int i = 0; i < text.length(); i++) {

            int counter = 0;

            for (int j = 0; j < text.length(); j++) {

                if (text.charAt(i) == text.charAt(j)) {
                    counter ++;
                }
            }

            if (counter > maxCounter) {
                maxCounter = counter;
                mostCommon = text.charAt(i);
            }
        }
        System.out.println(mostCommon + " -> " + maxCounter);
    }
}
