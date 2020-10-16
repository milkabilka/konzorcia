package com.mg.konzorcia.textscanner;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextScanner {

    public static void main(String[] args) {
        String text="";

        try {
            byte[] input=Files.readAllBytes(Paths.get("src/com/mg/konzorcia/textscanner/valami.txt"));
            text=new String(input, StandardCharsets.UTF_8);
        } catch (IOException e) {
            System.out.println("Couldn't reach valami.txt" + e.getMessage());
            e.printStackTrace();
        }

        String word="magna";
        Pattern wordPattern=Pattern.compile(word);
        Matcher wordMatcher=wordPattern.matcher(text);

        int counter=0;

        while (wordMatcher.find()) {
            counter++;
        }
        System.out.println("The word \"" + word + "\" occurs " + counter + " times in the text.");
    }
}
