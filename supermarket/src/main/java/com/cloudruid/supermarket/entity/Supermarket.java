package com.cloudruid.supermarket.entity;

import javax.persistence.*;

@Entity
@Table(name = "SUPERMARKET")
public class Supermarket {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    @Column(name = "item")
    private String item;

    @Column(name = "price")
    private int price;

    @Column(name = "promotion1")
    private boolean promotion1;

    @Column(name = "promotion2")
    private boolean promotion2;

    public Supermarket() {
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public boolean isPromotion1() {
        return promotion1;
    }

    public void setPromotion1(boolean promotion1) {
        this.promotion1 = promotion1;
    }

    public boolean isPromotion2() {
        return promotion2;
    }

    public void setPromotion2(boolean promotion2) {
        this.promotion2 = promotion2;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
