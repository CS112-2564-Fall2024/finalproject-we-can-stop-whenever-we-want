package edu.miracosta.cs112.finalproject.finalproject.Models.Aliens;

import edu.miracosta.cs112.finalproject.finalproject.Models.Drawable;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Zipper implements Drawable {
    static Image ship3;

    public Zipper() {
        if (ship3 == null) {
            ship3 = new Image("file:./src/main/resources/Images/alien3.png");
        }
    }

    @Override
    public void draw(GraphicsContext gc, double x, double y, double width, double height) {
        gc.drawImage(ship3, x, y, width, height);
    }
}
