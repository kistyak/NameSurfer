package com.shpp.p2p.cs.kservetnyk.assignment5;

import com.shpp.cs.a.console.TextProgram;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Assignment5Part4754 extends TextProgram {
    public void run() {

        int column = readInt("Enter a column number: ");
        String filename = "src/com/shpp/p2p/cs/kservetnyk/assignment5/assets/test.csv";
        ArrayList<String> result = extractColumn(filename, column);
        for (String s : result) println(s);

    }

    private ArrayList<String> extractColumn(String filename, int columnIndex) {
        ArrayList<String> fileLines = new ArrayList<>();
        String word;

        try {
            BufferedReader br = new BufferedReader(new FileReader(filename));
            while ((word = br.readLine()) != null) fileLines.add(fieldsIn(word).get(columnIndex));
        }
        catch (IOException e) {
            println("File not found");
            return null;
        }

        return fileLines;
    }

    private ArrayList<String> fieldsIn(String line) {
        ArrayList<String> rowElements = new ArrayList<>();
        StringBuilder field = new StringBuilder();  //separate row element
        char currentCharacter;
        boolean isThereQuotes = false;

        for (int i = 0; i < line.length(); i++) {

            currentCharacter = line.charAt(i);

            switch (currentCharacter) {
                case ',':
                    //Coma can only be a separator when we are not inside quotes.
                    if (!isThereQuotes) {
                        rowElements.add(field.toString());
                        field = new StringBuilder();
                        if (i == line.length() - 1) {
                            rowElements.add(field.toString());
                        }
                        break;
                    }
                    field.append(currentCharacter);
                    break;
                case '"':
                    //If double quotation marks are inside quotes the symbol for quotes goes to the field
                    if (i < line.length() - 2 && isThereQuotes && line.charAt(i + 1) == '"') {
                        field.append(currentCharacter);
                        i++;    //skip one quotation marks
                        break;
                    } else {
                        isThereQuotes = !isThereQuotes; //mark that we`re inside or outside quotes.
                    }
                    break;
                default:
                    field.append(currentCharacter);
            }
        }

        //The ending element does not have a comma, so we add it if there is something after the loop.
        if (!field.isEmpty()) rowElements.add(field.toString());

        return rowElements;
    }
}
