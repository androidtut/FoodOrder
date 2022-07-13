package com.example.foodorder.Models;

public class foodModels {
    int image;
    String price;
    String foodname,fooddesc;

    public foodModels(int image, String price, String foodname, String fooddesc) {
        this.image = image;
        this.price = price;
        this.foodname = foodname;
        this.fooddesc = fooddesc;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getFoodname() {
        return foodname;
    }

    public void setFoodname(String foodname) {
        this.foodname = foodname;
    }

    public String getFooddesc() {
        return fooddesc;
    }

    public void setFooddesc(String fooddesc) {
        this.fooddesc = fooddesc;
    }
}
