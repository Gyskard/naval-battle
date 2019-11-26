package game_ressources;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


/**
 * Gestion du score des joueurs
 */
public class Score {

    private String scoreFile = "score.txt";

    //---INDICATES IF THE PLAYER'S SCORE IS GREATER THAN HIS PREVIOUS SCORE--
    //If the new score is higher than the recorded score or if he doesn't have an old score: return True.
    //If the new score is less than or equivalent to the recorded score : return False.

    /**
     * Inidique si le nouveau score est supérieur au score précédent
     * @param pseudo Pseudo
     * @param scorePseudo Nouveau score
     * @param scores Anciens scores
     * @return boolean
     */
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

    /**
     * Renvoi le nombre de ligne du fichier des scores
     * @param file Chemin du fichier
     * @return int
     */
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

    /**
     * Retourne tous les scores enregistrés
     * @return ableau 2D de string
     */
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

    /**
     * Renvoi le score pour un joueur
     * @param pseudo pseudo
     * @return int
     */
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

    /**
     * Renvoi le pseudo et le score du top X
     * @param top le numéro du top recherché
     * @return tableau 2D de String
     */
    public String[][] getTopScore(int top) {
        String[][] topScore;
        String[][] scores = getAllScores();
        List<String> pseudoTraited =  new ArrayList<String>();
        if(scores.length < top) {
            top = scores.length;
        }
        topScore = new String[top][2];
        for(int i = 0; i < top; i++) {
            int scoreMax = 0;
            String pseudo = "";
            for(String[] lineInFile : scores) {
                if (scoreMax < Integer.parseInt(lineInFile[1]) && !(pseudoTraited.contains(lineInFile[0]))) {
                    scoreMax = Integer.parseInt(lineInFile[1]);
                    pseudo = lineInFile[0];
                }
            }
            topScore[i][0] = pseudo;
            topScore[i][1] = String.valueOf(scoreMax);
            pseudoTraited.add(pseudo);
        }
        return topScore;
    }

    //---RECORD OF THE PLAYER'S NEW SCORE---
    //If the new score is higher than the recorded score : update the recorded score and return True.
    //If the new score is less than or equivalent to the recorded score : not update the recorded score and return False.

    /**
     * Définit le nouveau score
     * @param pseudo String
     * @param score int
     * @return boolean
     * @throws IOException exception pour l'écriture dans un fichier
     */
    public boolean setScore(String pseudo, int score) throws IOException {
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
