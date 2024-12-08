package edu.miracosta.cs112.finalproject.finalproject.controllers;

import edu.miracosta.cs112.finalproject.finalproject.Models.GameStart;
import javafx.fxml.FXML;

import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import javafx.scene.canvas.Canvas; // Used ai to fix the canvas import
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;

import static edu.miracosta.cs112.finalproject.finalproject.Constants.*;
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
    Canvas canvas;// Used AI to fix the canvas fxml
    @FXML
    Pane gameResults;

    //private GraphicsContext gc;
    GameStart gameStart;
    boolean LifeOne = true;
    boolean LifeTwo = true;
    boolean LifeThree = true;



    //Random random = new Random();
    public void initialize(){


        gameStart = new GameStart(canvas, this);

        canvas.setFocusTraversable(true);
        canvas.requestFocus();

        scoreGoesHere.setText(SCORE_TEXT);
        Image image = new Image(PLAYER_IMAGE_PATH);
        lifeOne.setImage(image);
        lifeTwo.setImage(image);
        lifeThree.setImage(image);


    }

    public void loseLife(){
        if(LifeOne){
            LifeOne = false;
        }
        else if(LifeTwo){
            LifeTwo = false;
        }
        else if(LifeThree){
            LifeThree = false;
        }
        handleLives();
    }


    public void gameOver(){
        if (!LifeOne && !LifeTwo && !LifeThree) {
            endGame();
            //gameStart.endGame();
        }
    }

    public void handleLives(){
        if(!LifeOne){
            lifeOne.setVisible(LifeOne);
        }
        if(!LifeTwo){
            lifeTwo.setVisible(LifeTwo);
        }
        if(!LifeThree){
            lifeThree.setVisible(LifeThree);
        }
    }


    public void handleKeyPressed(KeyEvent event) {
        gameStart.handleKeyPressed(event);
    }

    public void handleKeyReleased(KeyEvent event) {

        gameStart.handleKeyReleased(event);
    }


    public void endGame(){

        gameResults.setVisible(true);
    }

    public static void main(String[]args) { launch(); }


}
