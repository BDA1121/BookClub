package com.example.thebookclub;
/**
 * Helper methods that I have used across the application.
 */
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class helpers {
    private String route = "https://localhost:4000/";
    /**
     * Generates a timestamp in the format 'yyyy-MM-dd HH:mm:ss'.
     *
     * @return Formatted timestamp string.
     */

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

    /**
     * Generates a unique ID based on the SHA-256 hash of the given input.
     *
     * @param input The input string to generate the ID from.
     * @return The generated ID as a hexadecimal string.
     */
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

    /**
     * Switches the scene in the application.
     * I have called this function in multiple places to facilitate navigation
     * @param fxmlFile   The FXML file to load.
     * @param title      The title of the new scene.
     * @param event      The ActionEvent triggering the scene switch.
     * @param controller The controller associated with the new scene.
     */

    public static void switchScene(String fxmlFile, String title, ActionEvent event, Object controller) {
        try {
            FXMLLoader loader = new FXMLLoader(helpers.class.getResource(fxmlFile));
            loader.setController(controller);
            Parent root = loader.load();

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root, 800, 600);
            stage.setTitle(title);
            scene.getStylesheets().add(helpers.class.getResource("styles.css").toExternalForm());
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
