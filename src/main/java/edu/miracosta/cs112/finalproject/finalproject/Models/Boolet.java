package edu.miracosta.cs112.finalproject.finalproject.Models;

import javafx.scene.canvas.GraphicsContext;


public class Boolet <B extends Drawable> extends GameObject {


    static Player player = new Player();

    private B boolet;
    public Boolet(B boolet, double px) {
        super(px, 750, 10);
        setBoolet(boolet);
    }

    public B getBoolet() {
        return boolet;
    }

    public void setBoolet(B boolet) {
        this.boolet = boolet;
    }

    @Override
    public void update() {
        this.drawY -= 5;
    }

    @Override
    public void draw(GraphicsContext gc) {
        if (boolet != null) {
            boolet.draw(gc,
                    this.drawX-this.radius,
                    this.drawY-this.radius,
                    this.radius,
                    this.radius*2);
        }
    }
}
