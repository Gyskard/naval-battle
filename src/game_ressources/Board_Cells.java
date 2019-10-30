package game_ressources;

import java.awt.Graphics;
import java.awt.Rectangle;



public class Board_Cells extends Rectangle{
	private int _posX;
	private int _posY;
	private int _width;
	private int _height;
	private boolean state;
	



	public Board_Cells(int posX, int posY, int width, int height) {
		super();
		this._posX = posX;
		this._posY = posY;
		this._width = width;
		this._height = height;
		this.state = true;
	}


    public void paint(Graphics g)
	{
        g.drawRect(_posX,_posY,_width,_height);
	}

	public boolean getState() {return state;}
	public void setState(boolean state) {this.state = state;}
	
}
