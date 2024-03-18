package com.app.vm.models;

public class ItemShelf {
    private Item item;
    private int itemCode;
    private boolean isSoldOut;

    public ItemShelf() {

    }

    public ItemShelf(Item item, int itemCode, boolean isSoldOut) {
        this.item = item;
        this.itemCode = itemCode;
        this.isSoldOut = isSoldOut;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public int getItemCode() {
        return itemCode;
    }

    public void setItemCode(int itemCode) {
        this.itemCode = itemCode;
    }

    public boolean isSoldOut() {
        return isSoldOut;
    }

    public void setSoldOut(boolean soldOut) {
        isSoldOut = soldOut;
    }
}
