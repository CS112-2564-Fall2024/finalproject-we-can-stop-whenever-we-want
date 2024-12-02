package edu.miracosta.cs112.finalproject.finalproject.Models;

public abstract class GameObject {
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
}
