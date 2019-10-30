package game_ressources;

public class Human_Player extends Players {
	public Human_Player(int size) {
		super(size);
		// TODO Auto-generated constructor stub
	}

	//For the final score
	private int numberOfMiss;

	public int getNumberOfMiss() {
		return numberOfMiss;
	}

	public void setNumberOfMiss(int numberOfMiss) {
		this.numberOfMiss = numberOfMiss;
	}
	
}
