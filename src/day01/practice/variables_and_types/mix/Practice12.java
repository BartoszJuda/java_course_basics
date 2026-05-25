package day01.practice.variables_and_types.mix;

import java.util.Scanner;

public class Practice12 {

    /*
    Pobierz od użytkownika zdanie poprzez Scanner i policz ile wyrazów zawiera to zdanie
     */
    static void main(String[] args) {
        calculateNumberOfWords();
    }

    static void calculateNumberOfWords() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Wprowadź zdanie:");
        String phrase = sc.nextLine();

        String[] splitted = phrase.split(" ");

        System.out.println("Wprowadzone zdanie zawiera: " + splitted.length + " wyrazów");
    }
}
