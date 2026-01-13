package vending_machine_v2.entity;

import vending_machine_v2.enums.ProductType;

public class Product {

    private int id;
    private String name;
    private ProductType productType;
    private double price;

    public Product(int id, String name, ProductType productType, double price) {
        this.id = id;
        this.name = name;
        this.productType = productType;
        this.price = price;
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

    public ProductType getProductType() {
        return productType;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
