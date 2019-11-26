package game_ressources;

import java.io.IOException;

/**
 * Classe du joueur
 */
public class Human_Player extends Players {

	private String pseudo = "Anonyme";

	/**
	 * Constructeur
	 * @param pseudo pseudo du joueur
	 * @throws IOException exception
	 */
	public Human_Player(String pseudo) throws IOException {

		super();
		this.pseudo = pseudo;

	}

	private int numberOfMiss; //For the final score

	/**
	 * Retourne le nombre de fois où un bateau a été touché
	 * @return int
	 */
	int getNumberOfMiss() {
		return numberOfMiss;
	}

	/**
	 * Augmente le nombre de fois où un bateau a été touché
	 */
	void inscreaseN_OfMiss() {
		numberOfMiss++;
	}

	/**
	 * Retourne le pseudo du joueur
	 * @return String
	 */
	String getPseudo() {
		return pseudo;
	}
}