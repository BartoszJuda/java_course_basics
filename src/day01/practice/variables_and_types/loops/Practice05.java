package day01.practice.variables_and_types.loops;

public class Practice05 {

    /*
     * Zadanie 5 — while
     *
     * Program ma:
     * - wypisać liczby od 20 do 1,
     * - policzyć sumę liczb parzystych i nieparzystych.
     */
    static void main(String[] args) {
        calculateSums();
    }

    static void calculateSums() {
        int loopCounter = 20;
        int evenSum = 0;
        int oddSum = 0;

        while (loopCounter >= 1) {
            System.out.println(loopCounter);

            if (loopCounter % 2 == 0) {
                evenSum += loopCounter;
            } else {
                oddSum += loopCounter;
            }
            loopCounter--;
        }
        System.out.println("Suma liczb parzystych = " + evenSum);
        System.out.println("Suma liczb nieparzystych = " + oddSum);
    }
}
