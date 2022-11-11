package com.shpp.p2p.cs.kservetnyk.assignment5;

import com.shpp.cs.a.console.TextProgram;

/*
  Task:
  Counts the number of syllables
*/

public class Assignment5Part1 extends TextProgram {
    public void run() {
        /* Repeatedly prompt the user for a word and print out the estimated
         * number of syllables in that word.
         */
        while (true) {
            String word = readLine("Enter a single word: ");
            println("  Syllable count: " + syllablesIn(word));
        }
    }

    /**
     * Method that accepts a word as a parameter and returns the number of syllables in it.
     * @param word used for counting syllables
     * @return number of syllables
     */
    private int syllablesIn(String word) {

        char[] vowels = new char[]{'a','e','i','o','u','y'};
        word = word.toLowerCase();
        int count = 0;

        for (int i = 0; i < word.length() - 1; i++) {
            for(char vowel : vowels){
                if(i != 0 && word.charAt(i) == vowel && !(word.charAt(i) == vowel && contain(word.charAt(i - 1)))) count++;
            }
        }

        for (char vowel : vowels) {
            if(word.charAt(0) == vowel) count++;
        }

        if (contain(word.charAt(word.length() - 1)) && ((word.charAt(word.length() - 1)) != 'e')) count++;
        if (count == 0) count = 1;

        return count;
    }

    /**
     * Method that return true or false if char c equals to letter
     * @param c char for check
     * @return true if char c equals "a, e, i, o, u, y"
     */
    private boolean contain(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'y';
    }
}
