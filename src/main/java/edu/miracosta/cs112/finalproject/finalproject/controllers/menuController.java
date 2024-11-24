package edu.miracosta.cs112.finalproject.finalproject.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.awt.event.ActionEvent;
import java.io.IOException;

public class menuController {
    @FXML
    ImageView radImage;
    @FXML
    Label titleText;
//    @FXML
//    Button startButton;
//    //something

    public void initialize(){
        titleText.setText(TITLE_TEXT);
        Image image = new Image(RAD_IMAGE_PATH);
        radImage.setImage(image);
    }
//    public void StartGame(javafx.event.ActionEvent actionEvent) {
//
//    }
    public void handleStartButton() throws IOException {
        Stage stage = (Stage)titleLabel.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(TaxEvadersMain.class.getResource(game-view.fxml));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
        stage.setTitle(GAME_TITLE_TEXT);
        stage.show();
    }
}
