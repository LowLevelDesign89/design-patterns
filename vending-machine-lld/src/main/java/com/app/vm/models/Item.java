package com.app.vm.models;

public class Item {
    private ItemType itemType;
    private int price;

    public Item() {

    }

    public Item(ItemType itemType, int price) {
        this.itemType = itemType;
        this.price = price;
    }

    public ItemType getItemType() {
        return itemType;
    }

    public int getPrice() {
        return price;
    }

    public void setItemType(ItemType itemType) {
        this.itemType = itemType;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
