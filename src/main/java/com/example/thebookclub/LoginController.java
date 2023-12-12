package com.example.thebookclub;
/**
 * Controller for handling login.fxml/signup.fxml functionality.
 */
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class LoginController {
    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Label errorLabel;
    /**
     * Handles the action when the signup button is clicked.
     * Adds the user using the method implemented in controller
     * @param event The ActionEvent triggered by the signup button.
     */
    @FXML
    private void SignupAction(ActionEvent event) {
        String username = usernameField.getText();
        String password = passwordField.getText();

        controller controller = new controller();
        user user = new user(username,password,false);
        String response = controller.adduser(user);
        if(Objects.equals(response, "created")){
            goToHome(event);

        }else{
            errorLabel.setText("User exists");
        }

    }

    /**
     * Handles the action when the login button is clicked.
     *
     * @param event The ActionEvent triggered by the login button.
     */

    @FXML
    private void loginAction(ActionEvent event) {
        String username = usernameField.getText();
        String password = passwordField.getText();

        boolean isAuthenticated = authenticate(username, password);

        if (isAuthenticated) {
            // Redirect to home page upon successful login
            System.out.println("Login successful!");
            goToHome(event);
        } else {
            errorLabel.setText("Invalid credentials");
        }
    }

    /**
     * This function is called on successful login/signup
     * Redirects to the home page.
     *
     * @param event The ActionEvent triggered for redirection.
     */

    private void goToHome(ActionEvent event) {
        helpers.switchScene("hello-view.fxml", "Home Page", event, new HelloController());
    }
    @FXML
    private void gotosignup(ActionEvent event){
        try {
            FXMLLoader loader = new FXMLLoader(helpers.class.getResource("signup.fxml"));
            Parent root = loader.load();

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root, 800, 600);
            stage.setTitle("SignUp");
            scene.getStylesheets().add(helpers.class.getResource("styles.css").toExternalForm());
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private boolean authenticate(String username, String password) {
        return username.equals("admin") && password.equals("admin123");
    }
}
