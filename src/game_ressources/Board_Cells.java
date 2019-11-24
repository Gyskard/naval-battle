package game_ressources;

import javax.swing.*;

public class Board_Cells extends JButton {

	private int _posX;
	private int _posY;
	private int i,j;
	private int _width;
	private int _height;
	private boolean state;
	private boolean isDestroyed;
    private Graphic_Naval_Board myBoard;
    private Boat boat;

	public Board_Cells(int posX, int posY, int width, int height, Graphic_Naval_Board myBoard) {

		super();
		this._posX = posX*(((myBoard.getWidth()-19)/22))+43;
		this._posY = posY*(((myBoard.getHeight()-39)/11))+42;
		this._width = (int)(width*0.9);
		this._height = (int)(height*0.9);
		this.state = false;
		this.isDestroyed = false;
		this.myBoard=myBoard;
		this.i = posX;
		this.j = posY;
		build();
	}

	int getI() {
		return i;
	}

	int getJ() {
		return j;
	}

	private void build() {

		setBounds(_posX, _posY, _width, _height);
		setOpaque(false);
		setContentAreaFilled(false);
		setBorderPainted(false);
		setEnabled(true);

	}

	Graphic_Naval_Board getMyBoard() {
		return myBoard;
	}

	int get_posX() {
		return _posX;
	}


	int get_posY() {
		return _posY;
	}


	int get_width() {
		return _width;
	}

	int get_height() {
		return _height;
	}

	boolean getState() {
		return state;
	}

	void setState() {
		this.state = true;
	}

    Boat getBoat() {
		return boat;
	}

    void setBoat(Boat boat) {
		this.boat = boat;
	}

    void destroy() {

		if(!isDestroyed) {

			isDestroyed = true;
			if(boat == null) {

				setIcon(new ImageIcon("img/Blue_Cross.png"));

				if(myBoard.getMyPlayer() instanceof Human_Player) {

					Human_Player HP = (Human_Player)myBoard.getMyPlayer();
					HP.inscreaseN_OfMiss();

				}
			}

			else {

				boat.decreaseHealthPoint();
				setIcon(new ImageIcon("img/Red_Cross.png"));

			}
		}
	}
}