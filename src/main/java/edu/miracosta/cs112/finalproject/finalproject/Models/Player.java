package edu.miracosta.cs112.finalproject.finalproject.Models;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Player extends GameObject {
    double deltaX;
    double drawWidth;
    double drawHeight;
    Image image;
    private final double screenWidth = 600;


    public Player() {
        super(300,750, 25);
        image = new Image("file:./src/main/resources/images/spaceship.png");
        drawWidth = 100;
        drawHeight = 100;
    }

    public void setDeltaX(double deltaX) {
        this.deltaX = deltaX;
    }

    public void update() {
        this.positionX += deltaX;

        //screen boundries
        if(positionX - drawWidth / 2 < 0){
            positionX = drawWidth/ 2;
        }

        if(positionX + drawWidth / 2 > screenWidth){
            positionX = screenWidth - drawWidth / 2;
        }
    }

    public void draw(GraphicsContext gc) {
        gc.drawImage(image,
                this.positionX-drawWidth/2,
                this.positionY-drawHeight/2,
                drawWidth,
                drawHeight);
    }


}
