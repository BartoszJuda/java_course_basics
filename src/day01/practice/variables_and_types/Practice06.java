package day01.practice.variables_and_types;

public class Practice06 {
    /*
    ZADANIE 6 (typ char): Utwórz zmienną przechowującą
    pierwszą literę imienia.
    */
    public static void main(String[] args) {
        String name = "Bartosz"; //B to index = 0
        char firstLetter = name.charAt(0);
        System.out.println("Pierwsza litera imienia to: " + firstLetter);
    }
}
