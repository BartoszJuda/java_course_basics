package day03;

import java.util.Scanner;

public class CalculateDelta {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Obliczanie delty");

        System.out.println("Podaj wartość a");
        double a = Double.parseDouble(sc.nextLine());

        System.out.println("Podaj wartość b");
        double b = Double.parseDouble(sc.nextLine());

        System.out.println("Podaj wartość c");
        double c = Double.parseDouble(sc.nextLine());

        double delta = b * b - 4 * a * c;

        if (delta > 0) {
            double x1 = (-b - Math.sqrt(delta)) / (2 * a);
            double x2 = (-b + Math.sqrt(delta)) / (2 * a);

            System.out.println("x1: " + x1);
            System.out.println("x2 " + x2);
        } else if (delta == 0) {
            double x = -b / (2 *a);
            System.out.println("x: " + x);
        } else {
            System.out.println("Brak rozwiązania");
        }
    }
}
