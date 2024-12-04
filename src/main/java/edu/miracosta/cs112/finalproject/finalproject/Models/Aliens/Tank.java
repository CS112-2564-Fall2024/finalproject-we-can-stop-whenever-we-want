package edu.miracosta.cs112.finalproject.finalproject.Models.Aliens;

import edu.miracosta.cs112.finalproject.finalproject.Models.Drawable;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Tank implements Drawable {
    static Image ship;

    public Tank() {
        if (ship == null) {
            ship = new Image("file:./src/main/resources/Images/nomoni.png");
        }
    }

    @Override
    public void draw(GraphicsContext gc, double x, double y, double width, double height) {
        gc.drawImage(ship, x, y, width, height);
    }
}
