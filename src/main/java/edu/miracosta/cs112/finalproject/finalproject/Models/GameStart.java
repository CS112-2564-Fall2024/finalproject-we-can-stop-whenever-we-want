package edu.miracosta.cs112.finalproject.finalproject.Models;

import edu.miracosta.cs112.finalproject.finalproject.controllers.gameController;
import javafx.animation.AnimationTimer;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;

public class GameStart {

    gameController controller;
    GraphicsContext gc;
    private Canvas canvas;

    //initializing player
    Player ship;
    public Player getShip() { return ship; }


    public void GameStart(Canvas canvas, gameController controller) {
        gc = canvas.getGraphicsContext2D();
        ship = new Player();
        this.controller = controller;

        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {

                gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
                gc.setFill(Color.BLACK);
                gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());

                handleObjects();

            }

            public void handleObjects() {
                ship.update();
                ship.draw(gc);
            }
        };
        timer.start();
    }

    public void handleKeyPressed(KeyEvent event) {
        switch (event.getCode()) {
            case UP: ship.setDeltaY(-1.25); break;
            case DOWN: ship.setDeltaY(1.25); break;
            case LEFT: ship.setDeltaX(-1.25); break;
            case RIGHT: ship.setDeltaX(1.25); break;
            default: break;
        }
    }

    public void handleKeyReleased(KeyEvent event) {
        switch (event.getCode()) {
            case UP, DOWN: ship.setDeltaY(0); break;
            case LEFT, RIGHT: ship.setDeltaX(0); break;
            default: break;
        }
    }
}
