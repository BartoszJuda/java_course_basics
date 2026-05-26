package day02.user.e_commerce.products_and_orders;

import day02.user.e_commerce.users.User;
import day02.user.e_commerce.enums.OrderStatus;
import day02.user.e_commerce.enums.ProductCategory;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ShopSystem {
    private List<Product> products = new ArrayList<>();
    private List<User> users = new ArrayList<>();
    private List<Order> orders = new ArrayList<>();

    public void addUser(User user) {
        users.add(user);
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public User findUserById(int id) {
        for (User user : users) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }

    public Product findProductById(int id) {
        for (Product product : products) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }

    public Order findOrderById(int id) {
        for (Order order : orders) {
            if (order.getId() == id) {
                return order;
            }
        }
        return null;
    }

    public void showProducts() {
        if (products.isEmpty()) {
            System.out.println("brak produktów");
            return;
        }
        for (Product product : products) {
            System.out.println("----------");
            product.printInfo();
        }
    }

    public void showUsers() {
        if (users.isEmpty()) {
            System.out.println("brak użytkowników");
            return;
        }
        for (User user : users) {
            System.out.println("----------");
            user.printInfo();
        }
    }

    public void addProductToCart(int userId, int productId, int quantity) {
        User user = findUserById(userId);
        Product product = findProductById(productId);

        if (user == null) {
            System.out.println("nie znaleziono użytkownika o id: " + userId);
            return;
        }

        if (product == null) {
            System.out.println("nie znaleziono produktu: " + productId);
            return;
        }

        user.getCart().addProduct(product, quantity);
        product.reduceQuantity(quantity);

        System.out.println("produkt :" + product.getName() + " zostal dodany do koszyka użytkownika:" + user.getName());
    }

    public void showUserCart(int userId) {
        User user = findUserById(userId);

        if (user == null) {
            System.out.println("nie znaleziono użytkownika o id: " + userId);
            return;
        }
        System.out.println("koszyk użytkownika: " + user.getName());
        user.getCart().printCart();
    }

    public void createOrder(int userId) {
        User user = findUserById(userId);

        if (user == null) {
            System.out.println("nie znaleziono użytkownika o id: " + userId);
        }

        if (user.getCart().isEmpty()) {
            System.out.println("brak produktów w koszyku");
            return;
        }

        Order order = new Order(user);
        orders.add(order);
        user.getCart().clear();

        System.out.println("zamówienie zostało utworzone");
    }

    public void showOrders() {
        if (orders.isEmpty()) {
            System.out.println("lista zamówień jest pusta");
            return;
        }

        for (Order order : orders) {
            System.out.println("----------");
            order.printInfo();
        }
    }

    public void changeOrderStatus(int orderId, OrderStatus status) {
        Order order = findOrderById(orderId);

        if (order == null) {
            System.out.println("nie znaleziono zamówienia o wskazanym id: " + orderId);
            return;
        }

        order.setStatus(status);
        System.out.println("Status zamówienia o id: " + orderId + " został zaktualizowany");
    }

    public void searchProductsByPhrase(String phrase) {
        boolean found = false;

        for (Product product : products) {
            if (product.getName().toLowerCase().contains(phrase.toLowerCase())) {
                System.out.println("---------");
                product.printInfo();
                found = true;
            }
        }

        if (!found) {
            System.out.println("nie znaleziono produktów");
        }
    }

    public void filterProductsByCategory(ProductCategory category) {
        boolean found = false;

        for (Product product : products) {
            if (product.getCategory() == category) {
                System.out.println("----------");
                product.printInfo();
                found = true;
            }
        }
        if (!found) {
            System.out.println("brak produktów w tej kategorii");
        }
    }

    public void sortProductsByPrice() {
        products.sort(Comparator.comparingDouble(Product::getFinalPrice));
        System.out.println("produkty posortowane po cenie:");
        showProducts();
    }

    public void sortProductsByName() {
        products.sort(Comparator.comparing(Product::getName));
        System.out.println("produkty posortowane po nazwie:");
        showProducts();
    }
}
