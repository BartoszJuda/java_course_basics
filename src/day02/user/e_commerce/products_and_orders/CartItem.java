package day02.user.e_commerce.products_and_orders;

public class CartItem {

    private Product product;
    private int quantity;

    public CartItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void increaseQuantity(int amount) {
        quantity += amount;
    }

    public double getTotalPrice (){
        return product.getFinalPrice() * quantity;
    }

    public void printInfo() {
        System.out.println(product.getName() + " x " + quantity);
        System.out.println("cena końcowa za produkt: " + getTotalPrice() + " PLN");
    }
}
