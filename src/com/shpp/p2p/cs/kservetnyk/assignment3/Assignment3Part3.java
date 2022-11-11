package com.shpp.p2p.cs.kservetnyk.assignment3;

import com.shpp.cs.a.console.TextProgram;

/*
  Task:
  Read a number from the user, if it's even - take a half of this number, if it's odd - multiply by 3 and add 1
*/

public class Assignment3Part3 extends TextProgram{
    public void run(){

        // Reads a base and an exponent from the user
        double base = readDouble("Enter a base: ");
        int exponent = readInt("Enter an exponent: ");

        // Prints the result of the method "raiseToPower"
        print(base + "^" + exponent + " = " + raiseToPower(base, exponent));
    }

    // Method that takes two parameters and
    // calculates the value of the first parameter raised to the power of the second parameter
    private double raiseToPower(double base, int exponent){

        // Assigns the base value to the result and multiplies the result by the base until the exponent is 1
        double result = base;
        // Auxiliary variable, at exponent < 0
        double result1 = result;

        // If the exponent is 0, then the base is 1
        if(exponent == 0) result = 1;

        // If the exponent is less than zero ---> a^-1 = 1/(a^1)
        if(exponent < 0){
            exponent *= -1;
            while (exponent != 1){
                result1 *= base;
                exponent -= 1;
            }
            result = 1/result1;
        }

        // Calculates a number in exponent
        else{
            while (exponent != 1){
                result *= base;
                exponent -= 1;
            }
        }

        return result;
    }
}
