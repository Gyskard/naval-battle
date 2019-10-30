package game_ressources;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

public class Naval_Main {

	public static void main(String[] args) {
		
		//Get the size of the screen and make it scale
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int width = (int)(screenSize.getWidth()*0.3);
		int height = (int)(screenSize.getHeight()*0.45);
		
		
		Graphical_Naval_Menu Menu = new Graphical_Naval_Menu(width, height);
		Menu.repaint();
		//Generate a 1000 x 1000 sized frame with 10 x 10 case in it
		Human_Player ThePlayer = new  Human_Player(10);
		ThePlayer.GameBoard.repaint();
	   //repain call the function paint by default but it's more usable than paint
	}
	


}
