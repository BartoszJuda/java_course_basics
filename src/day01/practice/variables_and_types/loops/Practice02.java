package day01.practice.variables_and_types.loops;

public class Practice02 {
    /*
        ZADANIE 2: Napisz program, który:
        tworzy tablicę:
        int[] numbers = {1, 2, 3, 4, 5};
        wypisuje wszystkie elementy tablicy używając pętli for.
        Napisz również wypisanie elementów w pętli for each
    */
    static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5};
        printNumbersUsingForLoop(numbers);
        printNumbersUsingForEachLoop(numbers);
    }

    static void printNumbersUsingForLoop(int[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            System.out.println(numbers[i]);
        }
    }

    static void printNumbersUsingForEachLoop(int[] numbers) {
        for (Integer number : numbers) {
            System.out.println(number);
        }
    }
}
