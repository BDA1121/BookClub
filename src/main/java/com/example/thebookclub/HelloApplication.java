package com.example.thebookclub;
/**
 * The main entry point of the application.
 * This is a MVC design paradigm based application
 */

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    /**
     * Starts the application by loading the login.fxml file(with a set of specified configurations
     * such as controller,styles,etc.) and setting up the scene.
     *
     * @param stage The primary stage for the application.
     * @throws IOException If the FXMLLoader encounters an I/O problem.
     */
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("login.fxml"));
        fxmlLoader.setController(new LoginController());
        Scene scene = new Scene(fxmlLoader.load(), 800, 600);
        stage.setTitle("The Book Club /Login");
        scene.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
    }
    /**
     * The main method that launches my JavaFX application(The Book Club).
     *
     */
    public static void main(String[] args) {
        launch();
    }
}