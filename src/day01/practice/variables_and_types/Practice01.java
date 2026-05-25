package day01.practice.variables_and_types;

public class Practice01 {

    /*
      ZADANIE 1: Zmienne i typy danych
      Napisz w Javie program, który:
      tworzy zmienną age typu int z wartością 25
      tworzy zmienną name typu String z wartością "Adam"
      wypisuje na ekran tekst: Cześć Adam, masz 25 lat.
 */
    public static void main (String[] args) {
        // deklaracja zmiennych:
        int age = 25;
        String name = "Adam";

        // rezultat:
        String result = "Cześć " + name + "," + " masz " + age + " lat.";

        //wypisanie wyniku
        System.out.println(result);
    }

    public static void solution() {
        int age = 25;
        String name = "Adam";
        System.out.printf("Cześć %s, masz %d lat.\n", name, age);
    }

}
