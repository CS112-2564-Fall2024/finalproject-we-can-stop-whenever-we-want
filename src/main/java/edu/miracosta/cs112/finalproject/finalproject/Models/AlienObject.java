package edu.miracosta.cs112.finalproject.finalproject.Models;

import javafx.scene.canvas.GraphicsContext;

import java.util.Random;

public class AlienObject <A extends Drawable> extends GameObject {
    static Random random = new Random();
    private A alien;
    public AlienObject(A alien) {
        super(random.nextDouble(600), - 200, 20);
        setAlien(alien);
    }

    public A getAlienObject() {
        return alien;
    }

    public void setAlien(A alien) {
        this.alien = alien;
    }

//    @Override
    public void update() {
        this.drawY -= 1;
    }

//    @Override
    public void draw(GraphicsContext gc) {
        if (alien != null) {
            alien.draw(gc,
                    this.drawX-this.radius,
                    this.drawY-this.radius,
                    this.radius*2,
                    this.radius*2);
        }
    }
}
