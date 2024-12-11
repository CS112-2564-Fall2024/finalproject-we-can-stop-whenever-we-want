package edu.miracosta.cs112.finalproject.finalproject.Models;

import edu.miracosta.cs112.finalproject.finalproject.Constants;
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
import static edu.miracosta.cs112.finalproject.finalproject.Constants.SCORE_TEXT;

public class GameStart {

    double respawnReset = 4;
    double respawn = 4;
    private final double fireRate = 0.2;
    private double sinceLastShot = 0;

    gameController controller;
    GraphicsContext gc;


    Random random = new Random();


    Player player;

    ArrayList<GameObject> alienList = new ArrayList<>();
    ArrayList<GameObject> bulletList = new ArrayList<>();


AnimationTimer timer;

        public GameStart(Canvas canvas, gameController controller) {

            this.controller = controller;
            player = new Player();
            gc = canvas.getGraphicsContext2D();
            Image back = new Image(BACK_IMAGE_PATH);


            timer = new AnimationTimer() {
                @Override
                public void handle(long now) {
                    gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
                    gc.drawImage(back, 0, 0);

                    handleObjectUpdate();
                    handleCollision();
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
                public void endGame() {
                    timer.stop();
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
               controller.loseLife();
               controller.gameOver();

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

    public void handleCollision() {
            GameObject collidedAlien = null;
            GameObject collidedBullet = null;

            for (GameObject boolet : bulletList){
                collidedAlien = boolet.isColliding(alienList);
                if (collidedAlien instanceof AlienObject<?> alienObject) {
                    collidedBullet = boolet;

                    if (alienObject.getAlienObject() instanceof Normal) {
                        System.out.println("Normal");
                        Constants.SCORE_TEXT = scoring.scoreUpdate("normal" , Constants.SCORE_TEXT);
                        controller.handleUI();
                        System.out.println(SCORE_TEXT);
                        break;
                    }
                    if (alienObject.getAlienObject() instanceof Tank) {
                        System.out.println("Tank");
                        Constants.SCORE_TEXT = scoring.scoreUpdate("tank" , Constants.SCORE_TEXT);
                        controller.handleUI();
                        System.out.println(SCORE_TEXT);
                        break;
                    }
                    if (alienObject.getAlienObject() instanceof Zipper) {
                        System.out.println("Zipper");
                        Constants.SCORE_TEXT = scoring.scoreUpdate("zipper" , Constants.SCORE_TEXT);
                        controller.handleUI();
                        System.out.println(SCORE_TEXT);
                        break;
                    }
                }
            }
            if (collidedAlien != null && collidedBullet != null){
                alienList.remove(collidedAlien);
                bulletList.remove(collidedBullet);
            }
    }

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
            case 0 -> new AlienObject<>(new Zipper(),4);
            case 1 -> new AlienObject<>(new Tank(),2);
            case 2 -> new AlienObject<>(new Normal(),3);
            default -> new AlienObject<>(new Normal(),3);
        };
    }

    public Boolet spawnBullet(double px) {


        return new Boolet<>(new Bullet(),px);
    }


    public void handleKeyPressed(KeyEvent event) {


        switch (event.getCode()) {
            case LEFT: player.setDeltaX(-3); break;
            case RIGHT: player.setDeltaX(3); break;
            case SPACE:
                if(canShoot()){
                    Boolet newBoolet = spawnBullet(player.drawX);bulletList.add(newBoolet);
                    sinceLastShot = System.currentTimeMillis() / 1000.0;
                }
            default: break;
        }
    }


    private boolean canShoot() {
        //used AI for this calculation
        double time = System.currentTimeMillis() / 1000.0;
        return time - sinceLastShot >= fireRate;
    }

    public void handleKeyReleased(KeyEvent event) {
        switch (event.getCode()) {
            case LEFT, RIGHT: player.setDeltaX(0); break;
            default: break;
        }
    }

}
