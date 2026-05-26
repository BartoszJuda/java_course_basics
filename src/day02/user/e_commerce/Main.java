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

public class Main {
    static void main(String[] args) {
        runApplication();
    }

    static void runApplication() {
        Scanner sc = new Scanner(System.in);
        ShopSystem shopSystem = new ShopSystem();

        boolean running = true;

        while (running) {
            System.out.println("-----SYSTEM SKLEPU INTERNETOWEGO-----");
            System.out.println("Wybierz opcję:");
            System.out.println("1. - dodawanie użytkowników");
            System.out.println("2. - dodawanie produktów");
            System.out.println("3. - wyświetl produkty");
            System.out.println("4. - dodaj produkt do koszyka");
            System.out.println("5. - pokaż koszyk użytkownika");
            System.out.println("6. - złóż zamówienie");
            System.out.println("7. - zmień status zamówienia");
            System.out.println("8. - wyświetl użytkowników");
            System.out.println("9. - wyswietl zamówienia");
            System.out.println("10. - wyszukaj produkt po frazie");
            System.out.println("11. - filtruj produkty po kategorii");
            System.out.println("12. - sortuj produkty po cenie");
            System.out.println("13. - sortuj produkty po nazwie");
            System.out.println("14. - wyjście z programu");

            int option = Integer.parseInt(sc.nextLine());

            switch (option) {
                case 1:
                    System.out.println("podaj id użytkownika");
                    int userId = Integer.parseInt(sc.nextLine());

                    System.out.println("podaj imię");
                    String userName = sc.nextLine();

                    System.out.println("czy chcesz utworzyc użytkownika zwykłego czy premium (1, 2)");
                    System.out.println("1. - użytkownik zwykły");
                    System.out.println("2. - użytkownik premium");
                    int userType = Integer.parseInt(sc.nextLine());

                    if (userType == 1) {
                        shopSystem.addUser(new User(userId, userName));
                    } else if (userType == 2) {
                        shopSystem.addUser(new PremiumUser(userId, userName));
                    } else {
                        System.out.println("wybrano niepoprawny typ użytkownika");
                    }
                    break;
                case 2:
                    System.out.println("podaj kategorię produktu");
                    System.out.println("1. - elektronika");
                    System.out.println("2. - odzież");
                    System.out.println("3. - artykuły spożywcze");

                    int productType = Integer.parseInt(sc.nextLine());

                    System.out.println("podaj id produktu");
                    int productId = Integer.parseInt(sc.nextLine());

                    System.out.println("podaj cenę produktu");
                    double productPrice = Double.parseDouble(sc.nextLine());

                    System.out.println("podaj nazwę produktu");
                    String productName = sc.nextLine();

                    System.out.println("podaj ilość produktów");
                    int productQuantity = Integer.parseInt(sc.nextLine());

                    if (productType == 1) {
                        System.out.println("podaj okres gwarancji w miesiacach");
                        int warranty = Integer.parseInt(sc.nextLine());

                        shopSystem.addProduct(new Electronics(productId,
                                productName,
                                productPrice,
                                productQuantity,
                                warranty));
                    } else if (productType == 2) {
                        System.out.println("podaj rozmiar produktu");
                        String productSize = sc.nextLine();

                        shopSystem.addProduct(new Clothing(productId,
                                productName,
                                productPrice,
                                productQuantity,
                                productSize));
                    } else if (productType == 3) {
                        System.out.println("podaj datę wazności");
                        String expirationDate = sc.nextLine();

                        shopSystem.addProduct(new FoodProduct(productId,
                                productName,
                                productPrice,
                                productQuantity,
                                expirationDate));
                    } else {
                        System.out.println("podano niepoprawny typ produktu");
                    }
                    break;
                case 3:
                    shopSystem.showProducts();
                    break;
                case 4:
                    System.out.println("podaj id użytkownika");
                    int cartUserId = Integer.parseInt(sc.nextLine());

                    System.out.println("podaj id produktu");
                    int cartProductId = Integer.parseInt(sc.nextLine());

                    System.out.println("podaj ilośc produktów do dodania");
                    int cartQuantity = Integer.parseInt(sc.nextLine());

                    shopSystem.addProductToCart(cartUserId,
                            cartProductId,
                            cartQuantity);
                    break;
                case 5:
                    System.out.println("podaj id użytkownika");
                    int showCartUserId = Integer.parseInt(sc.nextLine());

                    shopSystem.showUserCart(showCartUserId);
                    break;
                case 6:
                    System.out.println("podaj id użytkownika");
                    int orderUserId = Integer.parseInt(sc.nextLine());

                    shopSystem.createOrder(orderUserId);
                    break;
                case 7:
                    System.out.println("podaj id zamówienia");
                    int orderId = Integer.parseInt(sc.nextLine());

                    System.out.println("1. NEW");
                    System.out.println("2. PAID");
                    System.out.println("3. SHIPPED");
                    System.out.println("4. DELIVERED");
                    System.out.println("5. CANCELLED");
                    System.out.println("wybierz status");

                    int statusOption = Integer.parseInt(sc.nextLine());

                    OrderStatus status = null;
                    if (statusOption == 1) status = OrderStatus.NEW;
                    else if (statusOption == 2) status = OrderStatus.PAID;
                    else if (statusOption == 3) status = OrderStatus.SHIPPED;
                    else if (statusOption == 4) status = OrderStatus.DELIVERED;
                    else if (statusOption == 5) status = OrderStatus.CANCELLED;

                    if (status != null) {
                        shopSystem.changeOrderStatus(orderId, status);
                    } else {
                        System.out.println("wybrano niepoprawny status");
                    }
                    break;
                case 8:
                    shopSystem.showUsers();
                    break;
                case 9:
                    shopSystem.showOrders();
                    break;
                case 10:
                    System.out.println("podaj frazę");
                    String phrase = sc.nextLine();

                    shopSystem.searchProductsByPhrase(phrase);
                    break;
                case 11:
                    System.out.println("1 - elektronika");
                    System.out.println("2 - ubrania");
                    System.out.println("3 - jedzenie");
                    System.out.println("wybierz kategorię");

                    int categoryOption = Integer.parseInt(sc.nextLine());

                    if (categoryOption == 1) {
                        shopSystem.filterProductsByCategory(ProductCategory.ELECTRONICS);
                    } else if (categoryOption == 2) {
                        shopSystem.filterProductsByCategory(ProductCategory.CLOTHING);
                    } else if (categoryOption == 3) {
                        shopSystem.filterProductsByCategory(ProductCategory.FOOD);
                    } else {
                        System.out.println("wybrano niepoprawna kategorię");
                    }
                    break;
                case 12:
                    shopSystem.sortProductsByPrice();
                    break;
                case 13:
                    shopSystem.sortProductsByName();
                    break;
                case 14:
                    running = false;
                    System.out.println("koniec programu");
                    break;
                default:
                    System.out.println("wybrano niepoprawną opcję");
            }
        }
        sc.close();
    }
}
