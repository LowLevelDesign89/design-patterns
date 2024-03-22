package com.app.wordprocessor;

import java.util.HashMap;
import java.util.Map;

public class CharacterFactory {
    private static Map<Character, ILetter> characterCache = new HashMap<>();

    public static ILetter createLetter(char ch) {
        if(characterCache.containsKey(ch))
            return characterCache.get(ch);
        else {
            ILetter letter = new DocumentCharacter(ch, "Arial", 10);
            characterCache.put(ch, letter);
            return letter;
        }
    }
}
