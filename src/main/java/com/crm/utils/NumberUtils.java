package com.crm.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

/**
 *
 */
public class NumberUtils {

    public static String generateContractNumber() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        String timePart = LocalDateTime.now().format(formatter);
        String randomPart = generateNumber(4);
        return "HT" + timePart + randomPart;
    }

    public static String generateNumber(int length) {
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(chars.length());
            char c = chars.charAt(index);
            sb.append(c);
        }
        return sb.toString();
    }
}
