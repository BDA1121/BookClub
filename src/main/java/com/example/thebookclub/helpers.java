package com.example.thebookclub;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class helpers {
    public static String getTimestamp(){
        Instant timestamp = Instant.now();
        System.out.println("Timestamp: " + timestamp);

        // Convert the timestamp to a date and time
        LocalDateTime datetime = LocalDateTime.ofInstant(timestamp, ZoneId.systemDefault());
        System.out.println("Date and Time: " + datetime);

        // Format the date and time as a string
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDateTime = datetime.format(formatter);
        System.out.println("Formatted Date and Time: " + formattedDateTime);
        return formattedDateTime;
    }
    public static String generateID(String input) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(input.getBytes(StandardCharsets.UTF_8));

            // Convert the byte array to a hexadecimal string
            StringBuilder hexString = new StringBuilder();
            for (byte b : hash) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }

            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }
}
