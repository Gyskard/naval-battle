package game_ressources;

import java.io.IOException;

public class Human_Player extends Players {

	private String pseudo = "Anonyme";

	public Human_Player(String pseudo) throws IOException {

		super();
		this.pseudo = pseudo;

	}

	private int numberOfMiss; //For the final score

	int getNumberOfMiss() {
		return numberOfMiss;
	}

	void inscreaseN_OfMiss() {
		numberOfMiss++;
	}

	String getPseudo() {
		return pseudo;
	}
}