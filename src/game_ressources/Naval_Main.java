package game_ressources;

import java.io.IOException;

import javax.swing.SwingUtilities;

public class Naval_Main{

	public static void main(String[] args) {
		
		SwingUtilities.invokeLater(() -> {
			Graphical_Naval_Menu Menu;
			try {
				Menu = new Graphical_Naval_Menu();
				Menu.setVisible(true);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		
		



			/*
		// Provisional code to see random boat positioning
		IA_Player ia = new IA_Player(10);
		ia.randomBoatPositioning();
		Graphic_Naval_Board iaBoard = ia.getGameBoard();
		iaBoard.repaint();

		Board_Cells[][] iaCells = iaBoard.getMyCells();

		for (int i = 0; i<10; i++) {
			System.out.println("");
			for (int j = 0; j<10; j++) {
				//System.out.print(i + " " + j + " etat:" + iaCells[i][j].getState() + "    ");
				if (iaCells[i][j].getState())
					System.out.print("1  ");
				else
					System.out.print("0  ");
			}
		}
		*/
	}



}
