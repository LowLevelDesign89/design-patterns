package com.app.vm.models;

public class Inventory {
    private ItemShelf[] shelfs;
    private int size;

    public Inventory(int size) {
        this.size = size;
        this.shelfs = new ItemShelf[size];
        initiateInventory();
    }

    public void addItem(Item item, int codeNumber) {
        for(ItemShelf currentShelf: shelfs) {
            if(currentShelf.getItemCode() == codeNumber) {
                if(currentShelf.isSoldOut()) {
                    currentShelf.setItem(item);
                    currentShelf.setSoldOut(false);
                } else {
                    throw new RuntimeException("Item already present, add once space is available");
                }
            }
        }
    }

    public void updateSoldOutItem(int codeNumber) {
        for(ItemShelf currentShelf: shelfs) {
            if(currentShelf.getItemCode() == codeNumber) {
                currentShelf.setSoldOut(true);
            }
        }
    }

    public ItemShelf[] getInventory() {
        return this.shelfs;
    }

    public Item getItem(int codeNumber) {
        for(ItemShelf currentShelf: shelfs) {
            if(currentShelf.getItemCode() == codeNumber) {
                if(currentShelf.isSoldOut()) {
                    throw new RuntimeException("Item is already sold out !!!!");
                } else {
                    return currentShelf.getItem();
                }
            }
        }
        return null;
    }

    private void initiateInventory() {
        int startCode = 101;
        for(int i = 0; i < size; i++) {
            ItemShelf itemShelf = new ItemShelf();
            itemShelf.setSoldOut(true);
            itemShelf.setItemCode(startCode);
            shelfs[i] = itemShelf;
            startCode++;
        }
    }
}
