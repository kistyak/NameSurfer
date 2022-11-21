package com.shpp.p2p.cs.kservetnyk.assignment10;


import java.util.ArrayList;
import java.util.List;

/*
  Task:
  Recursive descent parser
*/

public class Assignment10Part1 {
    public static void main(String[] args) {

        String formula = "1 + 2 * 2";
        List<Lexeme> lexemes = lexicalAnalysis(formula);
        double a = 2;
    }

    /**
     * Method takes a string with an expression and parse it
     * @param expression - string with our expression
     * @return array of lexemes
     */
    public static List<Lexeme> lexicalAnalysis(String expression) {
        ArrayList<Lexeme> lexemes = new ArrayList<>();
        int pos = 0;

        while (pos < expression.length()){
            char c = expression.charAt(pos);
            switch (c) {
                case '(':
                    lexemes.add(new Lexeme(LexemeType.LEFT_BRACKET, c));
                    pos++;
                    continue;
                case ')':
                    lexemes.add(new Lexeme(LexemeType.RIGHT_BRACKET, c));
                    pos++;
                    continue;
                case '+':
                    lexemes.add(new Lexeme(LexemeType.PLUS, c));
                    pos++;
                    continue;
                case '-':
                    lexemes.add(new Lexeme(LexemeType.MINUS, c));
                    pos++;
                    continue;
                case '*':
                    lexemes.add(new Lexeme(LexemeType.MUL, c));
                    pos++;
                    continue;
                case '/':
                    lexemes.add(new Lexeme(LexemeType.DIV, c));
                    pos++;
                    continue;
                default:
                    if (c >= '0' && c <= '9') {
                        StringBuilder sb = new StringBuilder();
                        do {
                            sb.append(c);
                            pos++;
                            if (pos >= expression.length()) break;
                            c = expression.charAt(pos);
                        } while ((c >= '0' && c <= '9') || c == '.');
                        lexemes.add(new Lexeme(LexemeType.NUMBER, String.valueOf(sb)));
                    } else {
                        if (c != ' ') throw new RuntimeException("Wrong type of character: " + c);
                        pos++;
                    }
            }
        }
        lexemes.add(new Lexeme(LexemeType.EOF, ""));
        return lexemes;
    }

    /**
     * Makes some range of values
     */
    public enum LexemeType {
        LEFT_BRACKET, RIGHT_BRACKET,
        PLUS, MINUS,
        MUL, DIV,
        NUMBER,
        EOF
    }

    /**
     * Class for working with each lexeme and its type
     */
    public static class Lexeme {
        LexemeType type;
        String value;

        public Lexeme(LexemeType type, String value) {
            this.type = type;
            this.value = value;
        }

        public Lexeme(LexemeType type, Character value) {
            this.type = type;
            this.value = String.valueOf(value);
        }

        @Override
        public String toString() {
            return "Lexeme{" +
                    "type=" + type +
                    ", value='" + value + '\'' +
                    '}';
        }
    }

    /**
     * Class that makes it easier to move around the array of lexemes
     */
    public static class LexemeBuffer {
        private int pos;
        public List<Lexeme> lexemes;

        public LexemeBuffer(List<Lexeme> lexemes) {
            this.lexemes = lexemes;
        }

        public Lexeme next() {
            return lexemes.get(pos++);
        }

        public void back() {
            pos--;
        }

        public int getPos() {
            return pos;
        }
    }
}
