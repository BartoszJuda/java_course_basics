package day01.materials;

public class Loops {
    static void main(String[] args) {
        //loopFor();
        //loopSwitch();
        //loopWhile();
        doWhileLoop();
        //forEachLoop();
    }

    //pętla for
    public static void loopFor() {
        for (int i = 0; i < 5; i++) {
            System.out.println("Numer: " + i);
        }
    }

    //switch
    public  static void loopSwitch () {
        int number = 2;

        switch (number) {
            case 1:
                System.out.println("Numer jest jedynką");
                break;
            case 2:
                System.out.println("Numer jest dwójką");
                break;
            default:
                System.out.println("Numer nie został znaleziony");
        }
    }

    //petla while:
    public static void loopWhile () {
        int counter = 5;

        while (counter >= 3) {
            System.out.println("Wartosć licznika: " + counter);
            counter--;
        }
    }

    //pętla do while
    public static void doWhileLoop () {
        int counter = 5;
        do {
            System.out.println("Pętla wystartowała");
            System.out.println("Wartosc licznika: " + counter);
            counter --;
        } while (counter >= 3);
    }

    //pętla for Each:
    public static void forEachLoop () {
        int[] numbers = {1, 2, 3};

        for (Integer number : numbers) {
            System.out.println("Wartość wynosi: " + number);
        }
    }

}
