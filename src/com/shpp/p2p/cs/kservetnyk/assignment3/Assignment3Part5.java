package com.shpp.p2p.cs.kservetnyk.assignment3;

import com.shpp.cs.a.console.TextProgram;

import java.util.Random;

/*
  Task:
      St. Petersburg game: Two people play: the lucky one and the sweaty one.
      The game ends when the first person earns $20 or more.
      The sweaty one puts $1 on the table, and the lucky one starts flipping a coin.
      If it is an eagle, then the sweaty person adds exactly the same amount to the amount on the table.
      If it's a tail, everything on the table goes to the lucky person.
      If the lucky person ends up with less than $20, then the game is repeated.
*/

public class Assignment3Part5 extends TextProgram{
    public void run(){

        // Total - the sum of lucky person's money
        int total = 0;
        // Start Amount - the start amount of each match
        int startAmount = 1;
        // Amount - the amount of each match
        int amount;
        // Game count - amount of matches
        int gameCount = 0;

        // The one match. Repeated until the lucky person has $20
        while(total < 20){
            gameCount++;
            amount = startAmount;
            Random random = new Random();
            int fiftyFifty = 0;

            // We toss a coin, if it's an eagle, then we multiply the amount on the table by 2.
            // If not, the entire amount goes to the lucky person.
            // 0 - the eagle.
            while(fiftyFifty == 0){
                fiftyFifty = random.nextInt(2);
                amount *= 2;
            }

            // The entire amount goes to the lucky person.
            total += amount;
            println("This game, you earned $" + amount);
            println("Your total is $" + total);
        }

        // End of the game. Counts how many matches was.
        if(gameCount == 1) println("It takes 1 game to earn $20");
        else println("It takes " + gameCount + " games to earn $20");
    }
}
