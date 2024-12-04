
package edu.miracosta.cs112.finalproject.finalproject.Models;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import static edu.miracosta.cs112.finalproject.finalproject.Constants.PLAYER_IMAGE_PATH;

public class Player extends GameObject {
    double deltaX;
    double drawWidth;
    double drawHeight;
    Image image;
    private final double screenWidth = 600;


    public Player() {
        super(300,750, 25);
        image = new Image(PLAYER_IMAGE_PATH);
        drawWidth = 100;
        drawHeight = 100;
    }

    public void setDeltaX(double deltaX) {
        this.deltaX = deltaX;
    }

    public void update() {
        this.drawX += deltaX;

        //screen boundries
        if(drawX - drawWidth / 2 < 0){
            drawX = drawWidth/ 2;
        }

        if(drawX + drawWidth / 2 > screenWidth){
            drawX = screenWidth - drawWidth / 2;
        }
    }

    public void draw(GraphicsContext gc) {
        gc.drawImage(image,
                this.drawX-drawWidth/2,
                this.drawY-drawHeight/2,
                drawWidth,
                drawHeight);
    }


}