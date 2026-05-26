package day02.user.upcasting;

public class Main {
    public static void main (String[] args) {

        Airplane airplane = new Airplane();
        Vehicle vehicle = airplane;

        vehicle.move();
    }
}
