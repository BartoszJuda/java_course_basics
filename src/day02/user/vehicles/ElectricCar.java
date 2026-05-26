package day02.user.vehicles;

public class ElectricCar implements Chargeable, Movable {

    @Override
    public void charge() {
        System.out.println("Samochód się ładuje");
    }

    @Override
    public void move() {
        System.out.println("Samochód może się poruszać");
    }
}
