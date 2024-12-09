package edu.miracosta.cs112.finalproject.finalproject.Models;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;

import static edu.miracosta.cs112.finalproject.finalproject.Constants.HIGHSCORE_FILE_PATH;

public class scoring {

    public static int scoreUpdate(String alienType, int score){
        if(alienType == "normal"){
            score = score + 10;
        }
        else if(alienType == "zipper"){
            score = score + 15;
        }
        else if(alienType == "tank"){
            score = score += 20;
        }
        System.out.println(score);
        return score;
    }

    public void highScoreUpdate(int score) throws IOException {
        Scanner userin = new Scanner(System.in);
        String name;
        while (true) {
            System.out.println("enter a name, MUST be 3 characters.");
            name = userin.nextLine();

            if (name.length() == 3) {
                System.out.println("input accepted");
                break;
            } else {
                System.out.println("try again. Remember, MUST be 3 characters.");
            }
        }
        String scoreFinal = score + " " + name;
        Files.write(Paths.get(HIGHSCORE_FILE_PATH), scoreFinal.getBytes(), StandardOpenOption.APPEND);

    }



}
