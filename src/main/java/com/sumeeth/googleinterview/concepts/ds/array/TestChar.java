package com.sumeeth.googleinterview.concepts.ds.array;

import java.util.HashMap;
import java.util.Map;

public class TestChar {

    public static void main(String[] args) {
//        String key = "the quick brown fox jumps over the lazy dog";
//        String message = "vkbs bs t suepuv";

        String key = "eljuxhpwnyrdgtqkviszcfmabo";
        String message = "zwx hnfx lqantp mnoeius ycgk vcnjrdb";
        System.out.println(decodeMessage(key, message));
    }

    public static String decodeMessage(String key, String message) {

        Map<Character, Character> keyMap = createKeyMap(key);
        StringBuilder decryptedMessage = new StringBuilder();
        keyMap.keySet().stream().sorted().forEach(e -> System.out.println(e + "->" + keyMap.get(e)));
        for (Character ch : message.toCharArray()) {
            decryptedMessage.append(keyMap.get(ch));
        }

        return decryptedMessage.toString();

    }

    private static Map<Character, Character> createKeyMap(String key) {
        Map<Character, Character> keyMap = new HashMap();
        keyMap.put(' ', ' ');
        int smallCaseStartIndex = 97;  //97+25 will give you 'z'
        for (int i = 0; i < key.length() && smallCaseStartIndex <= 122; i++) {
            if (keyMap.get(key.charAt(i)) == null && key.charAt(i) != ' ') {
                keyMap.put(key.charAt(i), Character.valueOf((char) smallCaseStartIndex));
                smallCaseStartIndex++;
            }
        }

        return keyMap;

    }
}
