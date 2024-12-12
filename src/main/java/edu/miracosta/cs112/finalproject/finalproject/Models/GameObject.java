package edu.miracosta.cs112.finalproject.finalproject.Models;

import edu.miracosta.cs112.finalproject.finalproject.controllers.gameController;
import javafx.scene.canvas.GraphicsContext;

import java.util.List;

public abstract class GameObject extends gameController {
    protected double drawX;
    protected double drawY;
    protected double radius;

    protected GameObject(double positionX, double positionY, double radius) {
        this.drawX = positionX;
        this.drawY = positionY;
        this.radius = radius;
    }

    public double getPositionX() { return drawX; }
    public double getPositionY() { return drawY; }
    public double getRadius() { return radius; }

    public void setPositionX(double positionX) { this.drawX = positionX; }
    public void setPositionY(double positionY) { this.drawY = positionY; }
    public void setRadius(double radius) { this.radius = radius; }

    public abstract void update();
    public abstract void draw(GraphicsContext gc);

    public GameObject isColliding(List<GameObject> gameObjects) {
        for (GameObject other : gameObjects) {
            if (isColliding(other) != null) {
                return other;
            }
        }
        return null;
    }

    public GameObject isColliding(GameObject other) {
        if (this != other && other != null) {
            double distance = Math.pow(this.drawX - other.drawX, 2)
                    + Math.pow(this.drawY - other.drawY, 2);
            double radii = Math.pow(this.radius + other.radius, 2);
            if (distance < radii) {
                return other;
            }
        }
        return null;
    }
}