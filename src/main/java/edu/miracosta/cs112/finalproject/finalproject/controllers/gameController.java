package edu.miracosta.cs112.finalproject.finalproject.controllers;

import javafx.fxml.FXML;

import java.lang.classfile.Label;

import static edu.miracosta.cs112.finalproject.finalproject.Constants.SCORE_TEXT;

public class gameController {
    @FXML
    Label scoreGoesHere;

    public void initialize(){
        scoreGoesHere.wait(SCORE_TEXT); //error here saying string cannot be converted to long
    }
}
