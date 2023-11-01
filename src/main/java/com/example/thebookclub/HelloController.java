package com.example.thebookclub;
// have just initialized the GUI and just checked if the onaction function is working
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class HelloController {
    @FXML
    private Label welcomeText;
    int i =0;
    @FXML
    protected void onHelloButtonClick() {
        if (i%2==0) {welcomeText.setText("Yes!");}
        else{welcomeText.setText("No!");}
        i++;
    }
}