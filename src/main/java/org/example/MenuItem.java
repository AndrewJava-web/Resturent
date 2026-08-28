package org.example;

public class MenuItem {

    private final int id;
    private String name;
    private double price;
    private String category;

    public MenuItem(int id, String name) {
        this(id, name, 0.0, null);
    }

    public MenuItem(int id, String name, double price, String category) {

        if (id <= 0) {
            throw new IllegalArgumentException("ID must be greater than 0");
        }

        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }

        if (price < 0) {
            throw new IllegalArgumentException("Price cannot be negative");
        }

        if (category == null || category.trim().isEmpty()) {
            throw new IllegalArgumentException("Category cannot be empty");
        }

        this.id = id;
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }

        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price < 0) {
            throw new IllegalArgumentException("Price cannot be negative");
        }

        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        if (category == null || category.trim().isEmpty()) {
            throw new IllegalArgumentException("Category cannot be empty");
        }

        this.category = category;
    }

    @Override
    public String toString() {
        return "MenuItem{" +
                "id = " + id +
                ", name = '" + name + '\'' +
                ", price = " + price +
                ", category = '" + category + '\'' +
                '}';
    }
}