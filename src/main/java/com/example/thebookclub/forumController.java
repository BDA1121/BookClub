package com.example.thebookclub;
/**
 * Controller class for managing the functionality of forums.fxml.
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
import java.net.URL;
import java.util.ResourceBundle;

public class forumController implements Initializable {
    @FXML
    private TextField titleField;
    @FXML
    private TextArea contentArea;


    @FXML
    private VBox postContainer;

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
    private void goToBookRenting(ActionEvent event) {
        helpers.switchScene("renting.fxml", "Rent Page", event, new rentController());
    }

    /**
     * Posts a new forum and adds the new forum on the top of all the other forums
     * when data is entered and the button is clicked.
     *
     * @param event Action event triggered.
     */

    @FXML
    private void postForum(ActionEvent event) {
        String title = titleField.getText();
        String content = contentArea.getText();
        AnchorPane newPost = createPost(title, content,0,0);

        // Add the new post to the container at the top (0 index)
        postContainer.getChildren().add(0, newPost);
//       clear input fields.
        titleField.clear();
        contentArea.clear();
    }
    /**
     * Initializes the forum.fxml as all the components of the UI are called here to be able to
     * dynamically display data based on the data received from the server.
     *
     * @param location  The location.
     * @param resources The resources.
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        String[] titles = {"Post Title 1", "Post Title 2", "Post Title 3", "Post Title 4"};
        String[] contents = {"Post content 1", "Post content 2", "Post content 3", "Post content 4"};
        int[] likes = {1,2,2,6};
        int[] dislikes = {0,0,1,0};

        // Create posts dynamically
        for (int i = 0; i < titles.length; i++) {
            AnchorPane postPane = createPost(titles[i], contents[i],likes[i],dislikes[i]);
            postContainer.getChildren().add(postPane);
        }
    }
    /**
     * Creates a forum post.
     *
     * @param title    Title of the post.
     * @param content  Content of the post.
     * @param like     Number of likes for the post.
     * @param dislike  Number of dislikes for the post.
     * @return The AnchorPane representing the created post.
     */
    private AnchorPane createPost(String title, String content,int like,int dislike) {
        // Creating an anchor pane for the post
        AnchorPane post = new AnchorPane();
        post.setPrefHeight(200.0);
        post.setPrefWidth(700.0);
        post.setStyle("-fx-background-color: #f0f0f0; -fx-padding: 10px;");

        Label titleLabel = new Label(title);
        titleLabel.setLayoutX(14.0);
        titleLabel.setLayoutY(14.0);

        Label contentLabel = new Label(content);
        contentLabel.setLayoutX(14.0);
        contentLabel.setLayoutY(45.0);
        contentLabel.setPrefHeight(100.0);
        contentLabel.setPrefWidth(671.0);
        contentLabel.setText(content);
        contentLabel.setWrapText(true);

        Label likeCountLabel = new Label("Likes:" + like );
        likeCountLabel.setLayoutX(14.0);
        likeCountLabel.setLayoutY(150.0);

        Label dislikeCountLabel = new Label("Dislikes:"+dislike);
        dislikeCountLabel.setLayoutX(70.0);
        dislikeCountLabel.setLayoutY(150.0);

        final boolean[] liked = {true,true};
        Button likeButton = new Button("Like");
        likeButton.setLayoutX(14.0);
        likeButton.setLayoutY(170.0);
        likeButton.setOnAction(e -> {
//            int currentLikes = Integer.parseInt(likeCountLabel.getText());
            likeCountLabel.setText("Likes:"+ String.valueOf(like + 1));
            if(!liked[1]){
                dislikeCountLabel.setText("Dislikes:"+String.valueOf(dislike ));
            }else{
                liked[0] = false;
                liked[1] = true;
            }
        });

        Button dislikeButton = new Button("Dislike");
        dislikeButton.setLayoutX(70.0);
        dislikeButton.setLayoutY(170.0);
        dislikeButton.setOnAction(e -> {
//            int currentDislikes = Integer.parseInt(dislikeCountLabel.getText());
            dislikeCountLabel.setText("Dislikes:"+String.valueOf(dislike + 1));
            if(!liked[0]){
                likeCountLabel.setText("Likes:"+String.valueOf(like ));
                liked[1] = false;

            }else{
                liked[0] = true;
            }
        });
// Adding nodes to the post anchor pane
        post.getChildren().addAll(titleLabel, contentLabel, likeCountLabel, dislikeCountLabel, likeButton, dislikeButton);
        return post;
    }
}
