package day01.practice.variables_and_types.loops;

public class Practice03 {
    /*
     * Zadanie 3 — String
     *
     * Program ma:
     * - połączyć imię i nazwisko,
     * - policzyć długość napisu,
     * - wypisać pierwszą literę,
     * - wypisać tekst wielkimi literami,
     * - sprawdzić czy pełne imię i nazwisko zawiera nazwisko.
     */
    static void main(String[] args) {
        String name = "Bartosz";
        String surname = "Juda";

        checkFirstAndLastName(name, surname);
    }

    static void checkFirstAndLastName(String firstName, String lastName) {
        String fullName = firstName + " " + lastName;
        System.out.println("Imię i nazwisko: " + fullName);

        int wordLength = fullName.length();
        System.out.println("Długośc połączonego napisu: " + wordLength);

        System.out.println("Pierwsza litera napisu: " + fullName.charAt(0));

        String fullNameToUpperCase = fullName.toUpperCase();
        System.out.println("Dużymi literami: " + fullNameToUpperCase);

        if (fullName.contains(lastName)) {
            System.out.println("W podanym wyrazie odnaleziono nazwisko");
        }
    }
}
