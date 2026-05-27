package day03.pantry_app.utils;

import day03.pantry_app.models.Product;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;

public class CsvExporter {

    public static void exportProducts(Collection<Product> products, String fileName) {

        try(PrintWriter writer = new PrintWriter(fileName)) {

            writer.println("id,name,quantity,expiryDate,category,type");

            for (Product p : products) {
                writer.println(
                        p.getId() + "," +
                                p.getName() + "," +
                                p.getQuantity() + "," +
                                p.getExpiryDate() + "," +
                                p.getCategory() + "," +
                                p.getType()
                );
            }
            System.out.println("Zapisano plik csv: " + fileName);
        } catch (IOException exception) {
            System.out.println("Błąd zapisu do pliku csv: " + exception.getMessage());
        }
    }
}
