package day03.randoms;

public class PassBreaker {
    static void main(String[] args) {
        breakPassword("abcd");
    }

    static void breakPassword(String password) {

        int attempts = 0;
        int passwordLength = password.length();

        GeneratePassword generatePassword = new GeneratePassword();

        while (true) {
            String guess = generatePassword.generateRandomPassword(passwordLength);
            attempts++;
            System.out.println("Próba nr. " + attempts + " .Wygenerowane hasło: " + guess);

            if (guess.equals(password)) {
                System.out.println("Hasło zostało znalezione: " + guess +  " . Liczba prób " + attempts);
                break;
            }
        }
    }
}
