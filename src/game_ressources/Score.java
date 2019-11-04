package game_ressources;

import java.io.*;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Score {

    /*

    private String scoreFile = "score.txt";

    public static void main(String[] args) throws IOException {
        Score score = new Score();
        score.setScore("test", 42);
        System.out.println(score.getScore("test"));
    }

    public String[][] getAllScores() {
        String[][] scores = new String[0][];
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(scoreFile));
            String line = reader.readLine();
            int index = 0;
            while (line != null) {
                String[] fileLine = line.split(";");
                scores = new String[0][0];
                scores = new String[0][1];
                scores[1][0] = fileLine[0];
                scores[index][1] = fileLine[1];
                line = reader.readLine();
                index++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return scores;
    }

    public int getScore(String pseudo) {
        BufferedReader reader;
        int result = 0;
        try {
            reader = new BufferedReader(new FileReader(scoreFile));
            String line = reader.readLine();
            while (line != null) {
                String[] fileLine = line.split(";");
                if(pseudo.equals(fileLine[0])) {
                    result = Integer.parseInt(fileLine[1]);
                    line = null;
                }
                else {
                    line = reader.readLine();
                }
            }
            reader.close();
            return result;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    //---RECORDING OF THE PLAYER'S NEW SCORE---
    //If the new score is higher than the recorded score : update the recorded score and return True.
    //If the new score is less than or equivalent to the recorded score : not update the recorded score and return False.
    public boolean setScore(String pseudo, int score) throws IOException {
        String[][] scores = getAllScores();
        System.out.println(Arrays.deepToString(scores));
        FileWriter fw = new FileWriter(scoreFile, true);
        fw.write("\n" + pseudo + ";" + score);
        fw.close();
        return true;
    }


     */

}
