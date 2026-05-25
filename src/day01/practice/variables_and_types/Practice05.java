package day01.practice.variables_and_types;

public class Practice05 {
        /*
        ZADANIE 5 (typ boolean): Utwórz zmienną logiczną informującą,
        czy użytkownik jest pełnoletni. Wypisz czy użytkownik jest pełnoletni czy nie
        */
    public static void main (String[] args) {
        int age = 20;
        boolean isAdult = age >= 18;

        System.out.println("Czy użytkownik jest dorosły?: " + isAdult);
    }

    public static boolean isUserAdult (int age) {
        return age >= 18;
    }
}
