package day01.practice.variables_and_types.mix;

public class Practice10 {
    /*
     * Zadanie 10 — średnia z tablicy
     *
     * Dla tablicy:
     * int[] numbers = {5, 10, 15, 20};
     *
     * Policz średnią arytmetyczną jako double.
     *
     * Wskazówka:
     * - najpierw policz sumę,
     * - potem podziel przez numbers.length,
     * - użyj rzutowania na double.
     */
    static void main(String[] args) {
        calculateAvg();
    }

    static void calculateAvg(){
        int[] numbers = {5, 10, 15, 20, 40, 32, 21};

        int sum = 0;

        for (int n : numbers) {
            sum += n;
        }

        double average = (double) sum / numbers.length;

        System.out.println("Średnia wynosi: " + average);
    }
}
