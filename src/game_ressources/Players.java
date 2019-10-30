package game_ressources;


import java.util.ArrayList;
import java.util.List;

public class Players {
	private int boatAlive;
	private List<Boat> myBoats = new ArrayList<Boat>();
	
	public Players() {
		super();
		//A player has 5 boat at the begining
		this.boatAlive = 5;
		myBoats.add(new Boat(5,"Porte-avion"));
		myBoats.add(new Boat(4,"Croiseur"));
		myBoats.add(new Boat(3,"Contre-Torpilleur"));
		myBoats.add(new Boat(3,"Sous-Marin"));
		myBoats.add(new Boat(2,"Torpilleur"));
		
		
	}

	public List<Boat> getMyBoats() {
		return myBoats;
	}
}
