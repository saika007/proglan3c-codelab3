package com.example;

public class Before {
    public static void main(String[] args) {
        String paragraph = "Java is a popular programming language. It is used worldwide! Many applications run on Java.";
        int words = paragraph.split(" ").length;
        int sentences = paragraph.split("[.!?]").length;
        int characters = paragraph.replace(" ", "").length();

        System.out.println("Paragraph: " + paragraph);
        System.out.println("Word count: " + words);
        System.out.println("Sentence count: " + sentences);
        System.out.println("Character count: " + characters);

        double averageWordLength = (double) characters / words;
        System.out.println("Average word length: " + averageWordLength);

        if (sentences > 2) {
            System.out.println("This is a long paragraph.");
        } else {
            System.out.println("This is a short paragraph.");
        }
    }
}