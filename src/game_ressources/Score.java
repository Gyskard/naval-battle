package game_ressources;

import java.io.*;

public class Score {

    private String scoreFile = "score.txt";

    //---INDICATES IF THE PLAYER'S SCORE IS GREATER THAN HIS PREVIOUS SCORE--
    //If the new score is higher than the recorded score or if he doesn't have an old score: return True.
    //If the new score is less than or equivalent to the recorded score : return False.
    private boolean isNewScore(String pseudo, int scorePseudo, String[][] scores) {
        boolean hasRecord = false;
        for(String[] lineInFile : scores) {
            //If the score belongs to the player of the new record
            if(lineInFile[0].equals(pseudo)) {
                //Saves the presence of an old score
                hasRecord = true;
                //If the new score is greater than the old score
                if(Integer.parseInt(lineInFile[1]) < scorePseudo) {
                    return true;
                }
            }
        }
        //If the player doesn't have an old score : return True.
        //Else : return false;
        return !(hasRecord);
    }

    //---GET THE NUMBER OF LINE IN A FILE---
    private int numberLineInFile(String file) {
        BufferedReader reader;
        int numberLine = 0;
        try {
            reader = new BufferedReader(new FileReader(file));
            String line = reader.readLine();
            while (line != null) {
                numberLine++;
                line = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return numberLine;
    }

    //---GET THE SCORE OF ALL PLAYERS---
    //Return a double array ([0] : nickname and [1] : score).
    private String[][] getAllScores() {
        String[][] scores = new String[numberLineInFile(scoreFile)][2];
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(scoreFile));
            String line = reader.readLine();
            int index = 0;
            while (line != null) {
                String[] fileLine = line.split(";");
                scores[index][0] = fileLine[0];
                scores[index][1] = fileLine[1];
                line = reader.readLine();
                index++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return scores;
    }

    //---GET THE PLAYER'S SCORE---
    private int getScore(String pseudo) {
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

    //---RECORD OF THE PLAYER'S NEW SCORE---
    //If the new score is higher than the recorded score : update the recorded score and return True.
    //If the new score is less than or equivalent to the recorded score : not update the recorded score and return False.
    private boolean setScore(String pseudo, int score) throws IOException {
        //Recovering old scores
        String[][] scores = getAllScores();
        if(isNewScore(pseudo, score, scores)) {
            boolean firstRecord = true;
            //Deleting the old content of the score file
            PrintWriter writer = new PrintWriter(scoreFile);
            writer.print("");
            writer.close();
            //Opening the score file for writing
            FileWriter fw = new FileWriter(scoreFile, true);
            //Browsing the old scores
            for(String[] lineInFile : scores) {
                //If the score belongs to the player of the new record, the old score is changed.
                if(lineInFile[0].equals(pseudo)) {
                    lineInFile[1] = String.valueOf(score);
                    firstRecord = false;
                }
                //Saving the score (old or new) in the score file
                fw.write(lineInFile[0] + ";" + lineInFile[1] + "\n");
            }
            //If the player does not have an old record, add a new line with his score.
            if(firstRecord) {
                fw.write(pseudo + ";" + score + "\n");
            }
            //Closing records file.
            fw.close();
            return true;
        }
        return false;
    }

}
