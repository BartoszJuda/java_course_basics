package day03.pantry_app.services;

import day03.pantry_app.enums.Category;
import day03.pantry_app.exceptions.InvalidProductDataException;
import day03.pantry_app.exceptions.NotEnoughProductException;
import day03.pantry_app.exceptions.ProductNotFoundException;
import day03.pantry_app.models.Product;

import java.io.Serializable;
import java.util.*;

public class PantryService implements Serializable {

    private Set<String> favouriteProducts = new HashSet<>();
    private Map<Integer, Product> products = new HashMap<>();

    public void addProduct(Product product) throws InvalidProductDataException {

        if (products.containsKey(product.getId())) {
            throw new InvalidProductDataException("Produkt z takim id już istnieje");
        }

        products.put(product.getId(), product);
    }

    public Product findProductById(int productId) throws ProductNotFoundException {

        Product product = products.get(productId);

        if (product == null) {
            throw new ProductNotFoundException("Nie znaleziono produktu o id: " + productId);
        }
        return product;
    }

    public void useProduct(int productId, int amount)
            throws ProductNotFoundException, NotEnoughProductException {

        Product product = products.get(productId);

        if (amount <= 0) {
            throw new NotEnoughProductException("Ilość produktów musi być większa od 0");
        }

        if (product.getQuantity() < amount ) {
            throw new NotEnoughProductException("Nie masz wystarczającej ilości produktu w spiżarni");
        }
        product.decreaseQuantity(amount);
    }

    public void showAllProducts() {
        if (products.isEmpty()) {
            System.out.println("Brak produktów w spiżarni");
            return;
        }
        for (Product product : products.values()) {
            System.out.println(product);
        }
    }

    public void showExpiringSoon(int days) {
        products.values().stream()
                .filter(p -> p.expiresSoon(days))
                .sorted(Comparator.comparing(Product::getExpiryDate))
                .forEach(System.out::println);
    }

    public void showProductsByCategory(Category category) {
        products.values().stream()
                .filter(p -> p.getCategory() == category)
                .forEach(System.out::println);
    }

    public void showFavouriteProducts() {
        if (favouriteProducts.isEmpty()) {
            System.out.println("Brak ulubionych produktów");
            return;
        }
        for (String name :favouriteProducts) {
            System.out.println(name);
        }
    }

    public Collection<Product> getProducts() {
        return  products.values();
    }
}
