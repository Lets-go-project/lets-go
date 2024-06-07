package com.example.letsGo.domain.market;

import java.io.Serializable;
import java.util.Date;

public class Order implements Serializable {
    private int orderId;
    private int price;
    private Date date;
    private int status;
    private String name;
    private int zipcode;
    private String address;
    private String address2;
    private String phone;
    private String req;
    private int productCount; public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getZipcode() {
        return zipcode;
    }

    public void setZipcode(int zipcode) {
        this.zipcode = zipcode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getReq() {
        return req;
    }

    public void setReq(String req) {
        this.req = req;
    }

    public int getProductCount() {
        return productCount;
    }

    public void setProductCount(int productCount) {
        this.productCount = productCount;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", price=" + price +
                ", date=" + date +
                ", status=" + status +
                ", name='" + name + '\'' +
                ", zipcode=" + zipcode +
                ", address='" + address + '\'' +
                ", address2='" + address2 + '\'' +
                ", phone='" + phone + '\'' +
                ", req='" + req + '\'' +
                ", productCount=" + productCount +
                '}';
    }
}
