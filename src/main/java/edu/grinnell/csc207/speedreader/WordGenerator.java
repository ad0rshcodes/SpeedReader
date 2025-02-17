/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.grinnell.csc207.speedreader;

/**
 *
 * @author sharmaad
 */

import java.util.Scanner;
import java.io.File;
import java.io.IOException;

public class WordGenerator {

    private Scanner text;
    private int wordCount;
    private int sentenceCount;

    /**
     * Constructs a WordGenerator that reads from the specified file.
     *
     * @param filename the name of the file to read words from
     * @throws IOException if an error occurs while opening the file
     */
    
    public WordGenerator(String filename) throws IOException {
        this.text = new Scanner(new File(filename));
        this.wordCount = 0;
        this.sentenceCount = 0;
    }

    /**
     * Checks if there are more words to read from the file.
     *
     * @return true if there are more words, false otherwise
     */
    public boolean hasNext() {
        return text.hasNext();
    }

    /**
     * Returns the next word from the file and updates the word and sentence counts.
     *
     * @return the next word from the file
     * @throws IllegalStateException if there are no more words available
     */
    public String next() {
        if (!hasNext()) {
            throw new IllegalStateException("No more words available.");
        }
        String word = text.next();
        wordCount++;

        // if the word ends with a sentence-ending punctuation mark
        if (word.endsWith(".") || word.endsWith("!") || word.endsWith("?")) {
            sentenceCount++;
        }

        return word;
    }

    /**
     * Returns the total number of words read so far.
     *
     * @return the word count
     */
    public int getWordCount() {
        return wordCount;
    }
    
    /**
     * Returns the total number of sentences detected so far.
     *
     * @return the sentence count
     */

    public int getSentenceCount() {
        return sentenceCount;
    }
}
