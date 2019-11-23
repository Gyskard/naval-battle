package game_ressources;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class IA_Player extends Players {

	public IA_Player(int size , Players adversary) {
		super(size);
		/*

		Graphic_Naval_Board adversaryBoard = adversary.getGameBoard();

        adversaryBoard.randomBoatPositioning();
        displayCells(adversaryBoard);

        List<Integer> xTested = new ArrayList<Integer>();
        List<Integer> yTested = new ArrayList<Integer>();

        tryToDestroy(adversaryBoard, xTested, yTested);
        displayCells(adversaryBoard);

        */
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

	private void tryToDestroy(Graphic_Naval_Board board, List<Integer> xTested, List<Integer> yTested) {

        int x = 0;
        int y = 0;

        boolean boatInCase = false;
        while(!(boatInCase)) {
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

            if(boatInCase(board, x, y)) {
                boatInCase = true;
            }
        }

        System.out.println("\n\n===========================");
        System.out.println(x);
        System.out.println(y);

        Board_Cells[][] board_cells = board.getMyCells();
        board_cells[x][y].destroy();
    }

    private boolean boatInCase(Graphic_Naval_Board board, int x, int y) {
        Board_Cells[][] board_cells = board.getMyCells();
        return board_cells[x][y].getState();
    }

	private void displayCells(Graphic_Naval_Board board) {
		Board_Cells[][] board_cells = board.getMyCells();
		int i, j;
		for (i = 0; i < 10; i++) {
			System.out.println("");
			for (j = 0; j < 10; j++) {
				if (board_cells[i][j].getState()) {
					System.out.print("1  ");
				}
				else {
					System.out.print("0  ");
				}
			}
		}
	}

}