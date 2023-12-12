package com.example.thebookclub;
/**
 * Controller class for managing the functionality of hello-view.fxml/the home page.
 */
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ListView;
// have just initialized the GUI and just checked if the onaction function is working
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class HelloController {
    /**
     * The following four functions are used for Navigating to other pages.
     * To avoid repetitive code I have added the main functionality of navigation in helpers.java
     * @param event Action event triggered.
     */
    @FXML
    private void goToHome(ActionEvent event) {
        helpers.switchScene("hello-view.fxml", "Home Page", event, new HelloController());
    }
    @FXML
    private void goToBookLending(ActionEvent event) {
        helpers.switchScene("BookLending.fxml", "Lending Page", event, new HelloController());
    }
    @FXML
    private void goToBookRenting(ActionEvent event) {
        helpers.switchScene("renting.fxml", "Rent Page", event, new rentController());
    }
    @FXML
    private void goToforums(ActionEvent event) {
        helpers.switchScene("forums.fxml", "forum Page", event, new forumController());
//        }
    }



}