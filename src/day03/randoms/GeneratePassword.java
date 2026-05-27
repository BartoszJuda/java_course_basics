package day03.randoms;

import java.util.Random;
import java.util.Scanner;

public class GeneratePassword {
    static void main(String[] args) {
        String allowedCharacters = "QWERTYUIOPASDFGHJKLZXCVBNMqwertyuioasdfghjklzxcvbnm1234567890#$@%&";

        Scanner sc = new Scanner(System.in);
        System.out.println("Podaj długość hasła:");
        int passwordLength = Integer.parseInt(sc.nextLine());

        StringBuilder password = new StringBuilder();

        Random random = new Random();

        for (int i = 0; i < passwordLength; i++) {
            int index = random.nextInt(allowedCharacters.length());

            password.append(allowedCharacters.charAt(index));
        }

        System.out.println("Wygenerowane hasło: " + password);
    }

    public String generateRandomPassword(int passwordLength) {
        String allowedCharacters = "QWERTYUIOPASDFGHJKLZXCVBNMqwertyuioasdfghjklzxcvbnm1234567890#$@%&";

        StringBuilder pass = new StringBuilder();
        Random r = new Random();

        for (int i = 0; i < passwordLength; i++) {
            int index = r.nextInt(allowedCharacters.length());

            pass.append(allowedCharacters.charAt(index));
        }
        return pass.toString();
    }
}
