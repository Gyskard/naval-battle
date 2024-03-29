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

	/**
	 * Cellules de la grille
	 * @param posX position en x
	 * @param posY position en y
	 * @param width largeur
	 * @param height hauteur
	 * @param myBoard grille
	 */
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

	/**
	 * Retourne la position verticale
	 * @return int
	 */
	int getI() {
		return i;
	}

	/**
	 * Retourne la position horizontale
	 * @return int
	 */
	int getJ() {
		return j;
	}

	/**
	 * Build des cellules et le rend invisible
	 */
	private void build() {

		setBounds(_posX, _posY, _width, _height);
		setOpaque(false);
		setContentAreaFilled(false);
		setBorderPainted(false);
		setEnabled(true);

	}

	/**
	 * Retourne la grille
	 * @return board
	 */

	Graphic_Naval_Board getMyBoard() {
		return myBoard;
	}

	/**
	 * Retourne la position en x
	 * @return int
	 */
	int get_posX() {
		return _posX;
	}

	/**
	 * Retourne la position en y
	 * @return int
	 */
	int get_posY() {
		return _posY;
	}


	/**
	 * Retourne la largeur
	 * @return int
	 */
	int get_width() {
		return _width;
	}

	/**
	 * Retourne la hauteur
	 * @return int
	 */
	int get_height() {
		return _height;
	}

	/**
	 * Retourne l'état
	 * @return boolean
	 */
	boolean getState() {
		return state;
	}

	/**
	 * Définit l'état
	 */
	void setState() {
		this.state = true;
	}

	/**
	 * Retourne le bateau présent sur la cellule
	 * @return boat
	 */
    Boat getBoat() {
		return boat;
	}

	/**
	 * Définit le bateau présent sur la cellule
	 */
    void setBoat(Boat boat) {
		this.boat = boat;
	}

	/**
	 * Détruit une cellule, et donc un bateau si présence
	 */
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