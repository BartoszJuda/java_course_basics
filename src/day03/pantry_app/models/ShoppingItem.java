package day03.pantry_app.models;

import java.io.Serializable;

public class ShoppingItem implements Serializable {

    private String name;
    private int quantity;

    public ShoppingItem(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return name + " | ilość do kupienia" + quantity;
    }
}
