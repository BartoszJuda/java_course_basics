package day01.practice.variables_and_types.loops;

public class Practice04 {
    /*
     * Zadanie 4 — FizzBuzz
     *
     * Dla liczb od 1 do 30:
     * - wypisz Fizz dla liczb podzielnych przez 3,
     * - Buzz dla podzielnych przez 5,
     * - FizzBuzz dla podzielnych przez oba.
     */
    static void main(String[] args) {
        //fizzBuzz();
        checkNumber(30);
    }

    static void fizzBuzz() {
        for (int i = 1; i <= 30; i++) {
            if (i % 15 == 0) {
                System.out.println(i + " - FizzBuzz");
            } else if (i % 3 == 0) {
                System.out.println(i + " - Fizz");
            } else if (i % 5 == 0) {
                System.out.println(i + " -Buzz");
            } else {
                System.out.println(i + " - To nie jest FizzBuzz");
            }
        }
    }

    static void checkNumber(int a) {
        for (int i = 1; i <= a; i++) {
            boolean isDividedBy3 = isDividedBy3(i);

            boolean isDividedBy5 = isDividedBy5(i);

            if (isDividedBy3) {
                System.out.println("Fizz");
            }
            if (isDividedBy5) {
                System.out.println("Buzz");
            }
            if (isDividedBy3 && isDividedBy5) {
                System.out.println("Fizz Buzz");
            }
        }
    }

    private static boolean isDividedBy3(int a) {
        return (a % 3) == 0;
    }

    private static boolean isDividedBy5(int a) {
        return (a % 5) == 0;
    }

}
