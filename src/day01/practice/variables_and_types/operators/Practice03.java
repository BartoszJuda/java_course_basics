package day01.practice.variables_and_types.operators;

public class Practice03 {
    /*
        ZADANIE 3: Sprawdź, która z dwóch liczb jest większa.
    */
    public static void main (String[] args) {
        int number1 = 4;
        int number2 = 4;
        compareNumbers(number1, number2);
    }

    static void compareNumbers(int a, int b) {
        if (a > b) {
            System.out.println("Liczba a jest większa");
        } else if (a < b) {
            System.out.println("Liczba b jest więskza");
        } else {
            System.out.println("Liczby są sobie równe");
        }
    }
}
