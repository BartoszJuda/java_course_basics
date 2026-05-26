package day02.user.e_commerce.products_and_orders;

import day02.user.e_commerce.enums.ProductCategory;

public class Clothing extends Product{

    private String size;

    public Clothing(int id, String name, double price, int quantity, String size) {
        super(id, name, price, quantity, ProductCategory.CLOTHING);
        this.size = size;
    }

    @Override
    public double calculateTax() {
        return getPrice() * 0.23;
    }

    @Override
    public double calculateDiscount() {
        return getPrice() * 0.10;
    }

    @Override
    public void printInfo() {
        super.printInfo();
        System.out.println("rozmiar ubrania: " + size);
    }
}
