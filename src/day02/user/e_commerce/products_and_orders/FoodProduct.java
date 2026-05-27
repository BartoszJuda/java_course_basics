package day02.user.e_commerce.products_and_orders;

import day02.user.e_commerce.enums.ProductCategory;

public class FoodProduct extends Product{

    private String expirationDate;

    public FoodProduct(int id,
                       String name,
                       double price,
                       int quantity,
                       String expirationDate) {
        super(id, name, price, quantity, ProductCategory.FOOD);
        this.expirationDate = expirationDate;
    }

    @Override
    public double calculateTax() {
        return getPrice() * 0.05;
    }

    @Override
    public double calculateDiscount() {
        return getPrice() * 0.02;
    }

    @Override
    public void printInfo() {
        super.printInfo();
        System.out.println("data wazności: " + expirationDate);
    }
}
