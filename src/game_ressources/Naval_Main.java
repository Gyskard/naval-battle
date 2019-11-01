package game_ressources;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.IOException;

public class Naval_Main {

	public static void main(String[] args) throws IOException {
		
		//Get the size of the screen and make it scale
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int width = (int)(screenSize.getWidth()*0.3);
		int height = (int)(screenSize.getHeight()*0.45);
		
		
		Graphical_Naval_Menu Menu = new Graphical_Naval_Menu();
		Menu.setVisible(true);
		Menu.repaint();
		//Generate a 1000 x 1000 sized frame with 10 x 10 case in it
		Human_Player ThePlayer = new  Human_Player(10);
		ThePlayer.GameBoard.repaint();
	   //repain call the function paint by default but it's more usable than paint



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
	}


}
