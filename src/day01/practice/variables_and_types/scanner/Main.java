package day01.practice.variables_and_types.scanner;

import java.util.Scanner;

public class Main {

    static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Wprowadź pierwszą liczbę:");
        int a = Integer.parseInt(scanner.nextLine());
        System.out.println("Wprowadź drugą liczbę:");
        int b = Integer.parseInt(scanner.nextLine());
        System.out.println("Wprowadź typ operacji (+ - * /)");
        String operation = scanner.nextLine();

        switch (operation) {
            case "+":
                System.out.println("Suma: " + (a+b));
                break;
            case "-":
                System.out.println("Róźnica: " + (a-b));
                break;
            case "*":
                System.out.println("Iloczyn: " + (a * b));
                break;
            case "/":
                System.out.println("Iloraz: " + (a /b));
                break;
            default:
                System.out.println("Wprowadziłes niepoprawny operator");
        }
    }
}
