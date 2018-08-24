package com.example.smarthomes.stringsearchingalgorithms.searching;

/**
 * Boyer-Moore algorithm , in order to find the first occurrence of a given pattern string in a text string. It uses bad character rule
 */

public class BoyerMooreBadCharacter {

    private final int RADIX;
    private int[] right;
    private String pattern;

    /**
     * Preprocesses the pattern string by positioning of rightmost occurrence in the pattern
     * @param pattern the processed pattern string in which we want to find the first occurrence of a given string
     */

    public BoyerMooreBadCharacter(String pattern) {
        this.RADIX = 256;
        this.pattern = pattern;

        right = new int[RADIX];
        for(int character = 0; character < RADIX; character ++) {
            right[character] = -1;
        }
        for(int i = 0; i<pattern.length(); i++) {
            right[pattern.charAt(i)] = i;
        }
    }

    /**
     * Returns the index of the first occurrence of the pattern string in the text string
     * @param text  The text string in which we make the search
     * @return the index of the first occurrence of the pattern string in the text string otherwise -1 if such match doesn't exist
     */

    public int search(String text) {
        int patternLength = pattern.length();
        int textLength = text.length();
        int skip;

        for(int i=0; i<=textLength - patternLength; i+=skip) {
            skip = 0;
            for(int j = patternLength - 1; j>=0; j--) {
                if(pattern.charAt(j) != text.charAt(i+j)) {
                    skip = Math.max(i, j - right[text.charAt(i+j)]);
                    break;
                }
            }
            if(skip == 0) {
                return i;
            }
        }
        return -1;
    }


}
