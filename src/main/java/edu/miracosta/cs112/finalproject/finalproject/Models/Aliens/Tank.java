package edu.miracosta.cs112.finalproject.finalproject.Models.Aliens;

import edu.miracosta.cs112.finalproject.finalproject.Models.Drawable;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Tank implements Drawable {
    static Image ship2;

    public Tank() {
        if (ship2 == null) {
            ship2 = new Image("file:.src/main/resources/Images/alien.png");
        }
    }

    @Override
    public void draw(GraphicsContext gc, double x, double y, double width, double height) {
        gc.drawImage(ship2, x, y, width, height);
    }
}
