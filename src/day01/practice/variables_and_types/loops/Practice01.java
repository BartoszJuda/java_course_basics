package day01.practice.variables_and_types.loops;

public class Practice01 {
    /*
     * ZADANIE 1 — Liczby parzyste i nieparzyste
     *
     * Program ma:
     * - wypisać liczby od 1 do 20,
     * - określić czy są parzyste lub nieparzyste,
     * - policzyć ilość parzystych i nieparzystych.
     */
    static void main(String[] args) {
        calculateEvenAndOddNumbers();
    }

    static void calculateEvenAndOddNumbers(){
        int evenCounter = 0;
        int oddCounter = 0;

        for (int i = 1; i <= 20; i++) {
            //System.out.println(i);

            if (i % 2 == 0) {
                System.out.println("Liczba " + i + " PARZYSTA");
                evenCounter++;
            } else {
                System.out.println("Liczba " + i + " NIEPARZYSTA");
                oddCounter++;
            }
        }
        System.out.println("Ilość liczb parzystych: " + evenCounter);
        System.out.println("Ilość liczb nieparzystych: " + oddCounter);
    }
}
