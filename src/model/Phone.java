package model;

import java.time.LocalDate;

public class Phone {
    private int id;
    private String name;
    private int price;
    private int quantity;
    private String describe;
    private LocalDate dateOfPurchase;

    public Phone() {
    }

    public Phone(String name, int price, int quantity, String describe, String dateOfPurchase) {
        this.id = id++;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.describe = describe;
        this.dateOfPurchase = LocalDate.parse(dateOfPurchase);
    }

    public LocalDate getDateOfPurchase() {
        return dateOfPurchase;
    }

    public void setDateOfPurchase(LocalDate dateOfPurchase) {
        this.dateOfPurchase = dateOfPurchase;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }
}
