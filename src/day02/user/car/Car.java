package day02.user.car;

public class Car {
    private String mark;
    private String model;
    private int year;

    public Car(String mark, String model, int year) {
        this.mark = mark;
        this.model = model;
        this.year = year;
    }

    public String getMark() {
        return mark;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public void showInfo () {
        System.out.println(mark + " " + model + " " + year);
    }
}
