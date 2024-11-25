package edu.miracosta.cs112.finalproject.finalproject.controllers;

import edu.miracosta.cs112.finalproject.finalproject.TaxEvadersMain;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;

import static edu.miracosta.cs112.finalproject.finalproject.Constants.*;

public class menuController {

    @FXML
    private ImageView radImage;
    @FXML
    private Label titleText;

    public void initialize() {
        // Setting the title text
        titleText.setText(TITLE_TEXT);

        // Creating and setting the image
        Image image = new Image(RAD_IMAGE_PATH); // Ensure RAD_IMAGE_PATH is correct
        radImage.setImage(image);
    }

    public void handleStartButton() throws IOException {
        // Change the scene when start button is pressed
        Stage stage = (Stage) titleText.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(TaxEvadersMain.class.getResource("game-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
        stage.setTitle(GAME_TITLE_TEXT); // Set the title for the new scene
        stage.show(); // Display the new scene
    }
}