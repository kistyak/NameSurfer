package com.shpp.p2p.cs.kservetnyk.assignment2;

import acm.graphics.GOval;
import com.shpp.cs.a.graphics.WindowProgram;

/*
  Task:
  Create method that print paw and draw 2 paws
*/

public class Assignment2Part3 extends WindowProgram {

    /* Constants controlling the relative positions of the
     * three toes to the upper-left corner of the pawprint.
     *
     * (Yes, I know that actual pawprints have four toes.
     * Just pretend it's a cartoon animal. ^_^)
     */
    private static final double FIRST_TOE_OFFSET_X = 0;
    private static final double FIRST_TOE_OFFSET_Y = 20;
    private static final double SECOND_TOE_OFFSET_X = 30;
    private static final double SECOND_TOE_OFFSET_Y = 0;
    private static final double THIRD_TOE_OFFSET_X = 60;
    private static final double THIRD_TOE_OFFSET_Y = 20;

    /* The position of the heel relative to the upper-left
     * corner of the pawprint.
     */
    private static final double HEEL_OFFSET_X = 20;
    private static final double HEEL_OFFSET_Y = 40;

    /* Each toe is an oval with this width and height. */
    private static final double TOE_WIDTH = 20;
    private static final double TOE_HEIGHT = 30;

    /* The heel is an oval with this width and height. */
    private static final double HEEL_WIDTH = 40;
    private static final double HEEL_HEIGHT = 60;

    /* The default width and height of the window. These constants will tell Java to
     * create a window whose size is *approximately* given by these dimensions. You should
     * not directly use these constants in your program; instead, use getWidth() and
     * getHeight(), which return the *exact* width and height of the window.
     */
    public static final int APPLICATION_WIDTH = 270;
    public static final int APPLICATION_HEIGHT = 220;

    public void run() {
        drawPawprint(20, 20);
        drawPawprint(180, 70);
    }

    // Method that draw the paw by coordinates x and y
    private void drawPawprint(double x, double y) {

        // Create 3 fingers (x coordinate, y coordinate, width, height)
            // Create an object of class GOval named firstToe
        GOval firstToe = new GOval(
                getWidth() - getWidth() + x + FIRST_TOE_OFFSET_X,
                getHeight() - getHeight() + y + FIRST_TOE_OFFSET_Y,
                TOE_WIDTH, TOE_HEIGHT);
            // Fill the object by color (default - black)
        firstToe.setFilled(true);
            // Add object to window
        add(firstToe);

        GOval secondToe = new GOval(
                getWidth() - getWidth() + x + SECOND_TOE_OFFSET_X,
                getHeight() - getHeight() + y + SECOND_TOE_OFFSET_Y,
                TOE_WIDTH, TOE_HEIGHT);
        secondToe.setFilled(true);
        add(secondToe);

        GOval thirdToe = new GOval(
                getWidth() - getWidth() + x + THIRD_TOE_OFFSET_X,
                getHeight() - getHeight() + y + THIRD_TOE_OFFSET_Y,
                TOE_WIDTH, TOE_HEIGHT);
        thirdToe.setFilled(true);
        add(thirdToe);

        // Create heel (x coordinate, y coordinate, width, height)
        GOval heel = new GOval(
                getWidth() - getWidth() + x + HEEL_OFFSET_X,
                getHeight() - getHeight() + y + HEEL_OFFSET_Y,
                HEEL_WIDTH, HEEL_HEIGHT);
        heel.setFilled(true);
        add(heel);
    }
}