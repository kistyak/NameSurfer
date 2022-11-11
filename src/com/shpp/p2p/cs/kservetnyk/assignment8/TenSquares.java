package com.shpp.p2p.cs.kservetnyk.assignment8;


import acm.graphics.GObject;
import acm.graphics.GRect;
import com.shpp.cs.a.graphics.WindowProgram;
import java.awt.event.MouseEvent;

/*
  Task:
  Make 10 squares that moves if you click on it and stops with adjacent squares if click again
*/

public class TenSquares extends WindowProgram implements TenSquaresConstants{

    public void run() {
        // Creates and add squares to the window
        addSquares();
        addMouseListeners();

        // Runs animation
        while (true){
            moving();
        }
    }

    /**
     * Method that animate the squares
     */
    private void moving() {

        for (int i = 0; i < SQUARE_COUNT; i++) {
            if (isMoving[i]) {
                squares[i].move(x[i],0);
                if (squares[i].getX() + SQUARE_SIDE == getWidth() || squares[i].getX() == 0) x[i] *= -1;
            }
        }

        pause(PAUSE_TIME);
    }

    /**
     * Method that processes the mouse click
     * @param mouseEvent the event to be processed
     */
    public void mouseClicked(MouseEvent mouseEvent){
        GObject obj = getElementAt(mouseEvent.getX(), mouseEvent.getY());

        if (obj != null){
            // A cycle that checks if there was a click on the square
            for (int i = 0; i < SQUARE_COUNT; i++) {
                if (obj == squares[i]) {
                    // If there was a click, the square moves. Or stops, if they are moving
                    if (!isMoving[i]) {
                        isMoving[i] = true;
                        neighbor(i, isMoving[i]);
                    } else {
                        isMoving[i] = false;
                        neighbor(i, isMoving[i]);
                        x[i] = -1;
                    }
                }
            }
        }
    }

    /**
     * Method that stop or move adjacent squares
     * @param i current square's index
     * @param flag boolean value if square moving
     */
    private void neighbor(int i, boolean flag){
        if (i > 0) {
            isMoving[i - 1] = flag;
            if (!flag) x[i - 1] = -1;
        }
        if (i < SQUARE_COUNT - 1) {
            isMoving[i + 1] = flag;
            if (!flag) x[i + 1] = -1;
        }
    }

    /**
     * Method that make and add squares to the window
     */
    private void addSquares(){
        for (int i = 0; i < squares.length; i++) {
            squares[i] = new GRect(
                    getWidth()/2f - SQUARE_SIDE/2f,
                    getHeight()/2f -
                            (SQUARE_SIDE * squares.length + SQUARE_SIDE * (squares.length - 1))/2
                            + 2 * SQUARE_SIDE * i,
                    SQUARE_SIDE, SQUARE_SIDE);
            squares[i].setFilled(true);
            add(squares[i]);
        }
    }
}
