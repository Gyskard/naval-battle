package game_ressources;


import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.SwingUtilities;

public class Players {
	protected int boatAlive;
	protected List<Boat> myBoats = new ArrayList<Boat>();
	protected Graphic_Naval_Board GameBoard;
	protected Players adversary;
	
	public Players(int size) {
		super();
		System.out.println("new player");
		//A player has 5 boat at the begining
		this.boatAlive = 5;
		myBoats.add(new Boat(5,"Porte-avion","./img/Vertical_PorteAvion.png", "./img/Horizontal_PorteAvion.png", "./img/Vertical_Explosion_PorteAvion.png", "./img/Horizontal_Explosion_PorteAvion.png"));
		myBoats.add(new Boat(4,"Croiseur","./img/Vertical_Croiseur.png", "./img/Horizontal_Croiseur.png", "./img/Vertical_Explosion_Croiseur.png", "./img/Horizontal_Explosion_Croiseur.png"));
		myBoats.add(new Boat(3,"Contre-Torpilleur","./img/Vertical_ContreTorpilleur.png", "./img/Horizontal_ContreTorpilleur.png", "./img/Vertical_Explosion_ContreTorpilleur.png", "./img/Horizontal_Explosion_ContreTorpilleur.png"));
		myBoats.add(new Boat(3,"Sous-Marin","./img/Vertical_SousMarin.png", "./img/Horizontal_SousMarin.png", "./img/Vertical_Explosion_SousMarin.png", "./img/Horizontal_Explosion_SousMarin.png"));
		myBoats.add(new Boat(2,"Destroyer","./img/Vertical_Destroyer.png", "./img/Horizontal_Destroyer.png", "./img/Vertical_Explosion_Destroyer.png", "./img/Horizontal_Explosion_Destroyer.png"));
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int width = 957;
		int height = 468;
		Players me = this;
		/* test */
		GameBoard = new Graphic_Naval_Board(size,width,height,me);
		
		SwingUtilities.invokeLater(new Runnable(){ 
			public void run() {
				Graphic_Naval_Board Menu;
				//GameBoard = new Graphic_Naval_Board(size,width,height,me);
				GameBoard.setVisible(true);
			}
		} );
		
	}
	public void setAdversary(Players adv)
	{
		this.adversary=adv;
	}

	public List<Boat> getMyBoats() { return myBoats; }
	public Graphic_Naval_Board getGameBoard() { return GameBoard; }
	
	public void displayGameBoard() {
		GameBoard.setVisible(true);
	}

	public void destroyBoat(Boat boat) {
		myBoats.remove(boat);
	}

}
