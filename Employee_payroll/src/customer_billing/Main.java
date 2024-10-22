package customer_billing;

import java.util.ArrayList;
import java.util.Scanner;

class Product {
    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}

class CustomerBillingSystem {
    private ArrayList<Product> products;
    private ArrayList<Product> cart;

    public CustomerBillingSystem() {
        products = new ArrayList<>();
        cart = new ArrayList<>();
    }

    public void addProduct(String name, double price) {
        Product product = new Product(name, price);
        products.add(product);
    }

    public void displayProducts() {
        System.out.println("Available Products:");
        for (int i = 0; i < products.size(); i++) {
            Product product = products.get(i);
            System.out.printf("%d. %s - $%.2f%n", (i + 1), product.getName(), product.getPrice());
        }
    }

    public void addToCart(int productIdx) {
        if (productIdx >= 1 && productIdx <= products.size()) {
            Product selectedProduct = products.get(productIdx - 1);
            cart.add(selectedProduct);
            System.out.println(selectedProduct.getName() + " added to cart.");
        } else {
            System.out.println("Invalid product number.");
        }
    }

    public double calculateTotal() {
        double total = 0;
        for (Product product : cart) {
            total += product.getPrice();
        }
        return total;
    }

    public void generateBill() {
        System.out.println("\nGenerating Bill...\n");
        for (int i = 0; i < cart.size(); i++) {
            Product product = cart.get(i);
            System.out.printf("%d. %s - $%.2f%n", (i + 1), product.getName(), product.getPrice());
        }
        double total = calculateTotal();
        System.out.printf("\nTotal: $%.2f%n", total);
    }
}

public class Main {
    public static void main(String[] args) {
        CustomerBillingSystem billingSystem = new CustomerBillingSystem();
        Scanner scanner = new Scanner(System.in);

        billingSystem.addProduct("Atta 1", 10.99);
        billingSystem.addProduct("Biscuit 2", 15.49);
        billingSystem.addProduct("Chocolate 3", 5.25);
        billingSystem.addProduct("Ghee 4", 29.99);

        while (true) {
            System.out.println("\n1. Display Products");
            System.out.println("2. Add to Cart");
            System.out.println("3. Generate Bill");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    billingSystem.displayProducts();
                    break;
                case 2:
                    billingSystem.displayProducts();
                    System.out.print("Enter the product number to add to cart: ");
                    int productIdx = scanner.nextInt();
                    billingSystem.addToCart(productIdx);
                    break;
                case 3:
                    billingSystem.generateBill();
                    scanner.close();
                    return;
                case 4:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        }
    }
}

