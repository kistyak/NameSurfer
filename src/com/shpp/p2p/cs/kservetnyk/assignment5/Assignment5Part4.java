package com.shpp.p2p.cs.kservetnyk.assignment5;

import com.shpp.cs.a.console.TextProgram;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/*
  Task:
  Creates method that opens a CSV file with the name filename,
  and returns all the values in the columnIndex in the form of an array
*/

public class Assignment5Part4 extends TextProgram {

    public void run() {

        int column = readInt("Enter a column number: ");
        String filename = "src/com/shpp/p2p/cs/kservetnyk/assignment5/assets/test.csv";
        ArrayList<String> result = extractColumn(filename, column);
        for (String s : result) println(s);

    }

    /**
     * Method that opens a CSV file with the name filename,
     * and returns all the values in the columnIndex in the form of an array
     * @param filename name of file
     * @param columnIndex index of column
     * @return all the values in the columnIndex in the form of an array
     */
    private ArrayList<String> extractColumn(String filename, int columnIndex){

        ArrayList<String> fileLines = new ArrayList<>();
        ArrayList<String> columnElements = new ArrayList<>();
        BufferedReader br;

        // Opens file and read lines to array
        try{
            br = new BufferedReader(new FileReader(filename));
            String word = br.readLine();
            while (word != null){

                fileLines.add(word);
                word = br.readLine();
            }
            br.close();
        }
        catch (IOException e){
            println("Something went wrong");
        }

        // Each line splits by "," and add value to an array
        for (String fileLine : fileLines){
            String[] splittedText = fileLine.split(",");
            ArrayList<String> columnList = new ArrayList<>();
            for (String s : splittedText) {
                // Checks if column starts with ""
                if (IsColumnPart(s)) {
                    String lastText = columnList.get(columnList.size() - 1);
                    String str = lastText + "," + s;
                    String res = str.substring(1, str.length() - 1);
                    columnList.set(columnList.size() - 1, res);
                } else {
                    columnList.add(s);
                }
            }
            columnElements.add(columnList.get(columnIndex));
        }

        return columnElements;
    }

    /**
     * If there is one quotation mark in the text and the text ends with it, then it is part of the previous column
     * @param text for check
     * @return text without quotes
     */
    private static boolean IsColumnPart(String text) {
        String trimText = text.trim();
        return trimText.indexOf("\"") == trimText.lastIndexOf("\"") && trimText.endsWith("\"");
    }
}
