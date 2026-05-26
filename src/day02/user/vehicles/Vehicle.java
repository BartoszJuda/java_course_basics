package day02.user.vehicles;

public class Vehicle implements  Movable{
    @Override
    public void move() {
        System.out.println("Pojazd jedzie");
    }
}
