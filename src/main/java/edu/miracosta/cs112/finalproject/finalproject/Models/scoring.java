package edu.miracosta.cs112.finalproject.finalproject.Models;

public class scoring {

    public int scoreUpdate(int alienType){
        int score = 0;
        if(alienType == 1){
            score += 10;
        }
        else if(alienType == 2){
            score += 20;
        }
        else if(alienType == 3){
            score += 20;
        }
        return score;
    }

//    public int void highScoreUpdate(int score) throws IOException {
//        Scanner userin = new Scanner(System.in);
//        String name;
//        while (true) {
//            System.out.println("enter a name, MUST be 3 characters.");
//            name = userin.nextLine();
//
//            if (name.length() == 3) {
//                System.out.println("input accepted");
//                break;
//            } else {
//                System.out.println("try again. Remember, MUST be 3 characters.");
//            }
//        }
//        String scoreFinal = score + " " + name;
//        Files.write(Paths.get(HIGHSCORE_FILE_PATH), scoreFinal.getBytes(), StandardOpenOption.APPEND);
//
//    }



}
