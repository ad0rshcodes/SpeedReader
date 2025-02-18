/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package edu.grinnell.csc207.speedreader;

import java.awt.*;
import java.io.IOException;

/**
 *
 * @author sharmaad
 */
public class SpeedReader {
    public static void main(String[] args) throws IOException, InterruptedException {
        if (args.length != 5) {
            System.out.println("Usage: SpeedReader <filename> <width> <height> <font size> <wpm>");
            return;
        }

        String filename = args[0];
        int width = Integer.parseInt(args[1]);
        int height = Integer.parseInt(args[2]);
        int fontSize = Integer.parseInt(args[3]);
        int wpm = Integer.parseInt(args[4]);

        int delay = 60000 / wpm;

        WordGenerator generator = new WordGenerator(filename);
        DrawingPanel panel = new DrawingPanel(width, height);
        Graphics g = panel.getGraphics();
        Font font = new Font("Courier", Font.BOLD, fontSize);
        g.setFont(font);

        while (generator.hasNext()) {
            panel.clear();
            String word = generator.next();
            g.drawString(word, width / 2 - g.getFontMetrics().stringWidth(word) / 2, height / 2);
            Thread.sleep(delay);
        }

        // Printing no. of words and sentences in console and drawing panel.

        Thread.sleep(3000);
        panel.clear();
        String word = String.valueOf(generator.getWordCount());
        g.drawString("words: " + word, width / 2 - g.getFontMetrics().stringWidth(word) / 2, height / 2);
        Thread.sleep(3000);
        panel.clear();
        word = String.valueOf(generator.getSentenceCount());
        g.drawString("sentences: " + word, width / 2 - g.getFontMetrics().stringWidth(word) / 2,
                height / 2);

        System.out.println("Words processed: " + generator.getWordCount());
        System.out.println("Sentences processed: " + generator.getSentenceCount());
    }
}
