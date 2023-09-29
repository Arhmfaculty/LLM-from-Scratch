import java.util.ArrayList;

/**
 * An inventory class that inherits from the Stock class.
 * The inventory is where all the products in the shop are being kept.
 */
class Inventories extends Stock {
    // Fields
    private ArrayList<Stock> inventories; // maintain lists of stocks in the inventory
    ArrayList<CartItem> cartItems;

    // Constructor
    public Inventories() {
        super("", "", 0.0, 0);
        inventories = new ArrayList<Stock>();
        ArrayList<CartItem> cartItems;
    }

    // Methods
    /**
     * Adds a product to the inventory.
     *
     * @param productName the name of the product
     * @param productBrand the brand of the product
     * @param price the price of the product
     * @param quantity the quantity of the product
     */
    public void addProduct(String productName, String productBrand, double price, int quantity) {
        Stock product = getProductByName(productName, productBrand);
        if (product != null) {
            product.setQuantity(product.getQuantity() + quantity);
            product.setPrice(price);
        } else {
            product = new Stock(productName, productBrand, price, quantity);
            inventories.add(product);
        }
    }


    /**
     * Adds multiple products to the inventory.
     *
     * @param products a list of products to be added to the inventory
     */
    public void addProducts(ArrayList<Stock> products) {
        for (Stock product : products) {
            String name = product.getProductName();
            String brand = product.getProductBrand();
            double price = product.getPrice();
            int quantity = product.getQuantity();

            addProduct(name, brand, price, quantity);
        }
    }

    /**
     * Removes a product from the inventory.
     *
     * @param productName the name of the product
     * @param productBrand the brand of the product
     * @return true if the product was removed, false otherwise
     */
    public boolean removeProduct(String productName, String productBrand) {
        Stock product = getProductByName(productName, productBrand);
        if (product != null) {
            inventories.remove(product);
            return true;
        }
        return false;
    }

    /**
     * Returns the list of products in the inventory.
     *
     * @return the list of products in the inventory
     */
    public ArrayList<Stock> getInventory() {
        return inventories;
    }

    /**
     * Gets the product with the specified name and brand.
     *
     * @param productName the name of the product
     * @param productBrand the brand of the product
     * @return the product with the specified name and brand, or null if not found
     */
    public Stock getProductByName(String productName, String productBrand) {
        for (Stock product : inventories) {
            if (product.getProductName().equals(productName) && product.getProductBrand().equals(productBrand)) {
                return product;
            }
        }
        return null;
    }
    public boolean purchaseProduct(String name, String brand, int quantity) {
        for (Stock product : inventories) {
            if (product.getProductName().equals(name) && product.getProductBrand().equals(brand)) {
                int availableQuantity = product.getQuantity();
                if (availableQuantity >= quantity) {
                    product.setQuantity(availableQuantity - quantity);
                    return true; // Purchase successful
                } else {
                    return false; // Insufficient quantity in inventory
                }
            }
        }
        return false; // Product not found in inventory
    }
    public String displayInventory() {
        if (inventories.isEmpty()) {
            return "No products in the inventory.";
        }

        StringBuilder inventoryText = new StringBuilder("Available Inventory:\n");
        for (Stock product : inventories) {
            inventoryText.append("Product name: ").append(product.getProductName()).append("\n")
                    .append("Product brand: ").append(product.getProductBrand()).append("\n")
                    .append("Quantity: ").append(product.getQuantity()).append("\n")
                    .append("Price: ").append(product.getPrice()).append("\n\n");
        }
        return inventoryText.toString();
    }




    /**
     * Returns a string representation of the inventory.
     *
     * @return a string representation of the inventory
     */
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (Stock product : inventories) {
            result.append("Product name: ").append(product.getProductName()).append("\n")
                    .append("Product brand: ").append(product.getProductBrand()).append("\n")
                    .append("Quantity: ").append(product.getQuantity()).append("\n")
                    .append("Price: ").append(product.getPrice()).append("\n\n");
        }
        return result.toString();
    }

}