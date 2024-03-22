package com.app.wordprocessor;

public class DocumentCharacter implements ILetter {
    char character;
    String fontType;
    int size;

    public DocumentCharacter(char character, String fontType, int size) {
        this.character = character;
        this.fontType = fontType;
        this.size = size;
    }

    public char getCharacter() {
        return character;
    }

    public String getFontType() {
        return fontType;
    }

    public int getSize() {
        return size;
    }

    @Override
    public void display(int row, int column) {
        System.out.println("Character ch " + character + " is displayed at [" + row + "," + column + "]");
    }
}
