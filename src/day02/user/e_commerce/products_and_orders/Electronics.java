package day02.user.e_commerce.products_and_orders;

import day02.user.e_commerce.enums.ProductCategory;

public class Electronics extends Product{

    private int warrantyMonths;

    public Electronics(int id, String name, double price, int quantity, int warrantyMonths) {
        super(id, name, price, quantity, ProductCategory.ELECTRONICS);
        this.warrantyMonths = warrantyMonths;
    }

    @Override
    public double calculateTax() {
        return getPrice() * 0.22;
    }

    @Override
    public double calculateDiscount() {
        return getPrice() * 0.05;
    }

    @Override
    public void printInfo() {
        super.printInfo();
        System.out.println("gwarancja: " + warrantyMonths + " miesięcy");
    }
}
