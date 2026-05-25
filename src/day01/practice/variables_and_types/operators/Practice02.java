package day01.practice.variables_and_types.operators;

public class Practice02 {
    /*
        ZADANIE 2: Napisz program, który:
        tworzy zmienną:
        int number = 7;
        sprawdza:
        jeśli liczba jest większa od 0 → wypisz "Liczba dodatnia"
        w przeciwnym razie → wypisz "Liczba niedodatnia"
    */
    static void main(String[] args) {
        int number = 1;
        String result = checkNumber(number);
        System.out.println(result);
    }

    static String checkNumber(int a) {
        if (a > 0) {
            return "Liczba dodatnia";
        } else {
            return "Liczba ujemna";
        }
    }
}
