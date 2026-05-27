package day03.exceptions;

import java.util.Scanner;

public class SimpleException {
    static void main(String[] args) {
        try {
            getAge();
        } catch (InvalidAgeException e) {
            System.out.println(e.getMessage());
        }

    }

    static void getAge() throws InvalidAgeException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Wprowadź wiek");
        int age = Integer.parseInt(scanner.nextLine());

        if (age < 0 || age >150) {
            throw new InvalidAgeException("Wprowadziłeś niepoprawny wiek");
        }

        System.out.println("Wprowadzony wiek jest poprawny");
    }
}
