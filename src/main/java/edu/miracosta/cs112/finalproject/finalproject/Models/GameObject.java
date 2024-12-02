package edu.miracosta.cs112.finalproject.finalproject.Models;

import edu.miracosta.cs112.finalproject.finalproject.controllers.gameController;

public abstract class GameObject extends gameController {
    protected double drawX;
    protected double drawY;
    protected double radius;
    protected GameObject(double positionX, double positionY, double radius) {
        this.drawX = positionX;
        this.drawY = positionY;
        this.radius = radius;
    }
}