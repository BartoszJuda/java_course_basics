package day01.practice.variables_and_types.mix;

public class Practice04 {
    /*
     * Zadanie 4 — Tablice
     *
     * Program ma:
     * - wypisać liczby z tablicy,
     * - policzyć sumę,
     * - znaleźć największą i najmniejszą liczbę,
     * - policzyć ile razy występuje 7.
     */
    static void main(String[] args) {
        int[] numbers = {1, 4, 6, 7, 88, 5, 7, 1, 2, 90, 43};

        int sum = 0;
        int maxNumber = numbers[0];
        int minNumber = numbers[0];
        int sevenCounter = 0;

        for (int i = 0; i < numbers.length; i++) {
            System.out.println(numbers[i]);

            //suma:
            sum += numbers[i];

            //sprawdzanie max i min:
            if (numbers[i] > maxNumber) {
                maxNumber = numbers[i];
            }

            if (numbers[i] < minNumber) {
                minNumber = numbers[i];
            }

            if (numbers[i] == 7) {
                sevenCounter++;
            }
        }

        System.out.println("Najwiękza liczba: " + maxNumber);
        System.out.println("Najmniejsza liczba: " + minNumber);
        System.out.println("Ilosć wystąpień numeru 7: " + sevenCounter);
    }
}
