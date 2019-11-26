package game_ressources;

import javax.swing.*;

public class Boat extends JLabel{

	private int healthPoint;
	private int size;
	private boolean state;
	private String img_path_vertical;
	private String img_path_horizontal;
	private String img_path_vertical_destroyed;
	private String img_path_horizontal_destroyed;
	private int direction; //0 for horizontal , 1 for vertical
	private int coordXBase;
	private int coordYBase;
    private Players player;

	/**
	 * Objet bateau
	 * @param size taille en nombre de cellules
	 * @param title nom du bateau (jamais utilisé)
	 * @param coordX coordonnées en x
	 * @param coordY coordonnées en y
	 * @param img_path_vertical chemin de l'image du bateau en vertical
	 * @param img_path_horizontal chemin de l'image du bateau en horizontale
	 * @param img_path_vertical_destroyed chemin de l'image du bateau détruit en vertical
	 * @param img_path_horizontal_destroyed chemin de l'image du bateau détruit en horizontal
	 * @param player joueur
	 */
	public Boat(int size, String title, int coordX, int coordY, String img_path_vertical, String img_path_horizontal, String img_path_vertical_destroyed, String img_path_horizontal_destroyed, Players player) {

		super();
		this.healthPoint = size;
		this.size = size;
		this.coordXBase=coordX;
		this.coordYBase=coordY;
		this.img_path_vertical = img_path_vertical;
		this.img_path_horizontal = img_path_horizontal;
		this.img_path_vertical_destroyed = img_path_vertical_destroyed;
		this.img_path_horizontal_destroyed = img_path_horizontal_destroyed;
		this.state=true;
        this.player= player;

	}

	/**
	 * retourne coordonnées de base en X
	 * @return int
	 */
	int getCoordXBase() {
		return coordXBase;
	}

	/**
	 * définit coordonnées de base en X
	 * @param coordXBase coordonnées de base en X
	 */
	void setCoordXBase(int coordXBase) {
		this.coordXBase = coordXBase;
	}

	/**
	 * retourne coordonnées de base en Y
	 * @return int
	 */
	int getCoordYBase() {
		return coordYBase;
	}

	/**
	 * définit coordonnées de base en Y
	 * @param coordYBase coordonnées de base en Y
	 */
	void setCoordYBase(int coordYBase) {
		this.coordYBase = coordYBase;
	}

	/**
	 * Renvoi la direction du bateau
	 * @return direction
	 */
	int getDirection() {
		return direction;
	}

	/**
	 * Défini la direction du bateau
	 * 0 pour horizontale
	 * 1 pour verticale
	 * @param direction int
	 */
	void setDirection(int direction) {
		this.direction = direction;
	}

	/**
	 * Retourne le nombre de points de vie du bateau
	 * @return int
	 */
	int getHealthPoint() {
		return healthPoint;
	}

	/**
	 * Dimini le nombre de points de vie d'un bateau
	 */
	void decreaseHealthPoint() {

		this.healthPoint --;

		if (healthPoint == 0) {

			setState();
			player.decreaseBoatAlive();

			if(player instanceof Human_Player) {

				player.getGameBoard().IADisplayImage(coordXBase,coordYBase,this);

			}
			this.setVisible(true);
			this.setEnabled(true);
		}
	}

	/**
	 * Retourne la taille d'un bateau
	 * @return int
	 */
	int getBoatSize() {
		return size;
	}

	/**
	 * Définit l'état d'un bateau
	 */
	private void setState() {
		this.state = false;
	}

	/**
	 * Retourne le chemin de l'image du bateau en verticale
	 * @return String
	 */
	String getImg_path_vertical() {
		return img_path_vertical;
	}


	/**
	 * Retourne le chemin de l'image du bateau en horizontale
	 * @return String
	 */
	String getImg_path_horizontal() {
		return img_path_horizontal;
	}

	/**
	 * Retourne le chemin de l'image du bateau détruit en verticale
	 * @return String
	 */
	String getImg_path_vertical_destroyed() {
		return img_path_vertical_destroyed;
	}

	/**
	 * Retourne le chemin de l'image du bateau détruit en horizontale
	 * @return String
	 */
	String getImg_path_horizontal_destroyed() {
		return img_path_horizontal_destroyed;
	}

}