package com.shpp.p2p.cs.kservetnyk.assignment2;

import acm.graphics.GOval;
import acm.graphics.GRect;
import com.shpp.cs.a.graphics.WindowProgram;

import java.awt.*;

/*
  Task:
  Create a white square over 4 circles
*/

public class Assignment2Part2 extends WindowProgram {

    // The circle diameter constant
    public static final double CIRCLE_DIAMETER = 50;

    // The default width and height of the window.
    public static final int APPLICATION_WIDTH = 300;
    public static final int APPLICATION_HEIGHT = 300;

    public void run(){

        // Create 4 circles (x coordinate, y coordinate, width, height)
            // Create an object of class GOval named circle1
        GOval circle1 = new GOval(getWidth() - getWidth(), getHeight() - getHeight(),
                CIRCLE_DIAMETER, CIRCLE_DIAMETER);
            // Fill the object by color (default - black)
        circle1.setFilled(true);
            // Add object to window
        add(circle1);

        GOval circle2 = new GOval(getWidth() - CIRCLE_DIAMETER - 1, getHeight() - getHeight(),
                CIRCLE_DIAMETER, CIRCLE_DIAMETER);
        circle2.setFilled(true);
        add(circle2);

        GOval circle3 = new GOval(getWidth() - CIRCLE_DIAMETER - 1, getHeight() - CIRCLE_DIAMETER - 1,
                CIRCLE_DIAMETER, CIRCLE_DIAMETER);
        circle3.setFilled(true);
        add(circle3);

        GOval circle4 = new GOval(getWidth() - getWidth(), getHeight() - CIRCLE_DIAMETER - 1,
                CIRCLE_DIAMETER, CIRCLE_DIAMETER);
        circle4.setFilled(true);
        add(circle4);

        // Create white square (x coordinate, y coordinate, width, height)
        GRect square = new GRect(getWidth() - getWidth() + CIRCLE_DIAMETER/2,
                getHeight() - getHeight() + CIRCLE_DIAMETER/2,
                getWidth() - CIRCLE_DIAMETER,
                getHeight() - CIRCLE_DIAMETER);
        square.setFilled(true);
        // Set white color to object
        square.setColor(Color.WHITE);
        add(square);
    }
}
