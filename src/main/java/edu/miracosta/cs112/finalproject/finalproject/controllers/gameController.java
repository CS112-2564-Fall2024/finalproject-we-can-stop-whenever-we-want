package edu.miracosta.cs112.finalproject.finalproject.controllers;

import javafx.fxml.FXML;

import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.awt.*;

import static edu.miracosta.cs112.finalproject.finalproject.Constants.RAD_IMAGE_PATH;
import static edu.miracosta.cs112.finalproject.finalproject.Constants.SCORE_TEXT;

public class gameController {
    @FXML
    Label scoreGoesHere;
    @FXML
    ImageView lifeOne;
    @FXML
    ImageView lifeTwo;
    @FXML
    ImageView lifeThree;
//    @FXML
//    Canvas gameBoard;

    public void initialize(){
        scoreGoesHere.setText(SCORE_TEXT);
        Image image = new Image(RAD_IMAGE_PATH); // Ensure RAD_IMAGE_PATH is correct
        lifeOne.setImage(image);
        lifeTwo.setImage(image);
        lifeThree.setImage(image);
    }


}
