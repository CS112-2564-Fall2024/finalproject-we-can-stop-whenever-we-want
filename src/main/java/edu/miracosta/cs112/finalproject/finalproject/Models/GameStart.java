package edu.miracosta.cs112.finalproject.finalproject.Models;

import javafx.animation.AnimationTimer;
import javafx.scene.canvas.GraphicsContext;

public class GameStart {
    public void update() {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {

                handleObjects();

            }

            public void handleObjects() {


                public double getPositionX () {
                    return drawX;
                }
                public double getPositionY () {
                    return drawY;
                }
                public double getRadius () {
                    return radius;
                }
            }
        };
    }
}
