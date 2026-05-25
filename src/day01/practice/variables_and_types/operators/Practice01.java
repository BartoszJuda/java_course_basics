package day01.practice.variables_and_types.operators;

public class Practice01 {
    /*
    ZADANIE 1: Napisz program, który:
    tworzy dwie zmienne:
    int a = 10;
    int b = 5;
    wypisuje: sumę, różnicę, iloczyn, iloraz.
    Przykład wyniku:
    Suma: 15
    Różnica: 5
    Iloczyn: 50
    Iloraz: 2
 */
    public static void main (String[] args) {
        int number1 = 23;
        int number2 = 43;
        //calculate(number1, number2);
        calculate02(number1, number2, "^");
    }

    static void calculate (int a, int b) {
        //deklaracja wyników
        int sum = a + b;
        int diff = a - b;
        int product = a * b;
        int quotient = a / b;

        //wypisanie wyników:
        System.out.println("Suma:" + sum);
        System.out.println("Różnica: " + diff);
        System.out.println("Iloczyn: " + product);
        System.out.println("Iloraz: " + quotient);
    }

    static void calculate02 (int a, int b, String operation) {
        int result = 0;
        switch (operation) {
            case "+":
                System.out.println("Wybrałes dodawanie. Wynik to: " + (a +b));
                break;
            case "-":
                System.out.println("Wybrałes odejmowanie. Wynik to: " + (a-b));
                break;
            case "*":
                System.out.println("Wybrałeś mnozenie. Wynik to: " + (a * b));
                break;
            case "/":
                System.out.println("Wybrałes dzielenie. Wynik to: " + (a /b));
            default:
                System.out.println("Wprowadziłeś nieznany operator");
        }
    }
}
