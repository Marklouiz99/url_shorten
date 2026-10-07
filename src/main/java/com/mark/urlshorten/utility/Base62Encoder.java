package com.mark.urlshorten.utility;

public class Base62Encoder {
    private static final String BASE62_CHARACTERS = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    private Base62Encoder() {

    }

    public static String encode(long value) {
        //if(value < 0) {
            //throw new IllegalArgumentException("Value must be non-negative");
        //}
        if(value == 0) {
            return "0";
        }
        StringBuilder encoded = new StringBuilder();
        while (value > 0) {
            int remainder = (int) (value % 62);
            encoded.append(BASE62_CHARACTERS.charAt(remainder));
            value /= 62;
        }
        return encoded.reverse().toString();
    }
}
