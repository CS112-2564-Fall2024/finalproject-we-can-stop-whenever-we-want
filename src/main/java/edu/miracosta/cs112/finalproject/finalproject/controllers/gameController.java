package edu.miracosta.cs112.finalproject.finalproject.controllers;

import javafx.fxml.FXML;

import javafx.scene.control.Label;

import static edu.miracosta.cs112.finalproject.finalproject.Constants.SCORE_TEXT;

public class gameController {
    @FXML
    Label scoreGoesHere;

    public void initialize(){
        scoreGoesHere.setText(SCORE_TEXT); //error here saying string cannot be converted to long
    }
}
