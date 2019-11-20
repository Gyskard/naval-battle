package game_ressources;


import javax.swing.*;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
	 private boolean isInitialDisplay;
	 private JLabel BackGround_Grid;
	 private JRadioButton vertical; 
	 private JRadioButton horizontal; 
	 private ButtonGroup  G1;
	 int InitialBoatToPlace;
     
	     public Graphic_Naval_Board(int size, int width, int height,Players myPlayer) throws HeadlessException {
			super();
			//Initiate 
			this.size = size;
			this.width = width;
			this.height = height;
			myCells = new Board_Cells[size][size];
			this.myPlayer=myPlayer;
			this.isInitialDisplay=true;
			InitialBoatToPlace=0;
			build();
	     }
	     public Graphic_Naval_Board(int size, int width, int height,Players myPlayer,boolean initialDisplay) throws HeadlessException {
			this(size,width,height,myPlayer);
			this.isInitialDisplay=initialDisplay;
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
	   	    vertical=new JRadioButton(); 
	   	    horizontal=new JRadioButton(); 
	        // Initialization of object of "ButtonGroup" class. 
	   	    G1 = new ButtonGroup(); 
	        
	    	BackGround_Grid =new JLabel();
	    	JPanel panel= new JPanel();

			setSize(this.width,this.height);
			BackGround_Grid.setBounds(0,0, width-20, height-40);

	    	ImageIcon GridImg=SetImageSize("./img/oceangrid_starter_boat.png", BackGround_Grid);
	    	BackGround_Grid.setIcon(GridImg);
	    	
	    	vertical.setText("Verticale");
	    	horizontal.setText("horizontale");
	    	vertical.setSelected(true);
	    	
	    	// Setting Bounds of "jRadioButton2". 
	    	vertical.setBounds(600, 350, 120, 50); 
	        
	     // Setting Bounds of "jRadioButton2". 
	    	horizontal.setBounds(600, 300, 120, 50); 

	    		

	    	initMyCells();
				    	
	    	
	    	for (Boat B : myBoats)
	    	{
	    		
	    		B.setDirection(1);
	    		myImage.add(InitialDisplayImage(B.getCoordXBase(),B.getCoordYBase(),B));
	    	}
	    	for(JLabel I : myImage)
	    	{	    		 
	    		 BackGround_Grid.add(I);
	    		 
	    	}
	    	BackGround_Grid.add(vertical);
	    	BackGround_Grid.add(horizontal);

	       panel.add(BackGround_Grid);
	        
	    	G1.add(vertical);
	    	G1.add(horizontal);

	    	
	        return  panel;
	        
		 }

	     public ImageIcon SetImageSize(String path,JLabel myLabeltoScale)
	     {
	    	 ImageIcon icon =new ImageIcon(path);
	    	 Image img=icon.getImage();
	    	 Image newImg = img.getScaledInstance(myLabeltoScale.getWidth(), myLabeltoScale.getHeight(), Image.SCALE_SMOOTH);
	    	 ImageIcon newImc=new ImageIcon(newImg);
	    	 
	    	 return newImc;
	     }
	     public JLabel InitialDisplayImage(int posX,int posY,Boat B) {  
	         
	         String img_Path;
	         int Iwidth=B.getBoatSize() *(BackGround_Grid.getWidth()/22);
	         int IHeight= BackGround_Grid.getHeight()/11;
			 img_Path=B.getImg_path_horizontal();

	         
	       
	         B.setBounds(posX,posY,Iwidth,IHeight);
	         B.setIcon(SetImageSize(img_Path,B ));
	         return B;
	     }  

	     public JLabel DisplayImage(int posX,int posY,Boat B) {  
	         JLabel label=new JLabel();
	         
	         String img_Path;
	         int positionx = myCells[posX][posY].get_posX();
	         int positiony = myCells[posX][posY].get_posY();
	         int Iwidth= myCells[posX][posY].get_width();
	         int IHeight= B.getBoatSize() *myCells[posX][posY].get_height();
	         
	         if(B.getDirection()==0)
	         {
	       
	        	 img_Path=B.getImg_path_vertical();
               
	         }else
	         {
	         	Iwidth= B.getBoatSize() *(BackGround_Grid.getWidth()/22);
	         	IHeight= BackGround_Grid.getHeight()/11;
				 img_Path=B.getImg_path_horizontal();

	         }
	         
	         label.setBounds(positionx,positiony,Iwidth,IHeight);
	         label.setIcon(SetImageSize(img_Path,label ));
	         return label;
	     }  
	     
	     
	     
		 private void initMyCells() {
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
				int boatSize = boat.getBoatSize();
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

				for(int i=0; i<boat.getBoatSize(); i++){
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
		        	
		        	if(isInitialDisplay)
		        	{
		        		if(vertical.isSelected())
		        		{
		        			if((myB.getJ()+myPlayer.getMyBoats().get(InitialBoatToPlace).getBoatSize()-1)<10 && (myB.getJ()-myPlayer.getMyBoats().get(InitialBoatToPlace).getBoatSize()-1) >0)
		        			{
		        				myB.setBoat(myPlayer.getMyBoats().get(InitialBoatToPlace));
				        		myB.getBoat().setDirection(1);
				        		
				        		for(int j=1;j<myB.getBoat().getBoatSize();j++)
		    		        	{
		    		        		myB.getMyBoard().getMyCell(myB.getI(),j+ myB.getJ()).setBoat(myPlayer.getMyBoats().get(InitialBoatToPlace));;
		    		        	}
		    		        	myPlayer.getMyBoats().get(InitialBoatToPlace).setLocation(myB.get_posX(),myB.get_posY());
		    		        	InitialBoatToPlace++;
		        			}
		        		}else
		        		{
		        			if((myB.getI()+myPlayer.getMyBoats().get(InitialBoatToPlace).getBoatSize()-1)<10 && (myB.getI()-myPlayer.getMyBoats().get(InitialBoatToPlace).getBoatSize()-1)>0)
		        			{
		        				myB.setBoat(myPlayer.getMyBoats().get(InitialBoatToPlace));
		        				myB.getBoat().setDirection(0);
		    		        	//this.BackGround_Grid.add(DisplayImage(myB.getI(),myB.getJ(), myB.getBoat()));
		    		        	for(int i=0;i<myB.getBoat().getBoatSize();i++)
		    		        	{
		    		        		myB.getMyBoard().getMyCell(i+myB.getI(),myB.getJ()).setBoat(myPlayer.getMyBoats().get(InitialBoatToPlace));;
		    		        	}
		    		        	myPlayer.getMyBoats().get(InitialBoatToPlace).setLocation(myB.get_posX(),myB.get_posY());

		    		        	InitialBoatToPlace++;
		    		        	
		    		        	
		        			}
		        		}
	        		}else
	        		{

	        		}
	        		if(InitialBoatToPlace==5)
	        		{
	        			isInitialDisplay=false;
	        		}
			        System.out.println(myB.getI()+myPlayer.getMyBoats().get(InitialBoatToPlace).getBoatSize()-1);

			        System.out.println(myB.getJ()+myPlayer.getMyBoats().get(InitialBoatToPlace).getBoatSize()-1);
	        	}else
	        	{
	        		
	        	}
			
		}

		
		

	    
		

}
