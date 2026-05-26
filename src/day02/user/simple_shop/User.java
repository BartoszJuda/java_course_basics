package day02.user.simple_shop;

public class User {
    String name;
    Cart cart = new Cart();

    public User(String name) {
        this.name = name;
    }
}
