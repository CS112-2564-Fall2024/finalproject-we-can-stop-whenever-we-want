
package edu.miracosta.cs112.finalproject.finalproject.Models;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Player extends JPanel {

    // Override the paintComponent method to draw
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); // Call the parent class's method to clear the panel
        Graphics2D g2d = (Graphics2D) g;

        // Enable antialiasing for smoother graphics
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Set color to red and draw an oval
        g2d.setColor(Color.RED);
        g2d.fillOval(50, 50, 200, 100); // x, y, width, height
    }

    public static void main(String[] args) {
        // Create a JFrame to hold the panel

        Player player = new Player();

    }

   // public class bullet <B extends Drawable> extends GameObject{

        //private B bullet;
        //public bullet(B bullet) {
            //super(playerPosition.nextDouble(600), - 200, 20);
        //}
    //}
}
