package game_ressources;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class Board_Cells extends JButton{
	private int _posX;
	private int _posY;
	private int _width;
	private int _height;
	private boolean state;
    private Graphic_Naval_Board myBoard;



	public Board_Cells(int posX, int posY, int width, int height,Graphic_Naval_Board myBoard) {
		super();
		this._posX = posX;
		this._posY = posY;
		this._width = width;
		this._height = height;
		this.state = false;
		this.myBoard=myBoard;
		build();
	}
	private void build()
	{
		setBounds(_posX, _posY, _width, _height);
		setBackground(Color.BLACK);
		setVisible(false);
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

	
}
