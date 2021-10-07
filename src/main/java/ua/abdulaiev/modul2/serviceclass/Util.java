package ua.abdulaiev.modul2.serviceclass;

import java.util.Random;

public class Util {
    public static int randomInt(int max) {
        return new Random().nextInt(max);
    }

    public static String randomString(int maxLength) {
        char[] chars = "abcdefghijklmnoprstuvwxyz".toCharArray();
        StringBuilder stringBuilder = new StringBuilder();

        for (;maxLength > 0; maxLength--) {
            stringBuilder.append(chars[randomInt(chars.length)]);
        }

        return stringBuilder.toString();
    }
}