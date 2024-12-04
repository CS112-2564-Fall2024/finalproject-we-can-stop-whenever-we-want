package edu.miracosta.cs112.finalproject.finalproject.Models;

import edu.miracosta.cs112.finalproject.finalproject.controllers.gameController;
import javafx.scene.canvas.GraphicsContext;

public abstract class GameObject extends gameController {
    protected double positionX;
    protected double positionY;
    protected double radius;
    protected GameObject(double positionX, double positionY, double radius) {
        this.positionX = positionX;
        this.positionY = positionY;
        this.radius = radius;

//        public double getPositionX() { return positionX; }
//        public abstract void update();
//        public abstract void draw(GraphicsContext gc);
    }
}