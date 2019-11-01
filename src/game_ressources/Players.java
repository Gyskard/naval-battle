package game_ressources;


import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.Iterator;
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

	public List<Boat> getMyBoats() { return myBoats; }
	public Graphic_Naval_Board getGameBoard() { return GameBoard; }



	public void randomBoatPositioning() {
		Iterator<Boat> iter = myBoats.iterator();
		int size = GameBoard.getIntSize(), boatSize, rndNumber1, rndNumber2, rndDirection, direction1, direction2;;
		Board_Cells myCells[][] = GameBoard.getMyCells();
		boolean spaceAvailable, outOfBoard;
		Boat boat;

		while (iter.hasNext()) {
			boat = iter.next();
			boatSize = boat.getSize();

			spaceAvailable = false;
			while(spaceAvailable == false){
				do{
					// rndNumber = [0; size]
					rndNumber1 = (int) (Math.random() * (size));
					rndNumber2 = (int) (Math.random() * (size));
					// rndDirection = [0; 3]
					rndDirection = (int) (Math.random() * 4);
					switch (rndDirection){
						case 0:
							direction1 = 1;
							direction2 = 0;
							break;
						case 1:
							direction1 = -1;
							direction2 = 0;
							break;
						case 2:
							direction1 = 0;
							direction2 = 1;
							break;
						case 3:
							direction1 = 0;
							direction2 = -1;
							break;
						default:
							direction1 = 1;
							direction2 = 0;
							break;
					}


					outOfBoard = false;
					if((rndNumber1 + boatSize*direction1 > size) || (rndNumber1 + boatSize*direction1 < 0)
							|| (rndNumber2 + boatSize*direction2 > size) || (rndNumber2 + boatSize*direction2 < 0)){
						outOfBoard = true;
					}

				} while(outOfBoard == true);



				spaceAvailable = true;
				for(int i=0; i<boatSize; i++){
					if((myCells[rndNumber1 + i*direction1][rndNumber2 + i*direction2].getState()) == true)
					{
						spaceAvailable = false;
						break;
					}
				}

				if(spaceAvailable == true){
					for(int i=0; i<boat.getSize(); i++){
						myCells[rndNumber1 + i*direction1][rndNumber2 + i*direction2].setState(true);
					}
				}
			}
		}
	}
}
