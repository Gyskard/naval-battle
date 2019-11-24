package game_ressources;

import java.io.IOException;

public class Human_Player extends Players {

	private String pseudo = "Anonyme";

	public Human_Player(String pseudo) throws IOException {
		super();
		this.pseudo = pseudo;
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

	public void inscreaseN_OfMiss()
	{
		numberOfMiss++;
	}

	public String getPseudo() {
		return pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}
}
