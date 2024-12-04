package edu.miracosta.cs112.finalproject.finalproject.controllers;

import edu.miracosta.cs112.finalproject.finalproject.Models.GameStart;
import javafx.animation.AnimationTimer;
import javafx.fxml.FXML;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import javafx.scene.canvas.Canvas; // Used ai to fix the canvas import
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;

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
    Canvas canvas; // Used ai to fix the canvas fxml


    GameStart gameStart;
    private GraphicsContext gc;

    Random random = new Random();
    public void initialize(){
        gameStart = new GameStart(canvas, this);
        scoreGoesHere.setText(SCORE_TEXT);
        Image image = new Image(RAD_IMAGE_PATH);
        lifeOne.setImage(image);
        lifeTwo.setImage(image);
        lifeThree.setImage(image);

        GraphicsContext gc = canvas.getGraphicsContext2D();

        canvas.setFocusTraversable(true);
        canvas.requestFocus();

//        double deltaX = random.nextDouble(600);
//        double deltaY = 1;
//        AnimationTimer timer = new AnimationTimer() {
//            @Override
//            public void handle(long now) {
//
//
//            }
//            public void handleObjects(){
//                ship.update();
//                ship.draw(gc);
//                gc.setFill(Color.GREEN);
//                gc.fillOval(deltaX, 300 - 200, 100, 100);
//                0 += deltaX;
//                50 += deltaY;
//            }
//        };
//        timer.start();
//

    }

    public void handleKeyPressed(KeyEvent event) {
        gameStart.handleKeyPressed(event);
    }

    public void handleKeyReleased(KeyEvent event) {
        gameStart.handleKeyReleased(event);
    }

    public static void main(String[]args) { launch(); }




}
