package day02.user.product;

public class Client{
    private int id;
    private String name;
    private Product product;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Product getProduct() {
        return product;
    }

    public Client(int id, String name, Product product) {
        this.id = id;
        this.name = name;
        this.product = product;
    }
}
