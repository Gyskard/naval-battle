package game_ressources;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Board_Cells extends JButton{
	private int _posX;
	private int _posY;
	private int _width;
	private int _height;
	private boolean state;
	private boolean isDestroyed;
    private Graphic_Naval_Board myBoard;
    private Boat boat;



	public Board_Cells(int posX, int posY, int width, int height, Graphic_Naval_Board myBoard) {
		super();
		System.out.println(myBoard.getWidth());
		System.out.println(myBoard.getHeight());
		this._posX = posX*(((myBoard.getWidth()-19)/22))+43;
		this._posY = posY*(((myBoard.getHeight()-39)/11))+42;
		this._width = (int)(width*0.9);
		this._height = (int)(height*0.9);
		this.state = false;
		this.isDestroyed = false;
		this.myBoard=myBoard;
		build();
	}
	private void build()
	{
		setBounds(_posX, _posY, _width, _height);
		setOpaque(false);
		setContentAreaFilled(true);
		setBorderPainted(true);
		setEnabled(true);
	}

	public Graphic_Naval_Board getMyBoard() {
		return myBoard;
	}

	public void setMyBoard(Graphic_Naval_Board myBoard) {
		this.myBoard = myBoard;
	}

	public int get_posX() {
		return _posX;
	}

	public void set_posX(int _posX) {
		this._posX = _posX;
	}

	public int get_posY() {
		return _posY;
	}

	public void set_posY(int _posY) {
		this._posY = _posY;
	}

	public int get_width() {
		return _width;
	}

	public void set_width(int _width) {
		this._width = _width;
	}

	public int get_height() {
		return _height;
	}

	public void set_height(int _height) {
		this._height = _height;
	}

	public boolean getState() {return state;}

	public void setState(boolean state) {this.state = state;}

    public Boat getBoat() {return boat;}

    public void setBoat(Boat boat) {this.boat = boat;}

    public void destroy() {
		isDestroyed = true;
		setIcon(new ImageIcon("img/croix_rouge.png"));
		if(boat != null) {
			boat.decreaseHealthPoint();
		}
	}
}
