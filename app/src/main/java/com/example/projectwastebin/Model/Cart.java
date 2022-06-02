package com.example.projectwastebin.Model;

public class Cart {

    private String pid, pname, price, quantity, discount, sellerAddress, sellerName, sellerPhone, sellerEmail, paddress, pdistrict;

    public Cart() {
    }

    public Cart(String pid, String pname, String price, String quantity, String discount, String sellerAddress, String sellerName, String sellerPhone, String sellerEmail, String paddress, String pdistrict) {
        this.pid = pid;
        this.pname = pname;
        this.price = price;
        this.quantity = quantity;
        this.discount = discount;
        this.sellerAddress = sellerAddress;
        this.sellerName = sellerName;
        this.sellerPhone = sellerPhone;
        this.sellerEmail = sellerEmail;
        this.paddress = paddress;
        this.pdistrict = pdistrict;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public String getSellerAddress() {
        return sellerAddress;
    }

    public void setSellerAddress(String sellerAddress) {
        this.sellerAddress = sellerAddress;
    }

    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }

    public String getSellerPhone() {
        return sellerPhone;
    }

    public void setSellerPhone(String sellerPhone) {
        this.sellerPhone = sellerPhone;
    }

    public String getSellerEmail() {
        return sellerEmail;
    }

    public void setSellerEmail(String sellerEmail) {
        this.sellerEmail = sellerEmail;
    }

    public String getPaddress() {
        return paddress;
    }

    public void setPaddress(String paddress) {
        this.paddress = paddress;
    }

    public String getPdistrict() {
        return pdistrict;
    }

    public void setPdistrict(String pdistrict) {
        this.pdistrict = pdistrict;
    }
}
