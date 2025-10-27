package com.example;

import java.util.Scanner;

public class ParagraphAnalysis {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        new ParagraphAnalysis().run();
    }

    private void run() {
        boolean running = true;

        while (running) {
            printMenu(); 
            int choice = getMenuChoice();

            switch (choice) {
                case 1 -> analyzeParagraph();
                case 2 -> System.out.println("Exiting program. Goodbye!");
                default -> System.out.println("Invalid choice, please try again.");
            }

            if (choice == 2) {
                running = false;
            }
        }
    }

    private void printMenu() {
        System.out.println("\n=== PARAGRAPH ANALYZER ===");
        System.out.println("1. Analyze a paragraph");
        System.out.println("2. Exit");
        System.out.print("Enter your choice: ");
    }

    private int getMenuChoice() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    private void analyzeParagraph() {
        System.out.println("\nEnter a paragraph:");
        String paragraph = scanner.nextLine();

        ParagraphAnalyzer analyzer = new ParagraphAnalyzer(paragraph);

        analyzer.printReport();
    }
}


class ParagraphAnalyzer {
    private static final String SENTENCE_DELIMITERS = "[.!?]";
    private static final String WORD_DELIMITER = " ";

    private final String text;

    public ParagraphAnalyzer(String text) {
        this.text = text.trim();
    }

    public int getWordCount() {
        return text.split(WORD_DELIMITER).length;
    }

    public int getSentenceCount() {
        return text.split(SENTENCE_DELIMITERS).length;
    }

    public int getCharacterCount() {
        return text.replace(" ", "").length();
    }

    public double getAverageWordLength() {
        return (double) getCharacterCount() / getWordCount();
    }

    public void printReport() {
        System.out.println("\n--- ANALYSIS RESULT ---");
        System.out.println("Paragraph: " + text);
        System.out.println("Word count: " + getWordCount());
        System.out.println("Sentence count: " + getSentenceCount());
        System.out.println("Character count: " + getCharacterCount());
        System.out.printf("Average word length: %.2f%n", getAverageWordLength());
        System.out.println(getParagraphLengthType()); // [Refactoring #14] Extract Method → adds readability
        System.out.println("------------------------\n");
    }

    private String getParagraphLengthType() {
        return getSentenceCount() > 2 ? "This is a long paragraph." : "This is a short paragraph.";
    }

    private int tambah(int a, int b) {
        return a + b;
    }
}
