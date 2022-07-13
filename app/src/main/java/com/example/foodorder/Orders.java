package com.example.foodorder;

public class Orders {
    String Orderprice,desc,foodname,solditemName,orderNumber;
    int quantity,orderfoodimage;

    public Orders(String orderprice, String desc, String foodname, String solditemName, String orderNumber, int orderfoodimage, int quantity) {
        Orderprice = orderprice;
        this.desc = desc;
        this.foodname = foodname;
        this.solditemName = solditemName;
        this.orderNumber = orderNumber;
        this.orderfoodimage = orderfoodimage;
        this.quantity = quantity;
    }

    public String getOrderprice() {
        return Orderprice;
    }

    public void setOrderprice(String orderprice) {
        Orderprice = orderprice;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getFoodname() {
        return foodname;
    }

    public void setFoodname(String foodname) {
        this.foodname = foodname;
    }

    public String getSolditemName() {
        return solditemName;
    }

    public void setSolditemName(String solditemName) {
        this.solditemName = solditemName;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public int getOrderfoodimage() {
        return orderfoodimage;
    }

    public void setOrderfoodimage(int orderfoodimage) {
        this.orderfoodimage = orderfoodimage;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
