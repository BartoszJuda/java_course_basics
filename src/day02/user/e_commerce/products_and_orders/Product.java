package day02.user.e_commerce.products_and_orders;

import day02.user.e_commerce.Discountable;
import day02.user.e_commerce.enums.ProductCategory;

abstract class Product implements Discountable {
    private int id;
    private String name;
    private double price;
    private int quantity;
    private ProductCategory category;

    //konstruktor:
    public Product(int id, String name, double price, int quantity, ProductCategory category) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.category = category;
    }

    //gettery:

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public ProductCategory getCategory() {
        return category;
    }

    public void reduceQuantity (int amount) {
        quantity -= amount;
    }

    public void increaseQuantity(int amount) {
        quantity += amount;
    }

    //metoda abstrakcyjna do nadpisania w klasach dziedziczących
    public abstract double calculateTax();

    public double getFinalPrice() {
        return price + calculateTax() - calculateDiscount();
    }

    public void printInfo() {
        System.out.println("id: " + id);
        System.out.println("nazwa: " + name);
        System.out.println("kategoria:" + category);
        System.out.println("cena bazowa: " + price +  " PLN");
        System.out.println("vat: " + calculateTax() + " PLN");
        System.out.println("rabat: " + calculateDiscount() + " PLN");
        System.out.println("cena końcowa: " + getFinalPrice() + " PLN");
        System.out.println("ilość produktów na magazynie " + quantity);
    }
}
