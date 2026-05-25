package day01.materials;

public class ComparsionOfVariables {
    public static void main(String[] args) {
        int a = 5;
        int b = 6;

        //porównanie Integer
//        if (a == b) {
//            System.out.println("Prawda");
//        } else {
//            System.out.println("Fałsz");
//        }

        //porównanie String
        String text1 = "text1";
        String text2 = "text1";

        String text3 = new String("text3");
        String text4 = new String("text3");

        if (text3 == text4) {
            System.out.println("Prawda");
        } else {
            System.out.println("Fałsz");
        }
    }
}
