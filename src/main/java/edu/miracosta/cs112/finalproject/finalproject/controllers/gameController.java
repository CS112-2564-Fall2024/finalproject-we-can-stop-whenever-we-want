package edu.miracosta.cs112.finalproject.finalproject.controllers;

import javafx.animation.AnimationTimer;
import javafx.fxml.FXML;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.awt.*;
import java.util.Random;

import static edu.miracosta.cs112.finalproject.finalproject.Constants.RAD_IMAGE_PATH;
import static edu.miracosta.cs112.finalproject.finalproject.Constants.SCORE_TEXT;
import static javafx.application.Application.launch;

public class gameController {
    @FXML
    Label scoreGoesHere;
    @FXML
    ImageView lifeOne;
    @FXML
    ImageView lifeTwo;
    @FXML
    ImageView lifeThree;
    @FXML
    Canvas canvas;

    double drawX;
    double drawY;
    double deltaX;
    double deltaY;
    Random random = new Random();
    public void initialize(){
        scoreGoesHere.setText(SCORE_TEXT);
        Image image = new Image(RAD_IMAGE_PATH); // Ensure RAD_IMAGE_PATH is correct
        lifeOne.setImage(image);
        lifeTwo.setImage(image);
        lifeThree.setImage(image);

        GraphicsContext gc = canvas.getGraphicsContext2D();

        deltaX = 0;
        deltaY = 1;
        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
                gc.getFill(Color.GREEN);
                gc.fillOval(drawX, drawY, canvas.getWidth(), canvas.getHeight());
                drawX += deltaX;
                drawY += deltaY;
            }
        };
        timer.start();


    }
    public static void main(String[]args) { launch(); }


}
