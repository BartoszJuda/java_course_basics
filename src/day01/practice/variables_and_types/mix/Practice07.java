package day01.practice.variables_and_types.mix;

public class Practice07 {
    /*
     * Zadanie 7 — silnia
     *
     * Dla liczby:
     * int number = 5;
     *
     * Policz silnię.
     *
     * 5! = 1 * 2 * 3 * 4 * 5 = 120
     */
    static void main(String[] args) {
        calculateFactorial(5);
    }

    static void calculateFactorial(int number) {
        int a = 1;

        for (int i = 1; i <= number; i++) {
            a *= i;
        }
        System.out.println(a);
    }
}
