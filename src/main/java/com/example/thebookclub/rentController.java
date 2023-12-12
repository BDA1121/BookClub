package com.example.thebookclub;
/**
 * Controller for handling renting.fxml.
 */
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.net.URL;
import java.util.ResourceBundle;

public class rentController implements Initializable {

    @FXML
    private VBox postContainer;
    @FXML
    private TextField titleField;
    @FXML
    private TextField authorField;
    @FXML
    private TextField genreField;
    @FXML
    private TextArea descriptionArea;

    /**
     * The following three functions are used for Navigating to other pages.
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
    private void goToforums(ActionEvent event) {
        helpers.switchScene("forums.fxml", "Forums Page", event, new forumController());
    }

    /**
     * Initializes the renting.fxml as all the components of the UI are called here to be able to
     * dynamically display data based on the data received from the server.
     *
     * @param location  The location.
     * @param resources The resources.
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        String[] titles = {"Title 1", "Title 2", "Title 3", "Title 4"};
        String[] authors = {"Author 1", "Author 2", "Author 3", "Author 4"};
        String[] description = {"desc 1", "desc 2", "desc 3", "desc 4"};
        String[] owner = {"Owner 1", "Owner 2", "Owner 3", "Owner 4"};
        Boolean[] available = {true,false,true,true};
        String[] images = {"https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTbTM3SApR_SsOX0xsAmMBEj8XPK1BvDVLAxA&usqp=CAU","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTbTM3SApR_SsOX0xsAmMBEj8XPK1BvDVLAxA&usqp=CAU","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTbTM3SApR_SsOX0xsAmMBEj8XPK1BvDVLAxA&usqp=CAU","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTbTM3SApR_SsOX0xsAmMBEj8XPK1BvDVLAxA&usqp=CAU"};

        // Create posts dynamically based on the availability of books
        for (int i = 0; i < titles.length; i++) {
            if(available[i]){
                AnchorPane postPane = createPost(titles[i], authors[i], description[i], owner[i], images[i]);
                postContainer.getChildren().add(postPane);
            }
        }
    }

    /**
     * Posts a book for renting .
     *
     * @param event The ActionEvent triggered for posting the book.
     */
    @FXML
    private void postBook(ActionEvent event){
        String title = titleField.getText();
        String content = authorField.getText();
        String desc = descriptionArea.getText();
        String owner = "admin";
        AnchorPane newPost = createPost(title, content,desc,owner,"https://m.media-amazon.com/images/W/MEDIAX_792452-T1/images/I/51M+z-t6QFL._SY445_SX342_.jpg");

        // Add the new post to the container at the top (0 index)
        postContainer.getChildren().add(0, newPost);
//        input fields are cleared.
        titleField.clear();
        authorField.clear();
        descriptionArea.clear();
        genreField.clear();
    }
    /**
     * Creates a post.
     *
     * @param title      The title of the book.
     * @param content    The author of the book.
     * @param desc       The description of the book.
     * @param owner      The owner of the book.
     * @param imagePath  The URL of the book image.
     * @return An AnchorPane representing the post.
     */
    private AnchorPane createPost(String title, String content, String desc, String owner, String imagePath) {
        // Creating an anchor pane for the post
        AnchorPane post = new AnchorPane();
        post.setPrefHeight(200.0);
        post.setPrefWidth(700.0);
        post.setStyle("-fx-background-color: #f0f0f0; -fx-padding: 10px;");

        Label titleLabel = new Label(title);
        titleLabel.setLayoutX(14.0);
        titleLabel.setLayoutY(14.0);

        Label contentLabel = new Label( content);
        contentLabel.setLayoutX(14.0);
        contentLabel.setLayoutY(45.0);
        contentLabel.setPrefWidth(671.0);
        contentLabel.setText("Author: " +content);
        contentLabel.setWrapText(true);

        Label descLabel = new Label( desc);
        descLabel.setLayoutX(14.0);
        descLabel.setLayoutY(55.0);
        descLabel.setPrefWidth(671.0);
        descLabel.setText("Description: " +desc);
        descLabel.setWrapText(true);

        Label rentLabel = new Label();
        descLabel.setLayoutX(14.0);
        descLabel.setLayoutY(155.0);
        descLabel.setPrefWidth(671.0);
        descLabel.setText("");
        descLabel.setWrapText(true);

        Label ownerLabel = new Label("Owner: " + owner);
        ownerLabel.setLayoutX(14.0);
        ownerLabel.setLayoutY(125.0);

        Button rentButton = new Button("Rent");
        rentButton.setLayoutX(14.0);
        rentButton.setLayoutY(155.0);
        rentButton.setOnAction(e -> {
//            int currentLikes = Integer.parseInt(likeCountLabel.getText());
            rentButton.setPrefSize(0, 0);
            rentButton.setMinSize(0, 0);
            rentButton.setMaxSize(0, 0);
            descLabel.setText("rented");
//            available[i]=!available[i];

        });

        Image image = new Image(imagePath);
        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(200); // Set the width of the image (adjust as needed)
        imageView.setPreserveRatio(true);
        imageView.setLayoutX(500.0); // Adjust the X position
        imageView.setLayoutY(14.0);
// Adding nodes to the post anchor pane
        post.getChildren().addAll(titleLabel,rentLabel, contentLabel, descLabel, ownerLabel, rentButton, imageView);
        return post;
    }
}
