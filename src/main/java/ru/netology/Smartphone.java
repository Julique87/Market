package ru.netology;

public class Smartphone extends Product {
    private String company;

    public Smartphone(int id, String name, int price, String company) {
        super(id, name, price);
        this.company = company;
    }

    public String getCompany() {
        return company;
    }
}
