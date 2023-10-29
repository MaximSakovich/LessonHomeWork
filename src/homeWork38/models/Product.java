package homeWork38.models;

public class Product {

    private String title;
    private double price;
    private String description;
    private int residual;

    public Product(String title, double price, String description, int residual) {
        this.title = title;
        this.price = price;
        this.description = description;
        this.residual = residual;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getResidual() {
        return residual;
    }

    public void setResidual(int residual) {
        this.residual = residual;
    }
}