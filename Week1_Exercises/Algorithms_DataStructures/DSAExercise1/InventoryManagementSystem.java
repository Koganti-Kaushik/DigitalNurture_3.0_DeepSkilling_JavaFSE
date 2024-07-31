package DSAExercise1;
import java.util.HashMap;
import java.util.Map;

public class InventoryManagementSystem {

    public static class Product {
        private String productId;
        private String productName;
        private int quantity;
        private double price;

        public Product(String productId, String productName, int quantity, double price) {
            this.productId = productId;
            this.productName = productName;
            this.quantity = quantity;
            this.price = price;
        }

        public String getProductId() { return productId; }
        public void setProductId(String productId) { this.productId = productId; }
        public String getProductName() { return productName; }
        public void setProductName(String productName) { this.productName = productName; }
        public int getQuantity() { return quantity; }
        public void setQuantity(int quantity) { this.quantity = quantity; }
        public double getPrice() { return price; }
        public void setPrice(double price) { this.price = price; }

        @Override
        public String toString() {
            return "Product ID: " + productId + ", Name: " + productName +
                    ", Quantity: " + quantity + ", Price: $" + price;
        }
    }

    public static class InventoryManagement {
        private Map<String, Product> products = new HashMap<>();

        public void addNewProduct(Product product) {
            products.put(product.getProductId(), product);
        }

        public void modifyProduct(String productId, Product updatedProduct) {
            if (products.containsKey(productId)) {
                products.put(productId, updatedProduct);
            }
        }

        public void removeProduct(String productId) {
            products.remove(productId);
        }

        public Product fetchProduct(String productId) {
            return products.get(productId);
        }

        public void listAllProducts() {
            for (Product product : products.values()) {
                System.out.println(product);
            }
        }
    }

    public static void main(String[] args) {
        InventoryManagement inventoryManagement = new InventoryManagement();

        Product item1 = new Product("A123", "Gaming Laptop", 15, 1199.99);
        Product item2 = new Product("B456", "Wireless Earbuds", 30, 129.99);
        Product item3 = new Product("C789", "Smartwatch", 20, 249.99);

        inventoryManagement.addNewProduct(item1);
        inventoryManagement.addNewProduct(item2);
        inventoryManagement.addNewProduct(item3);

        System.out.println("Current Product List:");
        inventoryManagement.listAllProducts();

        Product updatedItem = new Product("B456", "Wireless Earbuds", 25, 109.99);
        inventoryManagement.modifyProduct("B456", updatedItem);

        System.out.println("\nProduct List After Update:");
        inventoryManagement.listAllProducts();

        inventoryManagement.removeProduct("C789");

        System.out.println("\nFinal Product List:");
        inventoryManagement.listAllProducts();
    }
}
