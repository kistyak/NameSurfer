package com.shpp.p2p.cs.kservetnyk.assignment3;

import com.shpp.cs.a.console.TextProgram;

/*
  Task:
  Read a number from the user, if it's even - take a half of this number, if it's odd - multiply by 3 and add 1
*/

public class Assignment3Part2 extends TextProgram{
    public void run(){

        counts();
        println("Done!");
    }

    // Read the number from the user
    private int read(){
        int n = readInt("Enter a number: ");
        return n;
    }

    // Until the number is equal to 1, program take a half if it's even or multiply by 3 and add 1 if it's odd
    private void counts(){
        int n = read();
        while(n != 1){
            if(n%2 == 0) {
                print(n + " is even so I take half: ");
                n /= 2;
                println(n);
            }
            else {
                print(n + " is odd so I make 3n + 1: ");
                n = 3 * n + 1;
                println(n);
            }
        }
    }
}
