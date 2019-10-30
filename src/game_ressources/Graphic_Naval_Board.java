package game_ressources;

import javax.swing.*;
import java.awt.*;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

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



	     public void boatPositioning(Players player) {
			 List<Boat> boatsList = player.getMyBoats();

			 Iterator<Boat> iter = boatsList.iterator();

			 boolean spaceAvailable = false;

			 while (iter.hasNext()) {
				 Boat boat = iter.next();
				 int boatSize = boat.getSize();

				 while(spaceAvailable = false){
					 int rndNumber1, rndNumber2, rndDirection, direction1, direction2;
					 boolean outOfBoard;

					 do{
						 // rndNumber = [0; size]
						 rndNumber1 = (int) (Math.random() * (size + 1));
						 rndNumber2 = (int) (Math.random() * (size + 1));
						 // rndDirection = [0; 3]
					 	 rndDirection = (int) (Math.random() * 4);
						 switch (rndDirection){
							 case 0:
								 direction1 = 1;
								 direction2 = 1;
								 break;
							 case 1:
								 direction1 = -1;
								 direction2 = 1;
								 break;
							 case 2:
								 direction1 = 1;
								 direction2 = -1;
								 break;
							 case 3:
								 direction1 = -1;
								 direction2 = -1;
								 break;
							 default:
								 direction1 = 1;
								 direction2 = 1;
								 break;
						 }

						 outOfBoard = false;
						 if((rndNumber1 + boatSize*direction1 > size) || (rndNumber1 + boatSize*direction1 < 0)
					  	 || (rndNumber2 + boatSize*direction2 > size) || (rndNumber2 + boatSize*direction2 < 0)){
							 outOfBoard = true;
						 }

					 } while(outOfBoard);


					 spaceAvailable = true;
					 for(int i=0; i<boatSize; i++){
						 if(myCells[rndNumber1 + i*direction1][rndNumber2 + i*direction2].getState())
						 {
							 spaceAvailable = false;
							 break;
						 }
					 }

					 if(spaceAvailable = true){
						 for(int i=0; i<boat.getSize(); i++){
							 myCells[rndNumber1 + i*direction1][rndNumber2 + i*direction2].setState(true);
						 }
					 }
				 }
			 }
		 }
}
