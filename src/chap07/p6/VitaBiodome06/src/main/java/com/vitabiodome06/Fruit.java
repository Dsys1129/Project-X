package com.vitabiodome06;

public class Fruit {
    private String name;
    private int price;
    private int stock;

    public Fruit(String name, int price, int stock) {
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    public int getStock() {
        return stock;
    }

    public int getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public void addStock(int quantity) {
        this.stock += quantity;
    }
}
