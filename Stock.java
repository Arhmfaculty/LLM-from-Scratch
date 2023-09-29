import java.util.ArrayList;

public class Stock {
    private String productName;
    private String productBrand;
    private double price;
    private int quantity;

    // Create constructor
    public Stock(String productName, String productBrand, double price, int quantity) {
        this.productName = productName;
        this.productBrand = productBrand;
        this.price = price;
        this.quantity = quantity;}
    public Stock(String productName, String productBrand) {
            this.productName = productName;
            this.productBrand = productBrand;}

    public Stock(String productName, double productPrice) {

    }

    // accessor methods to return the fields
    public String getProductName() {
        return productName;
    }

    public String getProductBrand() {
        return productBrand;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    // mutator methods to update the fields
    public void setProductBrand(String newBrand) {
        productBrand = newBrand;
    }

    public void setPrice(double newPrice) {
        price = newPrice;
    } 

    public void setProductName(String newName) {
        productName = newName;
    }

    public void setQuantity(int newQuantity) {
        quantity = newQuantity;
    }
    @Override
    public String toString() {
        return "(PRODUCT NAME: " + productName +
                " BRAND: " +productBrand+
                " PRICE: " + price +
                " QUANTITY: " + quantity + ")"+"\n\n";
    }

    public void addProduct(Stock stock) {
    }
}