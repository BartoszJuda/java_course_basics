package day01.materials;

public class ComparsionOfVariables02 {
    public static void main(String[] args) {
        int a = 1;
        int b = a;

        String c = "tekst";
        String d = "tekst";

        if (c.equals(d)) {
            System.out.println("Prawda");
        } else {
            System.out.println("Fałsz");
        }

    }
}
