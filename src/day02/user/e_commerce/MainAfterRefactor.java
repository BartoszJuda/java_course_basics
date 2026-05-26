package day02.user.e_commerce;

import day02.user.e_commerce.enums.OrderStatus;
import day02.user.e_commerce.enums.ProductCategory;
import day02.user.e_commerce.products_and_orders.Clothing;
import day02.user.e_commerce.products_and_orders.Electronics;
import day02.user.e_commerce.products_and_orders.FoodProduct;
import day02.user.e_commerce.products_and_orders.ShopSystem;
import day02.user.e_commerce.users.PremiumUser;
import day02.user.e_commerce.users.User;

import java.util.Scanner;

public class MainAfterRefactor {

    private static final Scanner sc = new Scanner(System.in);
    private static final ShopSystem shopSystem = new ShopSystem();

    static void main(String[] args) {
        runApplication();
    }

    private static void runApplication() {
        boolean running = true;

        while (running) {
            showMenu();

            int option = readInt("Wybierz opcję: ");

            switch (option) {
                case 1 -> addUser();
                case 2 -> addProduct();
                case 3 -> shopSystem.showProducts();
                case 4 -> addProductToCart();
                case 5 -> showUserCart();
                case 6 -> createOrder();
                case 7 -> changeOrderStatus();
                case 8 -> shopSystem.showUsers();
                case 9 -> shopSystem.showOrders();
                case 10 -> searchProductsByPhrase();
                case 11 -> filterProductsByCategory();
                case 12 -> shopSystem.sortProductsByPrice();
                case 13 -> shopSystem.sortProductsByName();
                case 14 -> {
                    running = false;
                    System.out.println("Koniec programu");
                }
                default -> System.out.println("Wybrano niepoprawną opcję");
            }
        }
    }

    private static void showMenu() {
        System.out.println("-----SYSTEM SKLEPU INTERNETOWEGO-----");
        System.out.println("1. Dodaj użytkownika");
        System.out.println("2. Dodaj produkt");
        System.out.println("3. Wyświetl produkty");
        System.out.println("4. Dodaj produkt do koszyka");
        System.out.println("5. Pokaż koszyk użytkownika");
        System.out.println("6. Złóż zamówienie");
        System.out.println("7. Zmień status zamówienia");
        System.out.println("8. Wyświetl użytkowników");
        System.out.println("9. Wyświetl zamówienia");
        System.out.println("10. Wyszukaj produkt po frazie");
        System.out.println("11. Filtruj produkty po kategorii");
        System.out.println("12. Sortuj produkty po cenie");
        System.out.println("13. Sortuj produkty po nazwie");
        System.out.println("14. Wyjście z programu");
    }

    private static void addUser() {
        int userId = readInt("Podaj id użytkownika: ");
        String userName = readString("Podaj imię: ");

        System.out.println("1. Użytkownik zwykły");
        System.out.println("2. Użytkownik premium");

        int userType = readInt("Wybierz typ użytkownika: ");

        switch (userType) {
            case 1 -> shopSystem.addUser(new User(userId, userName));
            case 2 -> shopSystem.addUser(new PremiumUser(userId, userName));
            default -> System.out.println("Wybrano niepoprawny typ użytkownika");
        }
    }

    private static void addProduct() {
        System.out.println("1. Elektronika");
        System.out.println("2. Odzież");
        System.out.println("3. Artykuły spożywcze");

        int productType = readInt("Wybierz kategorię produktu: ");

        int productId = readInt("Podaj id produktu: ");
        double productPrice = readDouble("Podaj cenę produktu: ");
        String productName = readString("Podaj nazwę produktu: ");
        int productQuantity = readInt("Podaj ilość produktów: ");

        switch (productType) {
            case 1 -> addElectronics(productId, productName, productPrice, productQuantity);
            case 2 -> addClothing(productId, productName, productPrice, productQuantity);
            case 3 -> addFoodProduct(productId, productName, productPrice, productQuantity);
            default -> System.out.println("Podano niepoprawny typ produktu");
        }
    }

    private static void addElectronics(int id, String name, double price, int quantity) {
        int warranty = readInt("Podaj okres gwarancji w miesiącach: ");

        shopSystem.addProduct(new Electronics(
                id,
                name,
                price,
                quantity,
                warranty
        ));
    }

    private static void addClothing(int id, String name, double price, int quantity) {
        String size = readString("Podaj rozmiar produktu: ");

        shopSystem.addProduct(new Clothing(
                id,
                name,
                price,
                quantity,
                size
        ));
    }

    private static void addFoodProduct(int id, String name, double price, int quantity) {
        String expirationDate = readString("Podaj datę ważności: ");

        shopSystem.addProduct(new FoodProduct(
                id,
                name,
                price,
                quantity,
                expirationDate
        ));
    }

    private static void addProductToCart() {
        int userId = readInt("Podaj id użytkownika: ");
        int productId = readInt("Podaj id produktu: ");
        int quantity = readInt("Podaj ilość produktów do dodania: ");

        shopSystem.addProductToCart(userId, productId, quantity);
    }

    private static void showUserCart() {
        int userId = readInt("Podaj id użytkownika: ");
        shopSystem.showUserCart(userId);
    }

    private static void createOrder() {
        int userId = readInt("Podaj id użytkownika: ");
        shopSystem.createOrder(userId);
    }

    private static void changeOrderStatus() {
        int orderId = readInt("Podaj id zamówienia: ");

        System.out.println("1. NEW");
        System.out.println("2. PAID");
        System.out.println("3. SHIPPED");
        System.out.println("4. DELIVERED");
        System.out.println("5. CANCELLED");

        int statusOption = readInt("Wybierz status: ");
        OrderStatus status = getOrderStatus(statusOption);

        if (status == null) {
            System.out.println("Wybrano niepoprawny status");
            return;
        }

        shopSystem.changeOrderStatus(orderId, status);
    }

    private static OrderStatus getOrderStatus(int option) {
        return switch (option) {
            case 1 -> OrderStatus.NEW;
            case 2 -> OrderStatus.PAID;
            case 3 -> OrderStatus.SHIPPED;
            case 4 -> OrderStatus.DELIVERED;
            case 5 -> OrderStatus.CANCELLED;
            default -> null;
        };
    }

    private static void searchProductsByPhrase() {
        String phrase = readString("Podaj frazę: ");
        shopSystem.searchProductsByPhrase(phrase);
    }

    private static void filterProductsByCategory() {
        System.out.println("1. Elektronika");
        System.out.println("2. Ubrania");
        System.out.println("3. Jedzenie");

        int option = readInt("Wybierz kategorię: ");
        ProductCategory category = getProductCategory(option);

        if (category == null) {
            System.out.println("Wybrano niepoprawną kategorię");
            return;
        }

        shopSystem.filterProductsByCategory(category);
    }

    private static ProductCategory getProductCategory(int option) {
        return switch (option) {
            case 1 -> ProductCategory.ELECTRONICS;
            case 2 -> ProductCategory.CLOTHING;
            case 3 -> ProductCategory.FOOD;
            default -> null;
        };
    }

    private static int readInt(String message) {
        while (true) {
            try {
                System.out.print(message);
                return Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Podaj poprawną liczbę całkowitą.");
            }
        }
    }

    private static double readDouble(String message) {
        while (true) {
            try {
                System.out.print(message);
                return Double.parseDouble(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Podaj poprawną liczbę.");
            }
        }
    }

    private static String readString(String message) {
        System.out.print(message);
        return sc.nextLine();
    }
}
