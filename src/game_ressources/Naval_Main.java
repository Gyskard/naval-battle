package game_ressources;

import java.awt.Color;

public class Naval_Main {

	public static void main(String[] args) {
		
		//Generate a 1000 x 1000 sized frame with 10 x 10 case in it
	   Graphic_Naval_Board m = new Graphic_Naval_Board(10,1000,1000);
	   
	   //repain call the function paint by default but it's more usable than paint
	   m.repaint(); 
	}
	


}
