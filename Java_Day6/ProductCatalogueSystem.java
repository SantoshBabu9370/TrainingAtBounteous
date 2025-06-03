package Java_Day6;

import java.util.*;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;
        Product product = (Product) o;
        return id == product.id;
    }


    public int hashCode(){
        return Objects.hash(id);
    }

    public String toString() {
        return "[" + id + "," + name + "," + category + ", $" + price + "]";
    }
}
class Manager {
    private Map<Product, Integer> productMap = new HashMap<>();

    public void addProduct(Product product, int quantity) {
        if (!productMap.containsKey(product)) {
            productMap.put(product, quantity);
            System.out.println("Product added to catalogue: " + product + ", Quantity: " + quantity);
        } else {
            System.out.println("Duplicate product not added.");
        }
    }

    public boolean updateQuantity(int id, int newQuantity) {
        for (Product p : productMap.keySet()) {
            if (p.getId() == id) {
                productMap.put(p, newQuantity);
                System.out.println("Quantity updated.");
                return true;
            }
        }
        System.out.println("Product not found.");
        return false;
    }

    public boolean updateProductDetails(int id, String name, String category, double price) {
        for (Product p : productMap.keySet()) {
            if (p.getId() == id) {
                p.setName(name);
                p.setCategory(category);
                p.setPrice(price);
                System.out.println("Product details updated.");
                return true;
            }
        }
        System.out.println("Product not found.");
        return false;
    }

    public boolean deleteProduct(int id) {
        Product toRemove = null;
        for (Product p : productMap.keySet()) {
            if (p.getId() == id) {
                toRemove = p;
                break;
            }
        }
        if (toRemove != null) {
            productMap.remove(toRemove);
            System.out.println("Product removed from catalogue.");
            return true;
        } else {
            System.out.println("Product not found.");
            return false;
        }
    }
    public void showCatalogue() {
        if (productMap.isEmpty()) {
            System.out.println("Catalogue is empty.");
            return;
        }
        System.out.println("Product Catalogue:");
        for (Map.Entry<Product, Integer> entry : productMap.entrySet()) {
            System.out.println(entry.getKey() + " | Quantity: " + entry.getValue());
        }
    }
    public void sortById() {
        List<Product> sortedList = new ArrayList<>(productMap.keySet());
        sortedList.sort(Comparator.comparingInt(Product::getId));
        System.out.println("Catalogue Sorted by ID:");
        for (Product p : sortedList) {
            System.out.println(p + " | Quantity: " + productMap.get(p));
        }
    }

    public void sortByName() {
        List<Product> sortedList = new ArrayList<>(productMap.keySet());
        sortedList.sort(Comparator.comparing(Product::getName));
        System.out.println("Catalogue Sorted by Name:");
        for (Product p : sortedList) {
            System.out.println(p + " | Quantity: " + productMap.get(p));
        }
    }
}
public class ProductCatalogueSystem {
    public static void main(String[] args) {
        Manager catalogue = new Manager();
        Product p1 = new Product(100, "Monitor", "Electronics", 250.00);
        Product p2 = new Product(101, "Mouse", "Accessories", 20.00);
        Product p3 = new Product(100, "Monitor Duplicate", "Electronics", 260.00);
        catalogue.addProduct(p1, 5);
        catalogue.addProduct(p2, 50);
        catalogue.addProduct(p3, 2);  
        System.out.println();
        catalogue.showCatalogue();
        System.out.println();
        catalogue.updateQuantity(101, 70);
        catalogue.updateProductDetails(100, "LED Monitor", "Display", 270.00);
        System.out.println();
        catalogue.sortByName();
        System.out.println();
        catalogue.sortById();
        System.out.println();
        catalogue.deleteProduct(101);
        System.out.println();
        catalogue.showCatalogue();
    }
}
