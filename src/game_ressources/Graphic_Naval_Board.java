package game_ressources;

import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Graphic_Naval_Board extends JFrame {


	 private int size; 
	 private int width; 
	 private int height; 
	 private Board_Cells myCells[][];
	 private Players myPlayer;
	  
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
	    	JLabel BackGround_Grid =new JLabel();
	    	JPanel panel= new JPanel();
	        //initMyCells();
	    	
	    	BackGround_Grid.setIcon(new ImageIcon("./img/oceangrid.png"));
	        Dimension size = BackGround_Grid.getPreferredSize();
	        BackGround_Grid.setBounds(200, 100, size.width*2, size.height*2); 
	    	
	    	panel.add(BackGround_Grid,BorderLayout.WEST);
	    	for (Boat B : myBoats)
	    	{
	    		myImage.add(DisplayImage(B.getImg_path()));
	    	}
	    	for(JLabel I : myImage)
	    	{
	    		 panel.add(I,BorderLayout.EAST);
	    	}

	       
	        //pack();
	        
	        return  panel;
	        
	        
		 }
	     
	     
	     public JLabel DisplayImage(String img) {  


	    	 
	         JLabel label = new JLabel();  
	         label.setIcon(new ImageIcon(img));
	         Dimension size = label.getPreferredSize();
	         label.setBounds(100, 100, size.width/2, size.height/2); 
	         return label;
	     }  
	     
	     
		 private void initMyCells() {
			 for (int i=0 ; i<size;i++)
			 {
				 for (int j=0 ; j<size;j++)
				 {
					 myCells[i][j] = new Board_Cells(i*((width)/(2*size)) +100, j*((height)/(2*size)) +100,width/(2*size), height/(2*size));
					 myCells[i][j].setState(false);
				 }
			 }
		 }


		 public Board_Cells[][] getMyCells() { return myCells; }
		 public Board_Cells getMyCell(int i, int j) { return myCells[i][j]; }

		 public int getIntSize() { return size; }

		 /*
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
		    		 //myCells[i][j] = new Board_Cells(i*((width)/(2*size)) +100, j*((height)/(2*size)) +100,width/(2*size), height/(2*size));
		    		 myCells[i][j].paint(g);
		    	 }
	    	 }
	     }
		 
		*/

}
