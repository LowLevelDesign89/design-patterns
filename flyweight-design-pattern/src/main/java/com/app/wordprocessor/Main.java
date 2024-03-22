package com.app.wordprocessor;

public class Main {
    public static void main(String[] args) {
        ILetter tLetter = CharacterFactory.createLetter('t');
        tLetter.display(1,1);

        ILetter tLetter2 = CharacterFactory.createLetter('t');
        tLetter2.display(45, 45);
    }
}
