package day02.user.simple_shop;

public class Main {
    static void main(String[] args) {
        //inicjalizacja obiektu User
        User user = new User("Bartosz");

        //dodawanie produktów do koszyka
        user.cart.addProduct(new Product(1, "Makaron", 3.20, "makarony"));
        user.cart.addProduct(new Product(2, "Chleb", 7.0, "pieczywo"));
        user.cart.addProduct(new Product(3, "Mleko", 5.20, "nabiał"));
        user.cart.addProduct(new Product(4, "Proszek do prania", 40, "chemia gospodarcza"));

        //wyświetlanie produktów:
        user.cart.showCart();

        //liczenie całkowitej kwoty produktów w koszyku:
        double totalAmount = user.cart.calculateCartSum();
        System.out.println("Całkowity rachunek wyniesie: " + totalAmount);

        //usuwanie produktu z koszyka:
        user.cart.removeProduct(3);
        System.out.println("Zawartosć koszyka po usunięciu produktu:");
        user.cart.showCart();

        //obliczanie średniej ceny produktu w koszyku:
        double averageProductPrice =  user.cart.avgPrice();
        System.out.println("Średnia wartość produktow w koszyku wynosi: " + averageProductPrice);

        //Sprawdzenie ile produktów mamy w koszyku:
        int numberOfProducts = user.cart.cartSize();
        System.out.println("Ilość produktów: " + numberOfProducts);

        //Znalezienie najdorższego produktu w koszyku:
        user.cart.findMostExpensiveProductInCart();

        //Znalezienie najtańszego produktu w koszyku:
        user.cart.findCheapestProductInCart();


        //Filtrowanie produktów według ceny:
        user.cart.filterProductsByMinPrice(40.0);


        //
        System.out.println("Wyszukiwanie produktów po id:");
        user.cart.findProductById(1);
        user.cart.findProductById(10);

        //Czyszczenie koszyka:
        user.cart.clearCart();
        System.out.println("Wyświetl informacje po wyczyszczeniu koszyka:");
        user.cart.showCart();

    }
}
