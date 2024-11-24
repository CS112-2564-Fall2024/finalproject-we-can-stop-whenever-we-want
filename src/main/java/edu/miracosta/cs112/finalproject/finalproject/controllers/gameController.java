package edu.miracosta.cs112.finalproject.finalproject.controllers;

public class gameController {
    @FXML
    Label scoreGoesHere;

    public void initialize(){
        scoreGoesHere.setText(SCORE_TEXT);
    }
}
