package day01.practice.variables_and_types.mix;

public class Practice05 {

    /*
     * Zadanie 5 — duplikaty
     *
     * Dla tablicy:
     * int[] numbers = {1, 2, 2, 3, 4, 4, 5};
     *
     * Wypisz liczby, które występują więcej niż raz.
     *
     * Każdy duplikat wypisz tylko raz.
     *
     * Oczekiwany wynik:
     * 2
     * 4
     */

    static void main(String[] args) {
        int[] numbers = {1, 2, 2, 3, 4, 4, 5};

        for (int i = 0; i < numbers.length; i++) {

            int counter = 0;

            for (int j = 0; j < numbers.length; j++) {
                if (numbers[i] == numbers[j]) {
                    counter++;
                }
            }

            if (counter > 1) {

                boolean isAlreadyPrinted = false;

                for (int k = 0; k < i; k++) {
                    if (numbers[k] == numbers[i]) {
                        isAlreadyPrinted = true;
                        break;
                    }
                }
                if (!isAlreadyPrinted) {
                    System.out.println(numbers[i]);
                }
            }

        }
    }
}
