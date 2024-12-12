
package edu.miracosta.cs112.finalproject.finalproject.Models;

import edu.miracosta.cs112.finalproject.finalproject.Models.Aliens.Normal;
import edu.miracosta.cs112.finalproject.finalproject.Models.Aliens.Tank;
import edu.miracosta.cs112.finalproject.finalproject.Models.Aliens.Zipper;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;


import static edu.miracosta.cs112.finalproject.finalproject.Constants.PLAYER_IMAGE2_PATH;
import static edu.miracosta.cs112.finalproject.finalproject.Constants.PLAYER_IMAGE_PATH;

public class Player extends GameObject {
    GameStart gameStart;
    double deltaX;
    double drawWidth;
    double drawHeight;
    Image image;
    Image image2;
    Image drawimage;
    private final double screenWidth = 600;


    public Player() {
        super(300,725, 25);
        image = new Image(PLAYER_IMAGE_PATH);
        image2 = new Image(PLAYER_IMAGE2_PATH);
        drawWidth = 100;
        drawHeight = 100;
    }

    public void setDeltaX(double deltaX) {
        this.deltaX = deltaX;
    }

    public Double getDeltaX(double deltaX){ return deltaX; }

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