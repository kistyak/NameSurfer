package com.shpp.p2p.cs.kservetnyk.assignment2;

import com.shpp.cs.a.console.TextProgram;

/*
  Task:
  Write a console program that takes 3 numbers as input and outputs the roots of a quadratic equation.
*/

public class Assignment2Part1 extends TextProgram {
    public void run(){

        // Read three values from the user
        double a = readDouble("Please enter a: ");
        double b = readDouble("Please enter b: ");
        double c = readDouble("Please enter c: ");

        // Counts the discriminant
        double disc = b*b - 4*a*c;

        // Tests the discriminant to see if it is greater than, less than, or equal to zero
        if (disc < 0) println("There are no real roots");

        if (disc == 0){

            // Computes the root and print it out
            double root = -1*b/2*a;
            println("There is one root: " + root);
        }

        if (disc > 0){
            double root1 = (-1*b + Math.sqrt(disc))/(2*a);
            double root2 = (-1*b - Math.sqrt(disc))/(2*a);
            println("There are two roots: " + root1 + " and " + root2);
        }
    }
}
