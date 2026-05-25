package day01.practice.variables_and_types;

public class Practice04 {
    /*
        ZADANIE 4 (typ double): Oblicz pole koła o promieniu 5.0.
        Pole koła = PI * r * r;
    */
    public static void main(String[] args) {
        double radius = 5.0;
        double area = 3.14 * radius * radius;
        System.out.println("Pole wynosi: " + area);

        calculateArea();
    }

    public static void calculateArea () {
        double radius = 5.0;
        double area = Math.PI * radius * radius;
        System.out.printf("Pole %f\n", area);
    }
}
