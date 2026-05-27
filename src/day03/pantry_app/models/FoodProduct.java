package day03.pantry_app.models;

import day03.pantry_app.enums.Category;
import day03.pantry_app.exceptions.InvalidProductDataException;

import java.time.LocalDate;

public class FoodProduct extends Product{

    private boolean refrigerated;

    public FoodProduct(int id,
                       String name,
                       int quantity,
                       LocalDate expiryDate,
                       Category category,
                       boolean refrigerated) throws InvalidProductDataException {
        super(id, name, quantity, expiryDate, category);
        this.refrigerated = refrigerated;
    }

    public boolean isRefrigerated() {
        return refrigerated;
    }

    @Override
    public String getType() {
        return "Artykuł spożywczy";
    }
}
