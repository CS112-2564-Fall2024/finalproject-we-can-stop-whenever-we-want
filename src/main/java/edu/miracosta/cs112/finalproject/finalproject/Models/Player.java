package edu.miracosta.cs112.finalproject.finalproject.Models;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Player extends GameObject {
    double deltaX;
    double deltaY;
    double drawWidth;
    double drawHeight;
    Image image;

    public Player() {
        super(100,200, 25);
        image = new Image("file:./src/main/resources/images/spaceship.png");
        drawWidth = 100;
        drawHeight = 50;
    }

    public void setDeltaX(double deltaX) {
        this.deltaX = deltaX;
    }
    public void setDeltaY(double deltaY) {
        this.deltaY = deltaY;
    }

    public void update() {
//        this.positionX;
//        this.positionY;
    }

    public void draw(GraphicsContext gc) {
        gc.drawImage(image,
                this.positionX-drawWidth/2,
                this.positionY-drawHeight/2,
                drawWidth,
                drawHeight);
    }


}
