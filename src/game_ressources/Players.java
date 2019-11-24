package game_ressources;

import java.util.ArrayList;
import java.util.List;

public class Players {

	private int boatAlive;
	private List<Boat> myBoats = new ArrayList<>();
	private Graphic_Naval_Board GameBoard;
	Players adversary;
	
	public Players() {

		super();
		this.boatAlive = 5;	//A player has 5 boat at the begining
		myBoats.add(new Boat(5,"Porte-avion",600,20,"./img/Vertical_PorteAvion.png", "./img/Horizontal_PorteAvion.png", "./img/Vertical_Explosion_PorteAvion.png", "./img/Horizontal_Explosion_PorteAvion.png", this));
		myBoats.add(new Boat(4,"Croiseur",600,70,"./img/Vertical_Croiseur.png", "./img/Horizontal_Croiseur.png", "./img/Vertical_Explosion_Croiseur.png", "./img/Horizontal_Explosion_Croiseur.png", this));
		myBoats.add(new Boat(3,"Contre-Torpilleur",600,120,"./img/Vertical_ContreTorpilleur.png", "./img/Horizontal_ContreTorpilleur.png", "./img/Vertical_Explosion_ContreTorpilleur.png", "./img/Horizontal_Explosion_ContreTorpilleur.png", this));
		myBoats.add(new Boat(3,"Sous-Marin",600,170,"./img/Vertical_SousMarin.png", "./img/Horizontal_SousMarin.png", "./img/Vertical_Explosion_SousMarin.png", "./img/Horizontal_Explosion_SousMarin.png", this));
		myBoats.add(new Boat(2,"Destroyer",600,220,"./img/Vertical_Destroyer.png", "./img/Horizontal_Destroyer.png", "./img/Vertical_Explosion_Destroyer.png", "./img/Horizontal_Explosion_Destroyer.png", this));
		int width = 957;
		int height = 468;
		Players me = this;
		GameBoard = new Graphic_Naval_Board(width,height,me);

	}

	void setAdversary(Players adv) {

		this.adversary=adv;
		adv.adversary=this;

	}

	List<Boat> getMyBoats() {
		return myBoats;
	}

	Graphic_Naval_Board getGameBoard() {
		return GameBoard;
	}

	void decreaseBoatAlive() {
		boatAlive -= 1;
	}
}
