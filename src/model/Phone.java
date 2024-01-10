package model;

import java.time.LocalDate;

public class Phone {
    private String name;
    private String price;

    public Phone() {
    }

    public Phone(String name, String price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Phone{" +
                ", name='" + name + '\'' +
                ", price='" + price + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
