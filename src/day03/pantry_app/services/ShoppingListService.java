package day03.pantry_app.services;

import day03.pantry_app.models.ShoppingItem;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ShoppingListService implements Serializable {

    private List<ShoppingItem> items = new ArrayList<>();

    public void addItem(String name, int quantity) {
        items.add(new ShoppingItem(name, quantity));
    }

    public void showShoppingList() {
        if (items.isEmpty()) {
            System.out.println("Lista zakupów jest pusta");
            return;
        }

        for (ShoppingItem item : items) {
            System.out.println(item);
        }
    }

    public List<ShoppingItem> getItems() {
        return items;
    }
}
