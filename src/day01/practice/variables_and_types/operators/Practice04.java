package day01.practice.variables_and_types.operators;

public class Practice04 {
    /*
        ZADANIE 4: Sprawdź, czy osoba może otrzymać prawo jazdy.
        Warunek: ma co najmniej 18 lat i zdała egzamin.
    */
    static void main(String[] args) {
        int age = 20;
        boolean hasExamPassed = false;
        //isDrivingLicenseAvailable(age, hasExamPassed);

        isDrivingLicenseAvailable(18, true);
    }

    static void isDrivingLicenseAvailable(int age, boolean hasUserPassedExam) {
        if (age >= 18 && hasUserPassedExam) {
            System.out.println("Użytkownik może otrzymac prawo jazdy");
        } else {
            System.out.println("Użytkownik nie może otrzymać prawa jazdy");
        }
    }
}
