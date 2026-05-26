package day02.user.car;

public class Main {

    static void main(String[] args) {
        Car bmw = new Car("BMW", "5", 2021);
        Car mercedes = new Car("Mercedes", "S", 2020);
        Car toyota = new Car("Toyota", "Corolla", 2024);

        //bmw.model = "Mercedes";

        Car[] cars = {bmw, mercedes, toyota};

        for(Car car : cars) {
            car.showInfo();
        }
    }
}
