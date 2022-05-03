package com.codegym.entity;

public class Product {
    private String id;
    private String productName;
    private double productPrice;
    private String productDescribe;
    private String producer;

    public Product() {
    }

    public Product(String id, String productName, double productPrice, String productDescribe, String producer) {
        this.id = id;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productDescribe = productDescribe;
        this.producer = producer;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductDescribe() {
        return productDescribe;
    }

    public void setProductDescribe(String productDescribe) {
        this.productDescribe = productDescribe;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }
}
