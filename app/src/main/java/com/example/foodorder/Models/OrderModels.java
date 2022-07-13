package com.example.foodorder.Models;

public class OrderModels {
    int orderfoodimage;
    String Orderprice;
    String foodname,orderNumber;

    public OrderModels(){}


    public OrderModels(int orderfoodimage, String orderprice, String foodname, String orderNumber) {
        this.orderfoodimage = orderfoodimage;
        Orderprice = orderprice;
        this.foodname = foodname;
        this.orderNumber = orderNumber;
    }

    public int getOrderfoodimage() {
        return orderfoodimage;
    }

    public void setOrderfoodimage(int orderfoodimage) {
        this.orderfoodimage = orderfoodimage;
    }

    public String getOrderprice() {
        return Orderprice;
    }

    public void setOrderprice(String orderprice) {
        Orderprice = orderprice;
    }

    public String getFoodname() {
        return foodname;
    }

    public void setFoodname(String foodname) {
        this.foodname = foodname;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }
}

