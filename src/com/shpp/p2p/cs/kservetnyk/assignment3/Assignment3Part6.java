package com.shpp.p2p.cs.kservetnyk.assignment3;

import acm.graphics.GLine;
import acm.graphics.GOval;
import acm.graphics.GRect;
import com.shpp.cs.a.graphics.WindowProgram;

/*
  Task:
  Create a 5 seconds animation. It must contain 50+ frames
  "A car drives on a road"
*/

public class Assignment3Part6 extends WindowProgram{

    public void run(){
        // Gets the time at the start
        long startTime = System.currentTimeMillis();

        // Adds a simple scene to window
        scene();

        // Creates a simple car rectangles and circles
        GRect sq1 = new GRect(0, getHeight()/2f, 50, 15);
        sq1.setFilled(true);
        add(sq1);
        GRect sq2 = new GRect(10, getHeight()/2f - 10, 30, 20);
        sq2.setFilled(true);
        add(sq2);
        GOval o1 = new GOval(5, getHeight()/2f + 10, 14, 14);
        o1.setFilled(true);
        add(o1);
        GOval o2 = new GOval(31, getHeight()/2f + 10, 14, 14);
        o2.setFilled(true);
        add(o2);

        long thisTime = 0;

        // The program works while "program work time" less than 5 seconds (5000 milliseconds)
        while(thisTime < 5000){

            // Moves the car's body and wheels to the right by 1 pixel
            sq1.move(1, 0);
            sq2.move(1, 0);
            o1.move(1, 0);
            o2.move(1, 0);

            // One frame time is 10 milliseconds
            pause(10);

            // Checks how many times the program works
            long inTime = System.currentTimeMillis();
            thisTime = inTime - startTime;
        }

        // Gets the time at the end
        long endTime = System.currentTimeMillis();
        // The time difference is the operating time of our program
        long output = endTime - startTime;
        System.out.println("Time of animation: " + output + " milliseconds. Or " + (output/1000) + " seconds.");
    }

    // Method that create the simple scene - the road for out car.
    private void scene(){
        // Makes a road's contour
        GLine road1 = new GLine(0, getHeight()/2f + 30, getWidth(), getHeight()/2f + 30);
        add(road1);
        GLine road2 = new GLine(0, getHeight()/2f - 30, getWidth(), getHeight()/2f - 30);
        add(road2);

        // Makes a dash line of the road
        for (int i = 0; i < getWidth(); i+=20) {
            GLine roadLine = new GLine(i, getHeight()/2f, i+15, getHeight()/2f);
            add(roadLine);
        }
    }
}
