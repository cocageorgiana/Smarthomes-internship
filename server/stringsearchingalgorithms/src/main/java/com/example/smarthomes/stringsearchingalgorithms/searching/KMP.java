package com.example.smarthomes.stringsearchingalgorithms.searching;

/**
 * Implementation of the KMP algorithm in order to find the first occurrence of a pattern string in a given text string
 */

public class KMP {

    private final int RADIX;
    private int[][] dfa;

    private String pattern;

    /**
     * Processes the patern string by creating the necessarily DFA with all the characters
     * @param pattern The pattern string
     */

    public KMP(String pattern) {
        this.RADIX = 256;
        this.pattern = pattern;

        int m = pattern.length();
        dfa = new int[RADIX][m];
        dfa[pattern.charAt(0)][0] = 1;

        for (int x = 0, j = 1; j < m; j++) {
            for (int c = 0; c < RADIX; c++)
                dfa[c][j] = dfa[c][x];
            dfa[pattern.charAt(j)][j] = j+1;
            x = dfa[pattern.charAt(j)][x];
        }
    }

    /**
     * Returns the index of the first occrrence of the pattern string in the text string by performing the KMP specific operations on the DFA previously created
     * @param txt The text string in which we want to find the first occurrence
     * @return The index of the first occurrence of the pattern string in the text string or -1 otherwise if no such match exists
     */

    public int search(String txt) {

        int m = pattern.length();
        int n = txt.length();

        int i, j;
        for (i = 0, j = 0; i < n && j < m; i++) {
            j = dfa[txt.charAt(i)][j];
        }

        if (j == m) return i - m;    // found
        return -1;                    // not found
    }
}
