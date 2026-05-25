package day01.practice.variables_and_types;

public class Practice03 {
    /*
      ZADANIE 3 (typ int): Napisz metodę:
      public static int square(int number)
      która:
      przyjmuje liczbę,
      zwraca jej kwadrat.
      Następnie wywołaj metodę dla liczby 6 i wypisz wynik.
  */
    public static void main(String[] args) {
        int number = 6;
        int result = square(number);
        int result2 = square02(number);
        System.out.println("Wynik nr 1: " + result);
        System.out.println("Wynik nr 2: " + result2);
    }

    // metoda ma zwrócić int wiec nie może być void
    public static int square(int a) {
        return a * a;
    }

    public static int square02 (int b) {
        int result = b * b;
        return result;
    }

}
