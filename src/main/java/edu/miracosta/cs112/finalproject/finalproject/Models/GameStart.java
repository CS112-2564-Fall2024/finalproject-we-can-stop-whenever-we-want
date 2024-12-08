package edu.miracosta.cs112.finalproject.finalproject.Models;

import edu.miracosta.cs112.finalproject.finalproject.Models.Aliens.Normal;
import edu.miracosta.cs112.finalproject.finalproject.Models.Aliens.Tank;
import edu.miracosta.cs112.finalproject.finalproject.Models.Aliens.Zipper;
import edu.miracosta.cs112.finalproject.finalproject.controllers.gameController;
import javafx.animation.AnimationTimer;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;

import java.util.ArrayList;
import java.util.Random;

import static edu.miracosta.cs112.finalproject.finalproject.Constants.BACK_IMAGE_PATH;

public class GameStart {

    double respawnReset = 10;
    double respawn = 10;
    double fireRate = 2;

    gameController controller;
    GraphicsContext gc;


    Random random = new Random();


    Player player;
//    public Player getPlayer() { return player; }

    ArrayList<GameObject> alienList = new ArrayList<>();
    ArrayList<GameObject> bulletList = new ArrayList<>();




        public GameStart(Canvas canvas, gameController controller) {

            this.controller = controller;
            player = new Player();
            gc = canvas.getGraphicsContext2D();
            Image back = new Image(BACK_IMAGE_PATH);


            AnimationTimer timer = new AnimationTimer() {
                @Override
                public void handle(long now) {
                    gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
                    gc.drawImage(back, 0, 0);
//                    gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());

                    handleObjectUpdate();
//                    handleCollision();
                    handleRespawn();

                    handleObjects();

//                    controller.handleUIUpdate();

                }

                public void handleObjects() {
                    player.update();
                    player.draw(gc);

                }
            };
            timer.start();
        }



    public void handleObjectUpdate() {
        player.update();
        player.draw(gc);

        GameObject offscreen = null;
        for(GameObject alien : alienList){
            alien.update();
            alien.draw(gc);
            if (alien.getPositionY() > 840) {
                offscreen = alien;
            }
        }
        for (GameObject boolet : bulletList) {
            boolet.update();
            boolet.draw(gc);
            if (boolet.getPositionY() < 0) {
                offscreen = boolet;
            }
        }
        if (offscreen != null) {

            alienList.remove(offscreen);
            bulletList.remove(offscreen);
        }
    }

//    public void handleCollision() {
//        GameObject collision = player.isColliding(alienList);
//        if (collision instanceof AlienObject<?> alienObject) {
//            if (alienObject.getAlienObject() instanceof Normal) {
//                player.takeDamage(1);
//            }
//        }
//    }

    public void handleRespawn() {
        respawn -= 0.1;
        if (respawn <= 0) {
            respawn = respawnReset;
            GameObject alien = spawnGameObject();
            alienList.add(alien);
        }
    }

    public GameObject spawnGameObject() {
        int next = random.nextInt(4);
        return switch (next) {
            case 0 -> new AlienObject<>(new Zipper());
            case 1 -> new AlienObject<>(new Tank());
            case 2 -> new AlienObject<>(new Normal());
            default -> new AlienObject<>(new Normal());
        };
    }

    public Boolet spawnBullet(double px) {


        return new Boolet<>(new Bullet(),px);
    }


    public void handleKeyPressed(KeyEvent event) {


        switch (event.getCode()) {
            case LEFT: player.setDeltaX(-1.25); break;
            case RIGHT: player.setDeltaX(1.25); break;
            case SPACE: Boolet newBoolet = spawnBullet(player.drawX);bulletList.add(newBoolet); break;
            default: break;
        }
    }

    public void handleKeyReleased(KeyEvent event) {
        switch (event.getCode()) {
            case LEFT, RIGHT: player.setDeltaX(0); break;
            default: break;
        }
    }

}
