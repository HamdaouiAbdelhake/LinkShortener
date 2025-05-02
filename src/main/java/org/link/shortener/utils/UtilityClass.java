package org.link.shortener.utils;

public class UtilityClass {

    public static String base62Encoder(long id){
        String base62 = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        StringBuilder encoded = new StringBuilder();
        while (id > 0){
            int remainder = (int) id % 62;
            encoded.insert(0,base62.charAt(remainder));
            id /= 62;
        }
        while (encoded.length()<6){
            encoded.insert(0,0);
        }
        return encoded.reverse().toString();
    }
}
