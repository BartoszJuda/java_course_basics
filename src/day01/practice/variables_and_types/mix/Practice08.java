package day01.practice.variables_and_types.mix;

import javax.xml.transform.Source;
import java.util.Scanner;

public class Practice08 {
    /*
    ZADANIE 8: Napisz program który oceni siłę hasła. Przyznaj punkty jeśli:
    hasło ma co najmniej 8 znaków
    hasło ma co najmniej 1 dużą literę
    hasło ma co najmniej 1 cyfre
    haslo ma co najmniej 1 znak specjalny
    przyznaj dodatkowe punkty jeśli hasło ma co najmniej 12 znaków
    wyświetl ile punktów zdobyło hasło. JEśl hasło ma <=2 puknty hasło słabe,
    jeśli ma <=4 punkty hasło średnie,
    jeśli ma > 4 punkty hasło silne
     */
    static void main(String[] args) {
        checkPasswordStrength();
    }

    static  void checkPasswordStrength() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Proszę o podanie hasła do oceny:");
        String password = scanner.nextLine();

        int score = 0;
        boolean hasLowerChar = false;
        boolean hasUpperChar = false;
        boolean hasDigit = false;
        boolean hasSpecial = false;

        for (char c : password.toCharArray()) {
            if (Character.isLowerCase(c)) {
                hasLowerChar = true;
            }
            else if (Character.isUpperCase(c)) {
                hasUpperChar = true;
            }
             else if (Character.isDigit(c)) {
                hasDigit = true;
            } else {
                 hasSpecial = true;
            }
        }

        if (password.length() >= 8) score++;
        if (hasLowerChar) score ++;
        if (hasUpperChar) score++;
        if (hasSpecial) score++;
        if (hasDigit) score++;

        if (password.length() >= 12) score++;

        if (score <= 2) {
            System.out.println("Hasło jest słabe");
        } else if (score <= 4) {
            System.out.println("Hasło jest średnie");
        } else {
            System.out.println("Hasło jest silne");
        }

        System.out.println("Podsumowanie:");
        System.out.println("Długość hasła >= 8 " + (password.length() >= 8));
        System.out.println("Długosć hasła >= 12 " + (password.length() >= 12));
        System.out.println("Czy hasło ma wielką literę: " + hasUpperChar);
        System.out.println("Czy hasło ma małą litere: " + hasLowerChar);
        System.out.println("Czy hasło ma cyfrę: " + hasDigit);
        System.out.println("Czy hasło ma znak specjalny: " + hasSpecial);

        scanner.close();
    }
}
