package com.shpp.p2p.cs.kservetnyk.assignment8;

import acm.graphics.GRect;

public interface TenSquaresConstants {

    // Width and height of application window in pixels
    public static final int APPLICATION_WIDTH = 300;
    public static final int APPLICATION_HEIGHT = 400;

    // Counts and value of square side
    public static final double SQUARE_SIDE = 10;
    public static final int SQUARE_COUNT = 10;

    // Time of one frame in milliseconds
    public static final int PAUSE_TIME = 50;

    // Array of squares
    public final GRect[] squares = new GRect[SQUARE_COUNT];

    // Array for checking movement of each squares
    public final boolean[] isMoving = new boolean[SQUARE_COUNT];

    // The speed of each square
    public int[] x = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
}
