package com.shpp.p2p.cs.kservetnyk.assignment5;

import com.shpp.cs.a.console.TextProgram;

/*
  Task:
  Creates algorithm for adding large numbers
*/

public class Assignment5Part2 extends TextProgram{

    public void run() {
    /* Sit in a loop, reading numbers and adding them. */
    while (true) {
        String n1 = readLine("Enter first number:  ");
        String n2 = readLine("Enter second number: ");
        println(n1 + " + " + n2 + " = " + addNumericStrings(n1, n2));
        println();
    }
}

    /**
     * Method that takes two numbers in string type and add them
     * @param n1 first number in string type
     * @param n2 second number in string type
     * @return count of numbers n1 and n2
     */
    private String addNumericStrings(String n1, String n2) {
        char ch1;
        char ch2;
        int value1;
        int value2;
        int value3 = 0;
        int value4;
        int value5;
        String res1;
        String result = "";

        // For n1 = n2
        if(n1.length() == n2.length()){
            for(int i = n1.length() - 1; i >= 0; i--) {
                ch1 = n1.charAt(i);
                ch2 = n2.charAt(i);
                value1 = ch1 - '0';
                value2 = ch2 - '0';
                value4 = value1 + value2 + value3;
                value3 = 0;
                if(value4 >= 10){
                    value5 = value4 - 10;
                    value3 = 1;
                    res1 = String.valueOf(value5);
                }else{
                    res1 = String.valueOf(value4);
                }
                result = res1 + result;
            }
            if (value3 > 0) result = "1" + result;
        }

        // For n1 > n2
        else if(n1.length() > n2.length()){
            int n = n1.length() - n2.length();

            for(int i = n2.length() - 1; i >= 0; i--) {
                ch1 = n1.charAt(i + n);
                ch2 = n2.charAt(i);
                value1 = ch1 - '0';
                value2 = ch2 - '0';
                value4 = value1 + value2 + value3;
                value3 = 0;
                if(value4 >= 10){
                    value5 = value4 - 10;
                    value3 = 1;
                    res1 = String.valueOf(value5);
                }else{
                    res1 = String.valueOf(value4);
                }
                result = res1 + result;
            }

            String str = n1.substring(0, n);
            result = str + result;
        }

        // For n2 > n1
        else {
            int n = n2.length() - n1.length();

            for(int i = n1.length() - 1; i >= 0; i--) {
                ch1 = n1.charAt(i);
                ch2 = n2.charAt(i + n);
                value1 = ch1 - '0';
                value2 = ch2 - '0';
                value4 = value1 + value2 + value3;
                value3 = 0;
                if(value4 >= 10){
                    value5 = value4 - 10;
                    value3 = 1;
                    res1 = String.valueOf(value5);
                }else{
                    res1 = String.valueOf(value4);
                }
                result = res1 + result;
            }

            String str = n2.substring(0, n);
            result = str + result;

        }
        return result;
    }
}
