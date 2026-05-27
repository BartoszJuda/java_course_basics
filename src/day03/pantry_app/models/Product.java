package day03.pantry_app.models;

import day03.enums.Category;
import day03.pantry_app.exceptions.InvalidProductDataException;

import java.io.Serializable;
import java.time.LocalDate;

public abstract class Product implements Serializable {

    private int id;
    private String name;
    private int quantity;
    private LocalDate expiryDate;
    private Category category;

    public Product(int id, String name,
                   int quantity,
                   LocalDate expiryDate,
                   Category category) throws InvalidProductDataException {

        if (id <=0 ) {
            throw new InvalidProductDataException("Id produktu musi być wieksze od 0");
        }

        if (name == null || name.isBlank()) {
            throw new InvalidProductDataException("Nazwa produktu nie może być pusta");
        }

        if (quantity < 0) {
            throw new InvalidProductDataException("Ilosć produktów w spiżarce nie może być ujemna");
        }

        if (expiryDate == null) {
            throw new InvalidProductDataException("Data ważności produktu nie może byc pusta");
        }

        if (category == null) {
            throw new InvalidProductDataException("Kategoria nie może być pusta");
        }


        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.expiryDate = expiryDate;
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public Category getCategory() {
        return category;
    }

    public void decreaseQuantity(int amount) {
        this.quantity -= amount;
    }

    public boolean expiresSoon(int days) {
        return expiryDate.isBefore(LocalDate.now().plusDays(days + 1));
    }

    public abstract String getType();

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", quantity=" + quantity +
                ", expiryDate=" + expiryDate +
                ", category=" + category +
                '}';
    }
}
