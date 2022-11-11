package com.shpp.p2p.cs.kservetnyk.assignment2;

import acm.graphics.GOval;
import com.shpp.cs.a.graphics.WindowProgram;

import java.awt.*;

/*
  Task:
  Draw a caterpillar using GOval
*/

public class Assignment2Part6 extends WindowProgram {

    // The count of circles, size of circle
    public static final int CIRCLE_COUNT = 6;
    public static final int CIRCLE_SIZE = 100;

    // The side distance and above distance
    public static final int CIRCLE_SIDE_DISTANCE = 50;
    public static final int CIRCLE_ABOVE_DISTANCE = 20;

    // The default width and height of the window.
    public static final int APPLICATION_WIDTH = 600;
    public static final int APPLICATION_HEIGHT = 600;

    public void run(){

        // The Cycle of circles creating
        for (int i = 0; i < CIRCLE_COUNT; i++) {
            circle(i);
        }
    }

    // Method that create even and odd circles
    private void circle(int a){

        // Create an object of class GOval named cir2
        GOval cir2 = new GOval(
                getWidth() - getWidth() + a*CIRCLE_SIDE_DISTANCE,
                getHeight() - getHeight(),
                CIRCLE_SIZE, CIRCLE_SIZE);
        // Fill the object by color
        cir2.setFilled(true);
        // Set Color of object
        cir2.setFillColor(Color.GREEN);
        // Set color of stroke
        cir2.setColor(Color.RED);

        // Create an object of class GOval named cir1
        GOval cir1 = new GOval(
                getWidth() - getWidth() + a*CIRCLE_SIDE_DISTANCE,
                getHeight() - getHeight() + CIRCLE_ABOVE_DISTANCE,
                CIRCLE_SIZE, CIRCLE_SIZE);
        cir1.setFilled(true);
        cir1.setFillColor(Color.GREEN);
        cir1.setColor(Color.RED);

        // If the value is divisible by 2, it is even and adds cir1
        if(a%2 == 0) add(cir1);
        // If not - adds cir2
        else add(cir2);
    }
}
