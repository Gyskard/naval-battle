package game_ressources;

import javax.swing.*;
import java.awt.*;

import javax.swing.JPanel;

public class Graphic_Naval_Board extends JFrame {


	 private int size; 
	 private int width; 
	 private int height; 
	 private Board_Cells myCells[][];

	  
	     public Graphic_Naval_Board(int size, int width, int height) throws HeadlessException {
			super();
			
			//Initiate 
			this.size = size;
			this.width = width;
			this.height = height;
			myCells = new Board_Cells[size][size];
	        setSize(width, height);
	        setTitle("Naval Board Game");
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        getContentPane().setBackground(Color.CYAN);
	        
	        
	        //Show the frame
	        setVisible(true);
	        
		}




		@Override
	     public void paint(Graphics g) 
	     {
			super.paint(g);
			g.drawRect(75,75 ,((width)/2)+250, ((height)/2)+50);
	    	 for (int i=0 ; i<size;i++)
	    	 {
		    	 for (int j=0 ; j<size;j++)
		    	 {
		    		 //For each cells paint it on the frame
		    		 myCells[i][j] = new Board_Cells(i*((width)/(2*size)) +100, j*((height)/(2*size)) +100,width/(2*size), height/(2*size));
		    		 myCells[i][j].paint(g);
		    	 }
	    	 }
	     }

	
}
