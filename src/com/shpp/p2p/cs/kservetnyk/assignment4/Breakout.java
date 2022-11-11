package com.shpp.p2p.cs.kservetnyk.assignment4;

import acm.graphics.GLabel;
import acm.graphics.GObject;
import acm.graphics.GOval;
import acm.graphics.GRect;
import com.shpp.cs.a.graphics.WindowProgram;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.Random;

/*
  Task:
  Should I really need to describe this task?
*/

public class Breakout extends WindowProgram{

    /** Width and height of application window in pixels */
    public static final int APPLICATION_WIDTH = 400;
    public static final int APPLICATION_HEIGHT = 600;

    /** Dimensions of game board (usually the same) */
    private static final int WIDTH = APPLICATION_WIDTH;
    private static final int HEIGHT = APPLICATION_HEIGHT;

    /** Dimensions of the paddle */
    private static final int PADDLE_WIDTH = 60;
    private static final int PADDLE_HEIGHT = 10;

    /** Offset of the paddle up from the bottom */
    private static final int PADDLE_Y_OFFSET = 30;

    /** Number of bricks per row */
    private static final int NBRICKS_PER_ROW = 10;

    /** Number of rows of bricks */
    private static final int NBRICK_ROWS = 10;

    /** Separation between bricks */
    private static final int BRICK_SEP = 4;

    /** Width of a brick */
    private static final int BRICK_WIDTH =
            (WIDTH - (NBRICKS_PER_ROW - 1) * BRICK_SEP) / NBRICKS_PER_ROW;

    /** Height of a brick */
    private static final int BRICK_HEIGHT = 8;

    /** Radius of the ball in pixels */
    private static final int BALL_RADIUS = 10;

    /** Offset of the top brick row from the top */
    private static final int BRICK_Y_OFFSET = 70;

    /** Number of turns */
    private static int NTURNS = 3;

    // Boolean value that "true" while round is going
    private boolean playing = false;
    // For counting score
    private int scoreInt = 0;
    // For counting how many bricks left to win
    private int bricksLeft = 100;
    // Time for one frame in milliseconds
    private static final int TIME = 10;

    public void run() {

        // Adds text, score, paddle and bricks to the scene
        addLable();
        addScore();
        paddle();
        addBricks();

        // Adds MouseListeners for "listen" the mouse manipulation
        addMouseListeners();

        // Makes a ball and add it
        GOval ball = makeBall();
        add(ball);

        // Main game logic, NTURNS - number of rounds
        while(NTURNS > 0){
            waitForClick();
            playing = true;
            // One round logic
            game(ball);
        }
    }

    // Follows the mouse and move the paddle
    public void mouseMoved(MouseEvent mouseEvent){
        double mouseGet = mouseEvent.getX();
        if(mouseGet <= PADDLE_WIDTH/2f){
            paddle.setLocation(0,getHeight() - PADDLE_Y_OFFSET - PADDLE_HEIGHT/2f);
        }
        else if(mouseGet >= getWidth() - PADDLE_WIDTH/2f){
            paddle.setLocation(getWidth() - PADDLE_WIDTH,getHeight() - PADDLE_Y_OFFSET - PADDLE_HEIGHT/2f);
        }
        else{
            paddle.setLocation(mouseEvent.getX() - PADDLE_WIDTH / 2f,
                    getHeight() - PADDLE_Y_OFFSET - PADDLE_HEIGHT / 2f);
        }
    }


    // Creates the paddle and add it
    GRect paddle = null;
    private void paddle(){
        paddle = new GRect(
                getWidth()/2f - PADDLE_WIDTH/2f,
                getHeight() - PADDLE_Y_OFFSET - PADDLE_HEIGHT/2f,
                PADDLE_WIDTH, PADDLE_HEIGHT);
        paddle.setFilled(true);
        paddle.setColor(Color.BLUE);
        add(paddle);
    }

    // Method that adds text
    GLabel tracker = null;
    private void addLable(){
        tracker = new GLabel("Click to Start", 15, 30);
        tracker.setFont("Calibri-24");
        add(tracker);
    }

    // Method that adds score text
    GLabel score = null;
    private void addScore(){
        score = new GLabel("Score: " + scoreInt, 275, 30);
        score.setFont("Calibri-24");
        add(score);
    }

    // Method that makes ball and return it
    private GOval makeBall(){
        GOval ball = new GOval(
                getWidth()/2f - BALL_RADIUS,
                getHeight()/2f - BALL_RADIUS,
                2*BALL_RADIUS, 2*BALL_RADIUS);
        ball.setFilled(true);
        return ball;
    }

    // The round logic
    int games = NTURNS;
    private void game(GOval ball){
        // The speed of ball. First value is random every new round
        double vx;
        double vy = 3;

        // Outs how many rounds left
        if(games == 1) tracker.setLabel("1 try left.");
        if(games != 1) tracker.setLabel((games) + " tries left.");

        Random rgen = new Random();
        vx = rgen.nextDouble(1.0, 3.0);
        if (rgen.nextBoolean()) vx = -vx;

        while(playing){

            ball.move(vx, vy);

            // Bounce from 3 walls
            if(ball.getX() + 2*BALL_RADIUS > getWidth()) vx *= -1;
            if(ball.getX() < 0) vx *= -1;
            if(ball.getY() < 0) vy *= -1;

            // Ball's points
            GObject point1 = getElementAt(ball.getX(), ball.getY() + 2*BALL_RADIUS);
            GObject point2 = getElementAt(ball.getX() + 2*BALL_RADIUS, ball.getY() + 2*BALL_RADIUS);
            GObject ballXY = getElementAt(ball.getX(), ball.getY());
            GObject point3 = getElementAt(ball.getX() + 2*BALL_RADIUS, ball.getY());

            // Bounce from the paddle
            if(point1 == paddle || point2 == paddle) vy *= -1;

            // Checks if ball hit the brick and remove it, add score and turn the ball
            // If ball's 4 points don't hit the paddle, labels and not null, means that ball hit the brick
            if(ball.getY() < (getHeight() - PADDLE_HEIGHT - PADDLE_Y_OFFSET - BALL_RADIUS*2) &&
                    (ball.getY() > BRICK_Y_OFFSET) &&
                    (ballXY != paddle || point3 != paddle) &&
                    (ballXY != null || point3 != null) &&
                    (ballXY != score || point3 != score) &&
                            (ballXY != tracker || point3 != tracker)){

                if(ballXY != null && ballXY != tracker && ballXY != paddle && ballXY != score) remove(ballXY);
                else if(point3 != null && point3 != tracker && point3 != paddle && point3 != score) remove(point3);
                vy *= -1;
                if(NTURNS == 3) scoreInt+=15;
                if(NTURNS == 2) scoreInt+=10;
                if(NTURNS == 1) scoreInt+=5;
                score.setLabel("Score: " + scoreInt);
                bricksLeft--;
            }
            if(ball.getY() < (getHeight() - PADDLE_HEIGHT - PADDLE_Y_OFFSET - BALL_RADIUS*2) &&
                    (ball.getY() > BRICK_Y_OFFSET) &&
                    (point1 != paddle || point2 != paddle) &&
                    (point1 != null || point2 != null) &&
                    (point1 != score || point2 != score) &&
                            (point1 != tracker || point2 != tracker)){

                if(point1 != null && point1 != tracker && point1 != paddle && point1 != score) remove(point1);
                else if(point2 != null && point2 != tracker && point2 != paddle && point2 != score) remove(point2);
                vy *= -1;
                if(NTURNS == 3) scoreInt+=15;
                if(NTURNS == 2) scoreInt+=10;
                if(NTURNS == 1) scoreInt+=5;
                score.setLabel("Score: " + scoreInt);
                bricksLeft--;
            }

            // If ball hits the bottom wall - the round ends, ball set to center of scene
            if(ball.getY() + 2*BALL_RADIUS > getHeight()){
                playing = false;
                ball.setLocation(getWidth()/2f - BALL_RADIUS,getHeight()/2f - BALL_RADIUS);
            }

            // If the value of how many bricks left equals 0 that all bricks removed and player win
            if(bricksLeft == 0) {
                tracker.setLabel("You Win!");
                playing = false;
                NTURNS = 0;
            }

            pause(TIME);
        }

        games--;
        NTURNS--;
        if(NTURNS != 0) tracker.setLabel(tracker.getLabel() + " Click!");

        // End of game
        if(NTURNS == 0) tracker.setLabel("Game Over");
    }

    // Method that adds bricks
    private void bricks(int a, int b){
        GRect brick = new GRect(
                getWidth()/2f - (NBRICKS_PER_ROW * BRICK_WIDTH + (NBRICKS_PER_ROW - 1) * BRICK_SEP)/2f + a * (BRICK_WIDTH + BRICK_SEP),
                BRICK_Y_OFFSET + b * (BRICK_HEIGHT + BRICK_SEP),
                BRICK_WIDTH, BRICK_HEIGHT);
        brick.setFilled(true);
        add(brick);

        // Different colors for every row
        if(b < 2) {
            brick.setFillColor(Color.RED);
            brick.setColor(Color.RED);
        }
        if(b == 2 || b== 3) {
            brick.setFillColor(Color.ORANGE);
            brick.setColor(Color.ORANGE);
        }
        if(b == 4 || b == 5) {
            brick.setFillColor(Color.YELLOW);
            brick.setColor(Color.YELLOW);
        }
        if(b == 6 || b == 7) {
            brick.setFillColor(Color.GREEN);
            brick.setColor(Color.GREEN);
        }
        if(b > 7) {
            brick.setFillColor(Color.CYAN);
            brick.setColor(Color.CYAN);
        }
    }

    // Adds rows and columns of bricks
    private void addBricks(){
        for (int i = 0; i < NBRICKS_PER_ROW; i++) {
            for (int j = 0; j < NBRICK_ROWS; j++) {
                bricks(i, j);
            }
        }
    }
}