package edu.miracosta.cs112.finalproject.finalproject.Models;

import javafx.scene.canvas.GraphicsContext;

import java.util.Random;

public class AlienObject <A extends Drawable> extends GameObject {
    static Random random = new Random();
    private double dy;

    private A alien;
    public AlienObject(A alien, double dy) {

        super(random.nextDouble(50,550), 0, 20);
        setAlien(alien);
        this.dy = dy;

    }
    public A getAlienObject() {return alien;

    }

    public void setAlien(A alien) {
        this.alien = alien;
    }

    @Override
    public void update() {
        this.drawY += dy;
    }

    @Override
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
