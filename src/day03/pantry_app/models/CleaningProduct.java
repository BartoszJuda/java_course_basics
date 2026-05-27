package day03.pantry_app.models;

import day03.enums.Category;
import day03.pantry_app.exceptions.InvalidProductDataException;

import java.time.LocalDate;

public class CleaningProduct extends Product{

    private boolean isToxic;

    public CleaningProduct(int id,
                           String name,
                           int quantity,
                           LocalDate expiryDate,
                           Category category,
                           boolean isToxic) throws InvalidProductDataException {
        super(id, name, quantity, expiryDate, category);
        this.isToxic = isToxic;
    }

    public boolean isToxic() {
        return isToxic;
    }

    @Override
    public String getType() {
        return "Chemiczny";
    }
}
