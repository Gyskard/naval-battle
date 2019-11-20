package game_ressources;

import javax.imageio.ImageIO;

import javax.swing.*;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import java.awt.Graphics2D;
public class Graphic_Naval_Board extends JFrame implements ActionListener{


	 private int size; 
	 private int width; 
	 private int height; 
	 private Board_Cells[][] myCells;
	 private Players myPlayer;
	 
	 private JLabel BackGround_Grid;
	  
	     public Graphic_Naval_Board(int size, int width, int height,Players myPlayer) throws HeadlessException {
			super();
			 System.out.println("New board");
			//Initiate 
			this.size = size;
			this.width = width;
			this.height = height;
			myCells = new Board_Cells[size][size];
			this.myPlayer=myPlayer;
			build();
	     }

	     private void build() 
	     {
	        setSize(width, height);
	        setTitle("Naval Board Game");
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        setContentPane(buildContentPanel());
	        setVisible(true);
	     }
	    
	     private JPanel buildContentPanel()
	     {
	    	List<Boat> myBoats = myPlayer.getMyBoats();
	    	List<JLabel> myImage = new ArrayList<JLabel>();
	    	BackGround_Grid =new JLabel();
	    	JPanel panel= new JPanel();

			//Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
			//int width = (int)(this.width*0.97);
			//int height = (int)(this.height*0.6);

			setSize(this.width,this.height);
			BackGround_Grid.setBounds(0,0, width-20, height-40);

	    	ImageIcon GridImg=SetImageSize("./img/oceangrid_starter_boat.png", BackGround_Grid);
	    	BackGround_Grid.setIcon(GridImg);

	    	initMyCells();
			
	    	int displayX=600,displayY=20;
	    	
	    	for (Boat B : myBoats)
	    	{
	    		B.setDirection(1);
	    		myImage.add(InitialDisplayImage(displayX,displayY,B));
	    		displayY+=50;
	    	}
	    	for(JLabel I : myImage)
	    	{	    		 
	    		 BackGround_Grid.add(I);
	    		 
	    	}

	       panel.add(BackGround_Grid);
	        
	        return  panel;
	        
		 }
	     ///To Test
	     //
	     public void DisplayBoatAtPosition(JLabel LabelBackGround,Boat myBoat,int posX,int posY)
	     {
	    	 
	    	 //LabelBackGround.add(DisplayImage(myBoat.getImg_path()));
	    	 
	    	 
	     }
	     //
	     public ImageIcon SetImageSize(String path,JLabel myLabeltoScale)
	     {
	    	 ImageIcon icon =new ImageIcon(path);
	    	 Image img=icon.getImage();
	    	 Image newImg = img.getScaledInstance(myLabeltoScale.getWidth(), myLabeltoScale.getHeight(), Image.SCALE_SMOOTH);
	    	 ImageIcon newImc=new ImageIcon(newImg);
	    	 
	    	 return newImc;
	     }
	     public JLabel InitialDisplayImage(int posX,int posY,Boat B) {  
	         JLabel label=new JLabel();
	         
	         String img_Path;
	         int Iwidth=B.getSize() *(BackGround_Grid.getWidth()/22);
	         int IHeight= BackGround_Grid.getHeight()/11;
			 img_Path=B.getImg_path_horizontal();

	         
	         
	         label.setBounds(posX,posY,Iwidth,IHeight);
	         label.setIcon(SetImageSize(img_Path,label ));
	         return label;
	     }  

	     public JLabel DisplayImage(int posX,int posY,Boat B) {  
	         JLabel label=new JLabel();
	         
	         String img_Path;
	         int positionx = myCells[posX][posY].get_posX();
	         int positiony = myCells[posX][posY].get_posY();
	         int Iwidth= myCells[posX][posY].get_width();
	         int IHeight= B.getSize() *myCells[posX][posY].get_height();
	         
	         if(B.getDirection()==0)
	         {
	       
	        	 img_Path=B.getImg_path_vertical();
               
	         }else
	         {
	         	Iwidth= B.getSize() *(BackGround_Grid.getWidth()/22);
	         	IHeight= BackGround_Grid.getHeight()/11;
				 img_Path=B.getImg_path_horizontal();

	         }
	         
	         label.setBounds(positionx,positiony,Iwidth,IHeight);
	         label.setIcon(SetImageSize(img_Path,label ));
	         return label;
	     }  
	     
	     
	     
		 private void initMyCells() {
			 System.out.println("Init cells");
			 for (int i=0 ; i<size;i++) {
				 for (int j=0 ; j<size;j++) {
					 myCells[i][j]= new Board_Cells(i, j, BackGround_Grid.getWidth()/22, BackGround_Grid.getHeight()/11,this);
					 BackGround_Grid.add(myCells[i][j]);
					 myCells[i][j].addActionListener(this);
				 }
			 }
			 
		 }


		 public Board_Cells[][] getMyCells() { return myCells; }
		 public Board_Cells getMyCell(int i, int j) { return myCells[i][j]; }

		// Place the boats randomly
		public void randomBoatPositioning() {
			Iterator<Boat> iter = myPlayer.getMyBoats().iterator();
			//Board_Cells[][] myCells = myPlayer.getGameBoard().getMyCells();

			// Iterator on each player's boats
			while (iter.hasNext()) {
				Boat boat = iter.next();
				int boatSize = boat.getSize();
				int posX, posY;
				int dirX, dirY;

				// Keep creating random numbers while there is no space available for the boat
				boolean spaceAvailable;
				do {
					boolean outOfBoard;
					// Keep creating random numbers until the boat fit in the board
					do{
						// Random position X and Y   = [0 to size-1]
						posX = (int) (Math.random() * (size));
						posY = (int) (Math.random() * (size));
						// Random direction X and Y   = [-1 to 1]
						dirX = (int) (Math.random() * 3) -1;
						if(dirX == 0) {
							dirY = (int) (Math.random() * 2);
							if (dirY == 0) {dirY = -1;}
						} else {dirY = 0;}

						// verify if the boat's size and the direction can fit in the board
						outOfBoard = (posX + boatSize * dirX > size) || (posX + boatSize * dirX < 0) || (posY + boatSize * dirY > size) || (posY + boatSize * dirY < 0);

					} while(outOfBoard);

					spaceAvailable = true;
					// Verify that a boat isn't already placed in the cells
					for(int i=0; i<boatSize; i++){
						if((myCells[posX + i * dirX][posY + i * dirY].getState())) {
							spaceAvailable = false;
							break;
						}
					}

				} while(!spaceAvailable);

				for(int i=0; i<boat.getSize(); i++){
					myCells[posX + i*dirX][posY + i*dirY].setState(true);
					myCells[posX + i*dirX][posY + i*dirY].setBoat(boat);
					
				}
			}
		}


		 public int getIntSize() { return size; }

		@Override
		public void actionPerformed(ActionEvent e) {
			
	        Object source=e.getSource();
	        if(source instanceof Board_Cells)
	        {
	        	Board_Cells myB= (Board_Cells)source;
		        System.out.println(myB.get_posX() + "-" + myB.get_posY());

	        }
				
			
		}


		

}
