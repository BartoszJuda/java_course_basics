package day02.user.e_commerce.products_and_orders;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<CartItem> items = new ArrayList<>();

    public List<CartItem> getItems () {
        return items;
    }

    public void addProduct (Product product, int quantity) {
        for (CartItem item : items) {
            if (item.getProduct().getId() == product.getId()) {
                item.increaseQuantity(quantity);
                return;
            }
        }
        items.add(new CartItem(product, quantity));
    }

    public void clear() {
        items.clear();
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }

    public double calculateTotalAmount() {
        double sum = 0;

        for (CartItem item : items) {
            sum += item.getTotalPrice();
        }
        return sum;
    }

    public void printCart() {
        if (items.isEmpty()) {
            System.out.println("koszyk jest pusty.");
            return;
        }

        for (CartItem item : items) {
            System.out.println("----------");
            item.printInfo();
        }

        System.out.println("wartość całkowita koszyka wynosi: " + calculateTotalAmount() + " PLN");
    }
}
