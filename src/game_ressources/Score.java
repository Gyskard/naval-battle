package game_ressources;

import java.io.*;

public class Score {

    /*

    String scoreFile = "score.txt";

    public static void main(String[] args) {
        Score score = new Score();
        score.getScore("jean-kevin-du-93");
    }

    private int getScore(String pseudo) {
        BufferedReader reader;
        int result = 0;
        String pseudoInFile;
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


     */
}
