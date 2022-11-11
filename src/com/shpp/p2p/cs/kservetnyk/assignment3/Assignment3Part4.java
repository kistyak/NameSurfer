package com.shpp.p2p.cs.kservetnyk.assignment3;

import acm.graphics.GRect;
import com.shpp.cs.a.graphics.WindowProgram;

import java.awt.*;

/*
  Task:
  Make a pyramid of bricks. Each row contains 1 brick less.
  The pyramid should be centered horizontally and lie on the "bottom" of the window.
*/

public class Assignment3Part4 extends WindowProgram{

    // The brick's height, width and counts in base constants
    private static final int BRICK_HEIGHT = 20;
    private static final int BRICK_WIDTH = 40;
    private static final int BRICKS_IN_BASE = 16;

    // The width and height of the window.
    public static final int APPLICATION_WIDTH = 800;
    public static final int APPLICATION_HEIGHT = 600;

    public void run(){

        // Helper variable to reduce the number of bricks in each row
        int newLine = BRICKS_IN_BASE;

        // Two cycles, that create a pyramid from bricks. The inner cycle creates the "rows" of the pyramid,
        // other builds the pyramid from them.
        for(int i = 0; i <= BRICKS_IN_BASE; i++) {
            for (int j = 0; j < newLine; j++) {
                pyramid(i,j);
            }
            newLine--;
        }
    }

    // Method that adds a brick to the bottom and center of the window, using 2 variables
    private void pyramid(int a, int b){
        GRect brick = new GRect(
                getWidth()/2f - (BRICK_WIDTH*(BRICKS_IN_BASE - a))/2f + BRICK_WIDTH*b,
                getHeight() - BRICK_HEIGHT*(a+1),
                BRICK_WIDTH, BRICK_HEIGHT);
        brick.setFilled(true);
        brick.setFillColor(Color.YELLOW);
        add(brick);
    }
}
