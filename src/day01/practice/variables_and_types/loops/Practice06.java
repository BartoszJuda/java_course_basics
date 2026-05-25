package day01.practice.variables_and_types.loops;

public class Practice06 {
    /*
     * Zadanie 6 — sortowanie tablicy
     *
     * Dla tablicy:
     * int[] numbers = {5, 2, 9, 1, 7};
     *
     * Posortuj tablicę rosnąco bez używania Arrays.sort().
     *
     * Oczekiwany wynik:
     * 1
     * 2
     * 5
     * 7
     * 9
     *
     * Wskazówka:
     * Możesz użyć sortowania bąbelkowego.
     */
    static void main(String[] args) {
        sortNumbers();
    }

    static void sortNumbers() {
        int[] numbers = {5, 2, 9, 1, 7};

        for (int i = 0; i < numbers.length; i++) {

            for (int j = 0; j < numbers.length -1; j++) {
                if (numbers[j] > numbers[j + 1]) {

                    int temporary = numbers[j];
                    numbers[j] = numbers[j + 1];
                    numbers[j + 1] = temporary;
                }
            }
        }
        for (int number : numbers) {
            System.out.println(number);
        }
    }
}
