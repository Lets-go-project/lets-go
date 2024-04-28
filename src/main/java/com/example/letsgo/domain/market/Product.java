package com.example.letsgo.domain.market;

import java.io.Serializable;

public class Product implements Serializable {
    private int productId;
    private int productType;
    private String productName;
    private int productPrice;
    private int productSellPrice;
    private boolean productState;
    private String productDescription;
    private String productImg;
    private String productSemiImg;

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getProductType() {
        return productType;
    }

    public void setProductType(int productType) {
        this.productType = productType;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(int productPrice) {
        this.productPrice = productPrice;
    }

    public int getProductSellPrice() {
        return productSellPrice;
    }

    public void setProductSellPrice(int productSellPrice) {
        this.productSellPrice = productSellPrice;
    }

    public boolean isProductState() {
        return productState;
    }

    public void setProductState(boolean productState) {
        this.productState = productState;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public String getProductImg() {
        return productImg;
    }

    public void setProductImg(String productImg) {
        this.productImg = productImg;
    }

    public String getProductSemiImg() {
        return productSemiImg;
    }

    public void setProductSemiImg(String productSemiImg) {
        this.productSemiImg = productSemiImg;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", productType=" + productType +
                ", productName='" + productName + '\'' +
                ", productPrice=" + productPrice +
                ", productSellPrice=" + productSellPrice +
                ", productState=" + productState +
                ", productDescription='" + productDescription + '\'' +
                ", productImg='" + productImg + '\'' +
                ", productSemiImg='" + productSemiImg + '\'' +
                '}';
    }
}
