package day02.user.e_commerce.users;

import day02.user.e_commerce.products_and_orders.Cart;

public class User {
    private int id;
    private String name;
    private Cart cart;

    public User(int id, String name) {
        this.id = id;
        this.name = name;
        this.cart = new Cart();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Cart getCart() {
        return cart;
    }

    public double getUserDiscount() {
        return 0;
    }

    public void printInfo() {
        System.out.println("id użytkownika: " + id);
        System.out.println("imię użytkownika: " + name);
        System.out.println("typ użytkownika: zwykły");
    }
}
