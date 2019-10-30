package game_ressources;


import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.List;

public class Players {
	protected int boatAlive;
	protected List<Boat> myBoats = new ArrayList<Boat>();
	protected Graphic_Naval_Board GameBoard;
	
	public Players(int size) {
		super();
		//A player has 5 boat at the begining
		this.boatAlive = 5;
		myBoats.add(new Boat(5,"Porte-avion"));
		myBoats.add(new Boat(4,"Croiseur"));
		myBoats.add(new Boat(3,"Contre-Torpilleur"));
		myBoats.add(new Boat(3,"Sous-Marin"));
		myBoats.add(new Boat(2,"Torpilleur"));
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int width = (int)(screenSize.getWidth()*0.6);
		int height = (int)(screenSize.getHeight()*0.9);
		GameBoard = new Graphic_Naval_Board(size,width,height);
		
		
	}

	public List<Boat> getMyBoats() {
		return myBoats;
	}
}
