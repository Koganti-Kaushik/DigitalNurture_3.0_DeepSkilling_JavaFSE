package DSAExercise2;

import java.util.Arrays;

public class EcommerceSearch {

    public static class Product {
        private String productId;
        private String productName;
        private String category;

        public Product(String productId, String productName, String category) {
            this.productId = productId;
            this.productName = productName;
            this.category = category;
        }

        public String getProductId() { return productId; }
        public void setProductId(String productId) { this.productId = productId; }
        public String getProductName() { return productName; }
        public void setProductName(String productName) { this.productName = productName; }
        public String getCategory() { return category; }
        public void setCategory(String category) { this.category = category; }

        @Override
        public String toString() {
            return "ID: " + productId + ", Name: " + productName + ", Category: " + category;
        }
    }

    public static class SearchHelper {
        public static Product searchByName(Product[] inventory, String nameToFind) {
            for (Product item : inventory) {
                if (item.getProductName().equalsIgnoreCase(nameToFind)) {
                    return item;
                }
            }
            return null;
        }

        public static Product findProductBinary(Product[] inventory, String nameToFind) {
            int start = 0;
            int end = inventory.length - 1;
            while (start <= end) {
                int mid = start + (end - start) / 2;
                int comparison = inventory[mid].getProductName().compareToIgnoreCase(nameToFind);
                if (comparison == 0) {
                    return inventory[mid];
                } else if (comparison < 0) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
            return null;
        }

        public static void arrangeByName(Product[] inventory) {
            Arrays.sort(inventory, (a, b) -> a.getProductName().compareToIgnoreCase(b.getProductName()));
        }
    }

    public static void main(String[] args) {
        Product[] inventory = {
                new Product("B002", "Monitor", "Electronics"),
                new Product("B001", "Keyboard", "Accessories"),
                new Product("B003", "Mouse", "Accessories")
        };

        System.out.println("Initial Inventory:");
        for (Product item : inventory) {
            System.out.println(item);
        }

        Product searchResult = SearchHelper.searchByName(inventory, "Keyboard");
        System.out.println("\nSearch Result:");
        System.out.println(searchResult != null ? searchResult : "Item not found");

        SearchHelper.arrangeByName(inventory);
        System.out.println("\nInventory After Sorting:");
        for (Product item : inventory) {
            System.out.println(item);
        }

        searchResult = SearchHelper.findProductBinary(inventory, "Mouse");
        System.out.println("\nBinary Search Result:");
        System.out.println(searchResult != null ? searchResult : "Item not found");

        searchResult = SearchHelper.findProductBinary(inventory, "Printer");
        System.out.println("\nBinary Search Result for 'Printer':");
        System.out.println(searchResult != null ? searchResult : "Item not found");
    }
}
