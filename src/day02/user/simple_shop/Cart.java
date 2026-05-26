package day02.user.simple_shop;

import java.util.ArrayList;
import java.util.List;

public class Cart {

    List<Product> products = new ArrayList<>();

    void addProduct(Product product) {
        products.add(product);
    }

    void removeProduct(int productId) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId() == productId) {
                products.remove(i);
                return;
            }
        }
    }

    void showCart() {
        for (Product product : products) {
            System.out.println("Nazwa produktu: " + product.getName() + " Cena produktu: " + product.getPrice() +
                    " Kategoria produktu:" + product.getCategory());
        }
    }

    double calculateCartSum() {
        double totalPrice = 0;
        for (Product product : products) {
            totalPrice += product.getPrice();
        }
        return totalPrice;
    }

    void sortProductsByPriceAsc() {
        products.stream().sorted((a, b) -> Double.compare(b.getPrice(), a.getPrice()))
                .forEach(p -> System.out.println(p.getName() + " -> "  + p.getPrice()));
    }

    void filterProductsByMinPrice(double minPrice) {
        products.stream().filter(product -> product.getPrice() >= minPrice)
                .forEach(product -> System.out.println(product.getName() + " -> " + product.getPrice()));
    }

    void findProductById(int id) {
        products.stream().filter(product -> product.getId() == id)
                .forEach(p -> System.out.println(p.getName() + " -> " + p.getPrice()));
    }

    void findProductByName(String productName) {
        products.stream().filter(p -> p.getName().equals(productName))
                .forEach(this::printProduct);
    }

    void printProduct(Product p) {
        System.out.println(p.getName() + " -> " + p.getPrice());
    }

    void clearCart() {
        products.clear();
    }

    int cartSize() {
        return products.size();
    }

    void findMostExpensiveProductInCart() {
        Product max = products.stream().max((a, b) -> Double.compare(a.getPrice(), b.getPrice()))
                .orElse(null);
        if (max != null) {
            System.out.println(max.getName() + " -> " + max.getPrice());
        }
    }

    void findCheapestProductInCart() {
        Product min = products.stream().min((a, b) -> Double.compare(a.getPrice(), b.getPrice()))
                .orElse(null);
        if (min != null) {
            System.out.println(min.getName() + " -> " + min.getPrice());
        }
    }

    double avgPrice() {
        return products.stream().mapToDouble(p -> p.getPrice())
                .average().orElse(0);
    }
}
