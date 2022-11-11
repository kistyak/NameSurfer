package com.shpp.p2p.cs.kservetnyk.assignment2;

import acm.graphics.GLabel;
import acm.graphics.GRect;
import com.shpp.cs.a.graphics.WindowProgram;

import java.awt.*;

/*
  Task:
  Draw a tricolor flag in the center of the window and the name of the country in the lower right corner
*/

public class Assignment2Part4 extends WindowProgram {

    // The flag width constant
    public static final int FLAG_WIDTH = 400;
    // The flag height constant
    public static final int FLAG_HEIGHT = 300;

    // The default width and height of the window.
    public static final int APPLICATION_WIDTH = 600;
    public static final int APPLICATION_HEIGHT = 600;

    public void run(){

        // Draw a flag
        drawFlag();
    }

    // Method that create a flag
    private void drawFlag(){

        // Create the first color of flag (x coordinate, y coordinate, width, height)
            // Create an object of class GRect named firstThird
        GRect firstThird = new GRect(
                getWidth()/2f - FLAG_WIDTH/2f,
                getHeight()/2f - FLAG_HEIGHT/2f,
                FLAG_WIDTH/3f,
                FLAG_HEIGHT);
            // Fill the object by color (default - black)
        firstThird.setFilled(true);
        add(firstThird);

        // Create the second color of flag (x coordinate, y coordinate, width, height)
        GRect secondThird = new GRect(
                getWidth()/2f - FLAG_WIDTH/6f,
                getHeight()/2f - FLAG_HEIGHT/2f,
                FLAG_WIDTH/3f,
                FLAG_HEIGHT);
        secondThird.setFilled(true);
            // Set color
        secondThird.setColor(Color.YELLOW);
        add(secondThird);

        // Create the third color of flag (x coordinate, y coordinate, width, height)
        GRect third = new GRect(
                getWidth()/2f + FLAG_WIDTH/6f,
                getHeight()/2f - FLAG_HEIGHT/2f,
                FLAG_WIDTH/3f,
                FLAG_HEIGHT);
        third.setFilled(true);
        third.setColor(Color.RED);
        add(third);

        // Create the text "Flag of Belgium" in the lower right corner
            // Create an object of class GLabel named nameOfCountry with the text
        GLabel nameOfCountry = new GLabel("Flag of Belgium");
            // Set the font of label
        nameOfCountry.setFont("SansSerif-36");
            // Set coordinates of label
        double x = (getWidth() - nameOfCountry.getWidth());
        double y = (getHeight() - nameOfCountry.getDescent());
            // Add the label
        add(nameOfCountry, x, y);
    }
}
