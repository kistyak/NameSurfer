package com.shpp.p2p.cs.kservetnyk.assignment5;

import com.shpp.cs.a.console.TextProgram;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/*
  Task:
  Takes 3 letters and return words you can make from it
*/

public class Assignment5Part3 extends TextProgram{
    public void run() {
        /* Sit in a loop, reading numbers and adding them. */
        while (true) {
            String aaa = readLine("Enter 3 letters:  ");
            wordFromLetter(aaa);
        }
//        String str = "Helll";
//        int count = 1;
//        for (int i = 0; i < str.length(); i++) {
//            if (str.charAt(i) == 'l') {
//                println(count);
//                count++;
//            }
//        }

    }

    /**
     * Method that takes 3 letters and out words you can make from it
     * @param aaa 3 letter
     */
    private void wordFromLetter(String aaa){

        String file = "src/com/shpp/p2p/cs/kservetnyk/assignment5/assets/en-dictionary.txt";
        aaa = aaa.toLowerCase();

        BufferedReader br;
        String a1 = aaa.substring(0,1);
        String a2 = aaa.substring(1,2);
        String a3 = aaa.substring(2,3);

        try{

            br = new BufferedReader(new FileReader(file));
            String word = br.readLine();
            int count = 0;

            // Reads each line from file
            while (word != null){

                int i1 = word.indexOf(a1);
                int i2 = word.indexOf(a2, 1);
                int i3 = word.indexOf(a3, 2);

                // Outs word from our 3 letters if word contains these letters in the same order
                if (word.contains(a1) && word.contains(a2) && word.contains(a3) && (i3 > i2 && i2 > i1)) {
                    println("You can make a word - " + word);
                    count++;
                }

                word = br.readLine();
            }
            br.close();
            if (count == 0) println("No more words left");
        }
        catch (IOException e){
            println("Something went wrong");
        }
    }
}
