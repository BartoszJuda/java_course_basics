package day01.practice.variables_and_types.mix;

public class Practice02 {

    /*
     * Zadanie 2 — Liczby pierwsze
     *
     * Program ma wypisać liczby od 1 do 50.
     * Jeśli liczba jest pierwsza, wypisuje obok niej PRIME.
     * Jeśli liczba nie jest pierwsza to wypisz liczbę
     */
    static void main(String[] args) {
        isPrime();
    }

    static void isPrime() {
        for (int i = 1; i <= 50; i++) {
            boolean isPrime = true;

            if (i <= 1) {
                isPrime = false;
            } else {
                //musimy sprawdzić czy i dzieli się przez liczbę od 2 do i-1
                for (int j = 2; j < i; j++) {
                    if (i % j == 0) {
                        isPrime = false;
                        break; //dalse sprawdzanie nie ma sensu
                    }
                }
            }
            if (isPrime) {
                System.out.println(i + " PRIME");
            } else {
                System.out.println(i);
            }
        }
    }
}
