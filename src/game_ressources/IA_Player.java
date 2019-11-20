package game_ressources;

import java.util.Arrays;

public class IA_Player extends Players {

	public IA_Player(int size , Players adversary) {
		super(size);

		/* For test */
		/*

		Graphic_Naval_Board adversaryBoard = new Graphic_Naval_Board(10, 957, 468, adversary);
		adversaryBoard.randomBoatPositioning();

		displayCells(adversaryBoard);
		*/
		/* Final code (pointer error) */

		Graphic_Naval_Board adversaryBoard = adversary.getGameBoard();
		Board_Cells[][] board_cells = adversaryBoard.getMyCells();

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