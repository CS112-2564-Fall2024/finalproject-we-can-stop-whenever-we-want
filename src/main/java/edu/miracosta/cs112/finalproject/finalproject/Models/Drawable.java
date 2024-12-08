package edu.miracosta.cs112.finalproject.finalproject.Models;

import javafx.scene.canvas.GraphicsContext;

public interface Drawable {
    void draw(GraphicsContext gc, double x, double y, double width, double height);
}
