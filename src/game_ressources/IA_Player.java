package game_ressources;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Classe de l'IA
 */
public class IA_Player extends Players {

    private boolean destruction = false;
    private int destructionX = 0;
    private int destructionY = 0;
    private int OriginalDestructionX = 0;
    private int OriginalDestructionY = 0;
    private String newDirection = "";
    private boolean leftTest = false;
    private boolean rightTest = false;
    private boolean topTest = false;
    private boolean bottomTest = false;

    /**
     * Constructeur
     * @throws IOException exception
     */
	public IA_Player() throws IOException {

		super();

	}

    /**
     * Retourne vrai si la cellule a été déjà été touché par l'IA
     * @param xTested coordonnées déjà testées en x
     * @param yTested coordonnées déjà testées y
     * @param x nouvelle coordonné en x
     * @param y nouvelle cordonnée en y
     * @return boolean
     */
	private boolean coordsHasBeenTested(List<Integer> xTested, List<Integer> yTested, int x, int y) {

	    if(xTested.size() == 0 || yTested.size() == 0) {
	        return false;
        }

	    else {

            int i;
	        for(i = 0; i < xTested.size(); i++) {
	            if(xTested.get(i) == x && yTested.get(i) == y) {
	                return true;
                }
            }
        }

	    return false;

    }

    /**
     * Cherche et attaque une nouvelle cellule pour tenter de couler un bateau
     * @param board grille
     * @param xTested coordonnées déjà testées en x
     * @param yTested coordonnées déjà testées en y
     * @deprecated méthode non terminée, amélioration et optimisation nécessaire
     */
	void tryToDestroy(Graphic_Naval_Board board, List<Integer> xTested, List<Integer> yTested)  {

        int x = 0;
        int y = 0;
        boolean attacked = false;

        if(!destruction && newDirection.equals("")) {

            leftTest = false;
            rightTest = false;
            topTest = false;
            bottomTest = false;

            boolean newCaseTest = false;

            while(!(newCaseTest)) {

                x = ThreadLocalRandom.current().nextInt(0, 10);
                y = ThreadLocalRandom.current().nextInt(0, 10);
                if(!(coordsHasBeenTested(xTested, yTested, x, y))) {
                    newCaseTest = true;
                }
                xTested.add(x);
                yTested.add(y);

            }

            board.getMyCell(x,y).destroy();
            attacked = true;

            if(adversary.getGameBoard().getMyCell(x, y).getBoat() != null) {

                destructionX = x;
                destructionY = y;
                destruction = true;
                OriginalDestructionX = destructionX;
                OriginalDestructionY = destructionY;

            }
        }

        else if(newDirection.equals("")) {

            if((destructionX - 1) >= 0 && !(coordsHasBeenTested(xTested, yTested, destructionX - 1, destructionY))) {

                board.getMyCell(destructionX - 1, destructionY).destroy();
                attacked = true;
                xTested.add(destructionX - 1);
                yTested.add(destructionY);

                if(adversary.getGameBoard().getMyCell(destructionX - 1, destructionY).getBoat() != null) {

                    newDirection = "left";
                    destruction = true;
                    destructionX--;

                }
            }

            else if((destructionX + 1) <= 9 && !(coordsHasBeenTested(xTested, yTested, destructionX + 1, destructionY))) {

                board.getMyCell(destructionX + 1, destructionY).destroy();
                attacked = true;
                xTested.add(destructionX + 1);
                yTested.add(destructionY);
                if(adversary.getGameBoard().getMyCell(destructionX + 1, destructionY).getBoat() != null) {

                    newDirection = "right";
                    destruction = true;
                    destructionX++;

                }
            }

            else if((destructionY - 1) >= 0 && !(coordsHasBeenTested(xTested, yTested, destructionX, destructionY - 1))) {

                board.getMyCell(destructionX, destructionY - 1).destroy();
                attacked = true;
                xTested.add(destructionX);
                yTested.add(destructionY - 1);

                if(adversary.getGameBoard().getMyCell(destructionX, destructionY - 1).getBoat() != null) {

                    newDirection = "bottom";
                    destruction = true;
                    destructionY--;

                }
            }

            else if((destructionY + 1) <= 9 && !(coordsHasBeenTested(xTested, yTested, destructionX, destructionY + 1))) {

                board.getMyCell(destructionX, destructionY + 1).destroy();
                attacked = true;
                xTested.add(destructionX);
                yTested.add(destructionY + 1);

                if(adversary.getGameBoard().getMyCell(destructionX, destructionY + 1).getBoat() != null) {

                    newDirection = "up";
                    destruction = true;
                    destructionY++;

                }
            }
        }

        else {

            switch (newDirection) {

                case "left":

                    if((destructionX - 1) >= 0 && !(coordsHasBeenTested(xTested, yTested, destructionX - 1, destructionY)) && !leftTest) {

                        board.getMyCell(destructionX - 1, destructionY).destroy();
                        attacked = true;
                        xTested.add(destructionX - 1);
                        yTested.add(destructionY);

                        if(adversary.getGameBoard().getMyCell(destructionX - 1, destructionY).getBoat() == null) {

                            if(!rightTest) {

                                newDirection = "right";
                                destructionX = OriginalDestructionX;
                                destructionY = OriginalDestructionY;

                            }
                            else {

                                newDirection = "";

                            }

                            leftTest = true;

                        }

                        destructionX--;
                    }
                    else {

                        newDirection = "";
                        destruction = false;

                        if(destructionX - 1 >= 0 && !(coordsHasBeenTested(xTested, yTested, destructionX - 1, destructionY))) {

                            board.getMyCell(destructionX - 1, destructionY).destroy();
                            attacked = true;
                            xTested.add(destructionX - 1);
                            yTested.add(destructionY);

                        }
                    }
                    break;

                case "right":

                    if((destructionX + 1) <= 9 && !(coordsHasBeenTested(xTested, yTested, destructionX + 1, destructionY)) && !rightTest) {

                        board.getMyCell(destructionX + 1, destructionY).destroy();
                        attacked = true;
                        xTested.add(destructionX + 1);
                        yTested.add(destructionY);

                        if(adversary.getGameBoard().getMyCell(destructionX + 1, destructionY).getBoat() == null) {

                            if(!leftTest) {

                                newDirection = "left";
                                destructionX = OriginalDestructionX;
                                destructionY = OriginalDestructionY;

                            }

                            else {

                                newDirection = "";

                            }

                            leftTest = true;

                        }

                        destructionX++;

                    }

                    else {

                        newDirection = "";
                        destruction = false;

                        if(destructionX + 1 <= 9 && !(coordsHasBeenTested(xTested, yTested, destructionX + 1, destructionY))) {

                            board.getMyCell(destructionX + 1, destructionY).destroy();
                            attacked = true;
                            xTested.add(destructionX + 1);
                            yTested.add(destructionY);

                        }
                    }
                    break;

                case "bottom":

                    if((destructionY - 1) >= 0 && !(coordsHasBeenTested(xTested, yTested, destructionX, destructionY - 1)) && !bottomTest) {

                        board.getMyCell(destructionX, destructionY - 1).destroy();
                        attacked = true;
                        xTested.add(destructionX);
                        yTested.add(destructionY - 1);

                        if(adversary.getGameBoard().getMyCell(destructionX, destructionY - 1).getBoat() == null) {

                            if(!topTest) {

                                newDirection = "up";
                                destructionX = OriginalDestructionX;
                                destructionY = OriginalDestructionY;

                            }

                            else {
                                newDirection = "";
                            }

                            bottomTest = true;

                        }

                        destructionY--;

                    }

                    else {

                        newDirection = "";
                        destruction = false;

                        if(destructionY - 1 >= 0 && !(coordsHasBeenTested(xTested, yTested, destructionX, destructionY - 1))) {

                            board.getMyCell(destructionX, destructionY - 1).destroy();
                            attacked = true;
                            xTested.add(destructionX);
                            yTested.add(destructionY - 1);

                        }
                    }

                    break;

                case "up": {

                    if((destructionY + 1) <= 9 && !(coordsHasBeenTested(xTested, yTested, destructionX, destructionY + 1)) && !topTest) {

                        board.getMyCell(destructionX, destructionY + 1).destroy();
                        attacked = true;
                        xTested.add(destructionX);
                        yTested.add(destructionY + 1);

                        if(adversary.getGameBoard().getMyCell(destructionX, destructionY + 1).getBoat() == null) {

                            if(!bottomTest) {

                                newDirection = "bottom";
                                destructionX = OriginalDestructionX;
                                destructionY = OriginalDestructionY;
                            }

                            else {

                                newDirection = "";

                            }

                            topTest = true;

                        }

                        destructionY++;

                    }

                    else {

                        newDirection = "";
                        destruction = false;

                        if((destructionY + 1) <= 9 && !(coordsHasBeenTested(xTested, yTested, destructionX, destructionY + 1))) {

                            board.getMyCell(destructionX, destructionY + 1).destroy();
                            attacked = true;
                            xTested.add(destructionX);
                            yTested.add(destructionY + 1);

                        }
                    }
                }
            }
        }

        if(!attacked) {

            boolean newCaseTest2 = false;

            while(!(newCaseTest2)) {

                x = ThreadLocalRandom.current().nextInt(0, 10);
                y = ThreadLocalRandom.current().nextInt(0, 10);

                if(!(coordsHasBeenTested(xTested, yTested, x, y))) {

                    newCaseTest2 = true;

                }

                xTested.add(x);
                yTested.add(y);

            }

            board.getMyCell(x,y).destroy();

        }
    }
}