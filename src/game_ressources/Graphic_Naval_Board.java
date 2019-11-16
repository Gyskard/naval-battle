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
import java.util.ArrayList;
import java.util.List;

import java.awt.Graphics2D;
public class Graphic_Naval_Board extends JFrame implements ActionListener{


	 private int size; 
	 private int width; 
	 private int height; 
	 private Board_Cells myCells[][];
	 private Players myPlayer;
	 
	 private JLabel BackGround_Grid;
	  
	     public Graphic_Naval_Board(int size, int width, int height,Players myPlayer) throws HeadlessException {
			super();
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
	        //initMyCells();
	    	
			Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
			int width = (int)(this.width*0.99);
			int height = (int)(this.height*0.6);
			setSize(this.width,(int)(this.height*0.7));
			BackGround_Grid.setBounds(0,0,width,height);

	    	ImageIcon GridImg=SetImageSize("./img/oceangrid_starter_boat.png",BackGround_Grid);	    	
	    	BackGround_Grid.setIcon(GridImg);	
	    	
	    	initMyCells();
			
	    	for (Boat B : myBoats)
	    	{
	    		myImage.add(DisplayImage(B.getImg_path()));
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
	    	 
	    	 LabelBackGround.add(DisplayImage(myBoat.getImg_path()));
	    	 
	    	 
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
	     
	     public JLabel DisplayImage(String img) {  
	         JLabel label = new JLabel();  
	         
	         
	         
	         int Iwidth=(int)(BackGround_Grid.getWidth()/22);
	         int IHeight=(int)(5*BackGround_Grid.getHeight()/11);
	         int positionx=2*BackGround_Grid.getWidth()/22;
	         int positiony=2*BackGround_Grid.getHeight()/11;
	         
	         label.setBounds(positionx,positiony,Iwidth,IHeight);
	         label.setIcon(SetImageSize(img,label ));
	         return label;
	     }  
	     public JLabel DisplayImage(int posX,int posY,Boat B) {  
	         JLabel label=null;
	         
	         String img_Path;
	         int positionx = myCells[posX][posY].get_posX();
	         int positiony = myCells[posX][posY].get_posY();
	         int Iwidth=(int)myCells[posX][posY].get_width();
	         int IHeight=(int)myCells[posX][posY].get_height();
	         
	         if(B.getDirection()==0)
	         {
	       
	        	 img_Path=B.getImg_path();
               
	         }else
	         {
	        	 img_Path=B.getImg_path();
	        	 label=new JLabel();
	         }
	         
	         label.setBounds(positionx,positiony,Iwidth,IHeight);
	         label.setIcon(SetImageSize(B.getImg_path(),label ));
	         return label;
	     }  
	     
	     
	     
		 private void initMyCells() {
			 for (int i=0 ; i<size;i++)
			 {
				 for (int j=0 ; j<size;j++)
				 {
					 myCells[i][j]= new Board_Cells(i, j,(int)(BackGround_Grid.getWidth()/22) ,(int)(BackGround_Grid.getHeight()/11),this);
					 BackGround_Grid.add(myCells[i][j]);
					 myCells[i][j].addActionListener(this);
				 }
			 }
		 }


		 public Board_Cells[][] getMyCells() { return myCells; }
		 public Board_Cells getMyCell(int i, int j) { return myCells[i][j]; }

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
