package Java_Day6;

import java.util.*;
class ProductManager {
    private Set<Product> productSet = new HashSet<>();

    public boolean addProduct(Product product) {
        if (productSet.add(product)) {
            System.out.println(" Product added: " + product);
            return true;
        } else {
            System.out.println(" Duplicate product not added (ID already exists).");
            return false;
        }
    }

    public void showAllProducts() {
        if (productSet.isEmpty()) {
            System.out.println(" No products available.");
            return;
        }
        System.out.println("Product List:");
        for (Product p : productSet) {
            System.out.println(p);
        }
    }

    public boolean updateProduct(int id, String name, String category, double price) {
        for (Product p : productSet) {
            if (p.getId() == id) {
                p.setName(name);
                p.setCategory(category);
                p.setPrice(price);
                System.out.println("Product updated.");
                return true;
            }
        }
        System.out.println("Product not found.");
        return false;
    }

    // Delete a product
    public boolean deleteProduct(int id) {
        Product toRemove = null;
        for (Product p : productSet) {
            if (p.getId() == id) {
                toRemove = p;
                break;
            }
        }
        if (toRemove != null) {
            productSet.remove(toRemove);
            System.out.println(" Product removed.");
            return true;
        } else {
            System.out.println("Product not found.");
            return false;
        }
    }

    public void sortById() {
        List<Product> list = new ArrayList<>(productSet);
        list.sort(Comparator.comparingInt(Product::getId));
        System.out.println("Products Sorted by ID:");
        list.forEach(System.out::println);
    }

    public void sortByName() {
        List<Product> list = new ArrayList<>(productSet);
        list.sort(Comparator.comparing(Product::getName));
        System.out.println("Products Sorted by Name:");
        list.forEach(System.out::println);
    }
}
class Product {
    private int id;
    private String name;
    private String category;
    private double price;

    public Product(int id, String name, String category, double price) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean equals(Object o){
        if(this == o)return true;
        if(!(o instanceof Product)) return false;
        Product product = (Product)o;
        return id == product.id;
    }

    public int hashCode(){
        return Objects.hash(id);
    }

    public String toString() {
        return "[" + id + "," + name + "," + category + ", $" + price + "]";
    }
}

public class ProductManagementSystem {
    public static void main(String[] args) {
        ProductManager manager = new ProductManager();

        manager.addProduct(new Product(1, "Laptop", "Electronics", 1200.50));
        manager.addProduct(new Product(2, "Phone", "Electronics", 850.00));
        manager.addProduct(new Product(1, "Tablet", "Electronics", 600.00)); // duplicate

        System.out.println();

        manager.showAllProducts();

        System.out.println();

        manager.updateProduct(2, "Smartphone", "Gadgets", 890.00);

        System.out.println();

        manager.sortByName();
        System.out.println();
        manager.sortById();

        System.out.println();

        manager.deleteProduct(1);

        System.out.println();

        manager.showAllProducts();
    }
}
