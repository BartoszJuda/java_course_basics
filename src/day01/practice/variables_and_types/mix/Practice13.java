package day01.practice.variables_and_types.mix;

public class Practice13 {

    /*
     * Zadanie 13 — sprawdzanie anagramów
     *
     * Dla tekstów:
     * String first = "listen";
     * String second = "silent";
     *
     * Sprawdź, czy teksty są anagramami.
     *
     * Anagramy mają te same litery, tylko w innej kolejności.
     *
     * Oczekiwany wynik:
     * true
     *
     * Nie używaj Arrays.sort().
     */
    static void main(String[] args) {
        String first = "listen";
        String second = "silent";

        areAnagrams(first, second);
    }

    static void areAnagrams(String first, String second) {

        boolean areAnagrams = true;

        if (first.length() != second.length()) {
            areAnagrams = false;
        } else {
            for (int i = 0; i < first.length(); i++) {

                char currentChar = first.charAt(i);
                int firstCounter = 0;
                int secondCounter = 0;

                for (int j = 0; j < first.length(); j++) {
                    if (first.charAt(j) == currentChar) {
                        firstCounter++;
                    }
                    if (second.charAt(j) == currentChar) {
                        secondCounter++;
                    }
                }

                if (firstCounter != secondCounter) {
                    areAnagrams = false;
                    break;
                }
            }
        }
        System.out.println("Czy słowa są anagramami: " + areAnagrams);
    }
}
