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
	
	int getCoordXBase() {
		return coordXBase;
	}

	void setCoordXBase(int coordXBase) {
		this.coordXBase = coordXBase;
	}

	int getCoordYBase() {
		return coordYBase;
	}

	void setCoordYBase(int coordYBase) {
		this.coordYBase = coordYBase;
	}

	int getDirection() {
		return direction;
	}

	void setDirection(int direction) {
		this.direction = direction;
	}

	int getHealthPoint() {
		return healthPoint;
	}

	void decreaseHealthPoint() {

		this.healthPoint --;

		if (healthPoint == 0) {

			setState();
			player.decreaseBoatAlive();

			if(player instanceof IA_Player) {

				this.setVisible(true);
				this.setEnabled(true);

			}

			else {

				player.getGameBoard().IADisplayImage(coordXBase,coordYBase,this);
				this.setVisible(true);
				this.setEnabled(true);

			}
		}
	}

	int getBoatSize() {
		return size;
	}

	private void setState() {
		this.state = false;
	}

	String getImg_path_vertical() {
		return img_path_vertical;
	}


	String getImg_path_horizontal() {
		return img_path_horizontal;
	}

	String getImg_path_vertical_destroyed() {
		return img_path_vertical_destroyed;
	}

	String getImg_path_horizontal_destroyed() {
		return img_path_horizontal_destroyed;
	}

}