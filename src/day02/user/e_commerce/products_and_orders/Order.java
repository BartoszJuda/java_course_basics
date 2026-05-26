package day02.user.e_commerce.products_and_orders;

import day02.user.e_commerce.users.User;
import day02.user.e_commerce.enums.OrderStatus;

import java.util.List;

public class Order {

    private static int nextId = 1;

    private int id;
    private User user;
    private List<CartItem> items;
    private double totalPrice;
    private OrderStatus status;

    public Order(User user) {
        this.id = nextId++;
        this.user = user;
        this.items = user.getCart().getItems();
        double discount = user.getCart().calculateTotalAmount() * user.getUserDiscount();
        this.totalPrice = user.getCart().calculateTotalAmount() - discount;
        this.status = OrderStatus.NEW;
    }

    public int getId() {
        return id;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public void printInfo() {
        System.out.println("id zamówienia: " + id);
        System.out.println("użytkownik: " + user.getName()); //todo - uzupełnić użytkownika
        System.out.println("status: " + status);
        System.out.println("wartość zamówienia: " + totalPrice + " PLN");

        System.out.println("produkty:");
        for (CartItem item : items) {
            item.printInfo();
        }
    }
}
