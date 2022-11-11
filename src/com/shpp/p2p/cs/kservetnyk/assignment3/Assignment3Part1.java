package com.shpp.p2p.cs.kservetnyk.assignment3;

import com.shpp.cs.a.console.TextProgram;

/*
  Task:
  Asks how many minutes a day you work and calculates how much you have left
*/

public class Assignment3Part1 extends TextProgram{

    // Array of days in a week
    public int[] days = new int[7];

    public void run(){

        readValues();
        cardiovascularHealth();
        bloodPressure();

    }

    // Reads 7 values from the user and writes data to an array for ease of use
    private void readValues(){
        for (int i = 0; i < 7; i++) {
            days[i] = readInt("How many minutes did you do on day " + (i+1) + "? ");
        }
    }

    // Method that counts the number of days from a workout
    private int thirtyDaysCount(int[] a){
        // Variable for counting days of working
        int thirtyDaysCount = 0;

        // A cycle that counts the number of days from a workout of 30 minutes
        for (int i = 0; i < 7; i++) {
            if (a[i] >= 30) thirtyDaysCount++;
        }
        return thirtyDaysCount;
    }

    // Method that counts the number of days from a workout
    private int fortyDaysCount(int[] a){
        // Variable for counting days of working
        int fortyDaysCount = 0;

        // A cycle that counts the number of days from a workout of 40 minutes
        for (int i = 0; i < 7; i++) {
            if (a[i] >= 40) fortyDaysCount++;
        }
        return fortyDaysCount;
    }

    // Method that checks how many days a week you work and calculate how much you have left for Cardiovascular health
    private void cardiovascularHealth(){
        int a = thirtyDaysCount(days);

        if (a < 5){
            // Variable how many days left
            int chDays = 5 - a;
            println("Cardiovascular health:\r\nYou needed to train hard for at least " + chDays + " more day(s) a week!");
        }
        if (a >= 5) println("Cardiovascular health:\r\nGreat job! You've done enough exercise for cardiovascular health.");
    }

    // Method that checks how many days a week you work and calculate how much you have left for Blood pressure
    private void bloodPressure(){
        int a = fortyDaysCount(days);

        if (a < 3){
            // Variable how many days left
            int bpDays = 3 - a;
            println("Blood pressure:\r\nYou needed to train hard for at least " + bpDays + " more day(s) a week!");
        }
        if (a >= 3) println("Blood pressure:\r\nGreat job! You've done enough exercise to keep a low blood pressure.");
    }
}
