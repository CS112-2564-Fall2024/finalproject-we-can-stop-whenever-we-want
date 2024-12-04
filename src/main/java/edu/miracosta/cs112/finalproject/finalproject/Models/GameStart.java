package edu.miracosta.cs112.finalproject.finalproject.Models;

import edu.miracosta.cs112.finalproject.finalproject.Models.Aliens.Normal;
import edu.miracosta.cs112.finalproject.finalproject.Models.Aliens.Tank;
import edu.miracosta.cs112.finalproject.finalproject.Models.Aliens.Zipper;
import edu.miracosta.cs112.finalproject.finalproject.controllers.gameController;
import javafx.animation.AnimationTimer;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.Random;

public class GameStart {

    double respawnReset = 10;
    double respawn = 10;

    gameController controller;
    GraphicsContext gc;


    Random random = new Random();

    Player player;
    public Player getPlayer() { return player; }

    ArrayList<GameObject> alienList = new ArrayList<>();


        public GameStart(Canvas canvas, gameController controller) {

            this.controller = controller;
            gc = canvas.getGraphicsContext2D();


            AnimationTimer timer = new AnimationTimer() {
                @Override
                public void handle(long now) {
                    gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
                    gc.setFill(Color.BLACK);
                    gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());

                    handleObjectUpdate();
                    handleCollision();
                    handleRespawn();

                    handleObjects();

//                    controller.handleUIUpdate();

                }

                public void handleObjects() {


                }
            };
            timer.start();
        }

    public void handleObjectUpdate() {
//        player.update();
//        player.draw(gc);

        GameObject offscreen = null;
        for(GameObject alien : alienList){
            alien.update();
            alien.draw(gc);
            if (alien.getPositionY() < 900) {
                offscreen = alien;
            }
        }
        if (offscreen != null) {

            alienList.remove(offscreen);
        }
    }

    public void handleCollision() {
        GameObject collision = player.isColliding(alienList);
        if (collision instanceof AlienObject<?> alienObject) {
            if (alienObject.getAlienObject() instanceof Normal) {
                player.takeDamage(1);
            }
        }
    }

    public void handleRespawn() {
        respawn -= 0.1;
        if (respawn <= 0) {
            respawnReset -= 0.1;
            respawn = respawnReset;
            GameObject alien = spawnGameObject();
            alienList.add(alien);
        }
    }

    public GameObject spawnGameObject() {
        int next = random.nextInt(2);
        return switch (next) {
            case 0 -> new AlienObject<>(new Zipper());
            case 1 -> new AlienObject<>(new Tank());
            default -> new AlienObject<>(new Normal());
        };
    }


}
