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
	
	public Players() throws IOException {
		super();
		//A player has 5 boat at the begining
		this.boatAlive = 5;
		myBoats.add(new Boat(5,"Porte-avion",600,20,"./img/Vertical_PorteAvion.png", "./img/Horizontal_PorteAvion.png", "./img/Vertical_Explosion_PorteAvion.png", "./img/Horizontal_Explosion_PorteAvion.png", this));
		myBoats.add(new Boat(4,"Croiseur",600,70,"./img/Vertical_Croiseur.png", "./img/Horizontal_Croiseur.png", "./img/Vertical_Explosion_Croiseur.png", "./img/Horizontal_Explosion_Croiseur.png", this));
		myBoats.add(new Boat(3,"Contre-Torpilleur",600,120,"./img/Vertical_ContreTorpilleur.png", "./img/Horizontal_ContreTorpilleur.png", "./img/Vertical_Explosion_ContreTorpilleur.png", "./img/Horizontal_Explosion_ContreTorpilleur.png", this));
		myBoats.add(new Boat(3,"Sous-Marin",600,170,"./img/Vertical_SousMarin.png", "./img/Horizontal_SousMarin.png", "./img/Vertical_Explosion_SousMarin.png", "./img/Horizontal_Explosion_SousMarin.png", this));
		myBoats.add(new Boat(2,"Destroyer",600,220,"./img/Vertical_Destroyer.png", "./img/Horizontal_Destroyer.png", "./img/Vertical_Explosion_Destroyer.png", "./img/Horizontal_Explosion_Destroyer.png", this));
		
		int width = 957;
		int height = 468;
		Players me = this;
		/* test */
		GameBoard = new Graphic_Naval_Board(width,height,me);

		
	}
	public void setAdversary(Players adv)
	{

		this.adversary=adv;
		adv.adversary=this;
	}

	public List<Boat> getMyBoats() { return myBoats; }
	public Graphic_Naval_Board getGameBoard() { return GameBoard; }
	

	public void decreaseBoatAlive() { boatAlive -= 1; }

}
