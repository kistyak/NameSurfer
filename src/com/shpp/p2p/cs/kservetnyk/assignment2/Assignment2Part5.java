package com.shpp.p2p.cs.kservetnyk.assignment2;

import acm.graphics.GLine;
import acm.graphics.GRect;
import com.shpp.cs.a.graphics.WindowProgram;

/*
  Task:
  Draw a tricolor flag in the center of the window and the name of the country in the lower right corner
*/

public class Assignment2Part5 extends WindowProgram {

    /* The number of rows and columns in the grid, respectively. */
    private static final int NUM_ROWS = 5;
    private static final int NUM_COLS = 6;

    /* The width and height of each box. */
    private static final double BOX_SIZE = 40;

    /* The horizontal and vertical spacing between the boxes. */
    private static final double BOX_SPACING = 10;

    // The default width and height of the window.
    public static final int APPLICATION_WIDTH = 600;
    public static final int APPLICATION_HEIGHT = 600;

    public void run(){

        // Create a matrix by two "for i" loops
        for (int i = 0; i < NUM_COLS; i++) {
            for (int j = 0; j < NUM_ROWS; j++) {
                box(i,j);
            }
        }

        // Two lines that intersect in the center of the window (uncomment "Ctrl + /" the lines below)
//        GLine line1 = new GLine(getWidth()/2f, 0, getWidth()/2f, getHeight());
//        add(line1);
//        GLine line2 = new GLine(0, getHeight()/2f, getWidth(), getHeight()/2f);
//        add(line2);
    }

    // Method that create a box with x and y coordinates
    private void box(int x, int y){

        // Create an object of class GRect named box
        GRect box = new GRect(
                getWidth()/2f - (BOX_SIZE*NUM_COLS + BOX_SPACING*(NUM_COLS-1))/2 + (BOX_SIZE*x + BOX_SPACING*x),
                getHeight()/2f - (BOX_SIZE*NUM_ROWS + BOX_SPACING*(NUM_ROWS-1))/2 + (BOX_SIZE*y + BOX_SPACING*y),
                BOX_SIZE, BOX_SIZE);
        // Fill the object by color (default - black)
        box.setFilled(true);
        // Add the box
        add(box);
    }
}
