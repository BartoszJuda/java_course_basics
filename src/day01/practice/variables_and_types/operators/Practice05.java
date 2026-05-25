package day01.practice.variables_and_types.operators;

public class Practice05 {
    /*
        * ZADANIE 5 — Operatory i pętle
        *
        * Program ma:
        * - zadeklarowac dowolny number
        * - sprawdzić czy liczba jest parzysta,
        * - sprawdzić czy jest podzielna przez 3,
        * - wypisać liczby od 1 do number,
        * - obliczyć ich sumę.
    */

    static void main(String[] args) {
        int nr = 12;
        checkNumber(nr);
    }

    static void checkNumber(int number) {

        //sprawdzamy czy liczba jest parzysta
        if (number % 2 == 0) {
            System.out.println("Liczba jest parzysta");
        }

        //sprawdzamy czy iczba jest podzeilan przez 3:
        if (number % 3 == 0) {
            System.out.println("Liczba jest podzielna przez 3");
        }

        int sum = 0;

        for (int i = 1; i <= number; i++) {
            System.out.println(i);
            sum += i;
        }
        System.out.println("Suma: " + sum);
    }
}
