package day01.materials;

public class Variables {

    /*
        typy proste:
     */
    byte a = 10; //liczby całkowite -128 do 127. Używamy do oszczedzania pamięci
    short b = 100; //liczby całkowite od -32768 do 32766
    int c = 234456; // liczby całkowite od ok -2 miliardy do 2 miliardy
    long d = 999999999999999L; // bardzo duże liczby
    float e = 3.14f; //liczby zmiennoprzecinkowe
    char f = 'A'; // pojedyńczy znak
    double g = 2.45; // liczby zmiennoprzecinkowe, najczesciej używany
    boolean h = true; //przyjmuje wartosci true /false

    /*
        typy referencyjne
     */
    String name = "Bartosz";
    int[] numbers = {1, 2, 3, 4};
    String[] words = {"abc", "cde"};
    Person person = new Person();
}

class Person {
    String name = "Bartosz";
}
