package game_ressources;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class IA_Player extends Players {

	public IA_Player(Players adversary) {
		super();

        Graphic_Naval_Board adversaryBoard = adversary.getGameBoard();

	}

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

	void tryToDestroy(Graphic_Naval_Board board, List<Integer> xTested, List<Integer> yTested)  {

        int x = 0;
        int y = 0;

        boolean newCaseTest = false;
        while(!(newCaseTest)) {
            x = ThreadLocalRandom.current().nextInt(0, 9 + 1);
            y = ThreadLocalRandom.current().nextInt(0, 9 + 1);
            if(!(coordsHasBeenTested(xTested, yTested, x, y))) {
                newCaseTest = true;
            }
            xTested.add(x);
            yTested.add(y);
        }

        board.getMyCell(x,y).destroy();
    }

}