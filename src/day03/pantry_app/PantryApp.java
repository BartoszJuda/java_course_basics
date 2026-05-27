package day03.pantry_app;

import day03.pantry_app.enums.Category;
import day03.pantry_app.exceptions.InvalidProductDataException;
import day03.pantry_app.models.CleaningProduct;
import day03.pantry_app.models.FoodProduct;
import day03.pantry_app.services.PantryService;
import day03.pantry_app.services.ShoppingListService;
import day03.pantry_app.utils.CsvExporter;
import day03.pantry_app.utils.SerializerUtil;

import java.time.LocalDate;
import java.util.Scanner;

public class PantryApp {

   private final Scanner sc = new Scanner(System.in);

   private PantryService pantryService = new PantryService();

   private ShoppingListService shoppingListService = new ShoppingListService();

    public void start() {
        boolean running = true;

        while (true) {
            showMenu();

            try {
                int choice  = Integer.parseInt(sc.nextLine());

                switch (choice) {
                    case 1 -> addFoodProduct();
                    case 2 -> addCleaningProduct();
                    case 3 -> pantryService.showAllProducts();
                    case 4 -> useProduct();
                    case 5 -> showProductsByCategory();
                    case 6 -> showExpiringSoon();
                    case 7 -> addProductToShoppingList();
                    case 8 -> shoppingListService.showShoppingList();
                    case 9 -> exportToCsv();
                    case 10 -> saveData();
                    case 11 -> loadData(); //todo sprawdzić problem z serializacją
                    case 0 -> running = false; //todo do sprawdzenia czemu app się nie z
                    default -> System.out.println("Wybrałeś nieznaną opcję");
                }
            } catch (NumberFormatException e) {
                System.out.println("Podaj poprawną liczbę");
            } catch (Exception e) {
                System.out.println("Inny nieznany błąd: " + e.getMessage());
            }
        }
        //todo - dodać informację o końcu działania programu
    }


   private void showMenu() {
       System.out.println("MANAGER SPIŻARNI");

       System.out.println("1. Dodaj produkt spożywczy");
       System.out.println("2. Dodaj produkt chemiczny");
       System.out.println("3. Pokaz wszystkie produkty");
       System.out.println("4. Zużyj produkt");
       System.out.println("5. Pokaż produkty po kategorii");
       System.out.println("6. Pokaz produkty z krótką datą wazności");
       System.out.println("7. Dodaj do listy zakupów");
       System.out.println("8. Pokaz listę zakupów");
       System.out.println("9. Export do CSV");
       System.out.println("10 Zapisz dane");
       System.out.println("11 Wczytaj dane");
       System.out.println("0. Wyjście");

       System.out.println("Wybierz opcje:");
   }

   private void addFoodProduct() throws InvalidProductDataException {

       System.out.println("Podaj id produktu:");
       int id = Integer.parseInt(sc.nextLine());

       System.out.println("Podaj nazwę: ");
       String name = sc.nextLine();

       System.out.println("Podaj ilość:");
       int quantity = Integer.parseInt(sc.nextLine());

       System.out.println("Podaj datę waznosci produktu w formacie yyyy-MM-dd");
       LocalDate expiryDate = LocalDate.parse(sc.nextLine());

       Category category = readCategory();

       System.out.println("Czy produkt nalezy przechowywać w lodówce? true/false:");

       boolean refrigerated = Boolean.parseBoolean(sc.nextLine());

       FoodProduct product = new FoodProduct(
               id,
               name,
               quantity,
               expiryDate,
               category,
               refrigerated
       );

       pantryService.addProduct(product);
       System.out.println("Dodano produkt");
   }

   private void addCleaningProduct() throws InvalidProductDataException {

       System.out.println("Podaj id produktu: ");
       int id = Integer.parseInt(sc.nextLine());

       System.out.println("Podaj nazwę produktu:");
       String name = sc.nextLine();

       System.out.println("Podaj ilość produktów:");
       int quantity = Integer.parseInt(sc.nextLine());

       System.out.println("Podaj datę wazności w formacie yyyy-MM-dd:");
       LocalDate expiryDate = LocalDate.parse(sc.nextLine());

       Category category = readCategory();

       System.out.println("Czy produkt jest toksyczny? true/false:");
       boolean isToxic = Boolean.parseBoolean(sc.nextLine());

       CleaningProduct product = new CleaningProduct(
               id,
               name,
               quantity,
               expiryDate,
               category,
               isToxic
       );

       pantryService.addProduct(product);

       System.out.println("Dodano produkt");
   }

   private void useProduct() throws Exception {

       System.out.println("Proszę o podanie id produktu:");
       int id = Integer.parseInt(sc.nextLine());

       System.out.println("Proszę o podanie ilosci produku:");
       int amount = Integer.parseInt(sc.nextLine());

       pantryService.useProduct(id, amount);

       System.out.println("Produkt został zużyty");
   }

   private void showProductsByCategory() {
       Category category = readCategory();
       pantryService.showProductsByCategory(category);
   }

   private void showExpiringSoon() {

       System.out.println("Podaj ile dni:");
       int days = Integer.parseInt(sc.nextLine());

       pantryService.showExpiringSoon(days);
   }

   private void addProductToShoppingList() {

       System.out.println("Podaj nazwę produktu:");
       String name = sc.nextLine();

       System.out.println("Podaj ilość:");
       int quantity = Integer.parseInt(sc.nextLine());

       shoppingListService.addItem(name, quantity);

       System.out.println("Dodano do listy");
   }

   private void exportToCsv() {
       CsvExporter.exportProducts(
               pantryService.getProducts(),
               "products.csv"
       );
   }

   private void saveData() {
       SerializerUtil.save(
               pantryService,
               "pantry.ser");

       SerializerUtil.save(
               shoppingListService,
               "shopping.ser"
       );
   }

   private void loadData() {
       PantryService loadedPantry =
               (PantryService) SerializerUtil.load("pantry.ser");

       ShoppingListService loadedShopping =
               (ShoppingListService) SerializerUtil.load("shopping.ser");

       if (loadedPantry != null) {
           pantryService = loadedPantry;
       }

       if (loadedShopping != null) {
           shoppingListService = loadedShopping;
       }

       System.out.println("Wczytano dane.");
   }

   private Category readCategory() {
       System.out.println("1. FOOD");
       System.out.println("2. DRINKS");
       System.out.println("3. CLEANING");
       System.out.println("4. COSMETICS");
       System.out.println("5. OTHER");

       int choice = Integer.parseInt(sc.nextLine());

       return switch (choice) {
           case 1 -> Category.FOOD;
           case 2 -> Category.DRINKS;
           case 3 -> Category.CLEANING;
           case 4 -> Category.COSMETICS;

           default -> Category.OTHER;
       };
   }

}
