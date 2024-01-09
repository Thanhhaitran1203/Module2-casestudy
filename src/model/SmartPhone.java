package model;

import java.time.LocalDate;

public class SmartPhone extends Phone implements Discount,Warranty{
    private String operatingSystem;

    @Override
    public double getRealMoney() {
        return getPrice()*getQuantity()*0.9;
    }

    @Override
    public LocalDate getWarrantyPeriod() {
        return getDateOfPurchase().plusYears(1);
    }

    public SmartPhone(String operatingSystem) {
    }

    public SmartPhone(String name, int price, int quantity, String describe, String dateOfPurchase, String operatingSystem) {
        super(name, price, quantity, describe, dateOfPurchase);
        this.operatingSystem = operatingSystem;
    }
}
