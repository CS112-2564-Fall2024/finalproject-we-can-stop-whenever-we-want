package edu.miracosta.cs112.finalproject.finalproject.Models;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Bullet implements Drawable{
    static Image projectile;
    GraphicsContext gc;

    public Bullet() {
        if (projectile == null) {
            projectile = new Image("file:./src/main/resources/Images/bullet.png");
        }
    }

    @Override
    public void draw(GraphicsContext gc, double x, double y, double width, double height) {
        gc.drawImage(projectile, x, y, width, height);
    }
}
