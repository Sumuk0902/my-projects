import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Product {
    private String name;
    private int quantity;

    public Product(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Product: " + name + ", Quantity: " + quantity;
    }
}

public class InventoryManagementSystem {
    private List<Product> inventory;

    public InventoryManagementSystem() {
        inventory = new ArrayList<>();
    }

    public void addProduct(String name, int quantity) {
        for (Product product : inventory) {
            if (product.getName().equals(name)) {
                product.setQuantity(product.getQuantity() + quantity);
                return;
            }
        }
        inventory.add(new Product(name, quantity));
    }

    public void removeProduct(String name, int quantity) {
        for (Product product : inventory) {
            if (product.getName().equals(name)) {
                if (product.getQuantity() >= quantity) {
                    product.setQuantity(product.getQuantity() - quantity);
                    return;
                } else {
                    System.out.println("Not enough quantity to remove.");
                    return;
                }
            }
        }
        System.out.println("Product not found in inventory.");
    }

    public void listProducts() {
        System.out.println("Current Inventory:");
        for (Product product : inventory) {
            System.out.println(product);
        }
    }

    public static void main(String[] args) {
        InventoryManagementSystem ims = new InventoryManagementSystem();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nInventory Management System");
            System.out.println("1. Add Product");
            System.out.println("2. Remove Product");
            System.out.println("3. List Products");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter product name: ");
                    String productName = scanner.next();
                    System.out.print("Enter product quantity: ");
                    int productQuantity = scanner.nextInt();
                    ims.addProduct(productName, productQuantity);
                    break;
                case 2:
                    System.out.print("Enter product name: ");
                    productName = scanner.next();
                    System.out.print("Enter product quantity to remove: ");
                    productQuantity = scanner.nextInt();
                    ims.removeProduct(productName, productQuantity);
                    break;
                case 3:
                    ims.listProducts();
                    break;
                case 4:
                    System.out.println("Exiting Inventory Management System.");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
