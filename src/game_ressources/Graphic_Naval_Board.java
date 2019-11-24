package game_ressources;


import javax.imageio.ImageIO;
import javax.swing.*;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Graphic_Naval_Board extends JFrame implements ActionListener{

	 private int size; 
	 private int width; 
	 private int height; 
	 private Board_Cells[][] myCells;
	 private Players myPlayer;
	 private JLabel BackGround_Grid;
	 private JRadioButton vertical; 
	 private JRadioButton horizontal; 
	 private ButtonGroup  G1;
	 int InitialBoatToPlace;

	List<Integer> xTested = new ArrayList<Integer>();
	List<Integer> yTested = new ArrayList<Integer>();

	 public Graphic_Naval_Board(int width, int height, Players myPlayer) throws HeadlessException, IOException {
		super();
		size=10;
		this.width = width;
		this.height = height;
		myCells = new Board_Cells[size][size];
		this.myPlayer = myPlayer;
		InitialBoatToPlace = 0;
		build();
	 }


	 private void build() throws IOException {
		 if (myPlayer instanceof IA_Player) {
			 setTitle("Naval Board Game - IA");
		 }
		 else if (myPlayer instanceof Human_Player) {
			 setTitle("Naval Board Game - Joueur");
		 }
		setSize(width, height);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(buildContentPanel());
		 if (myPlayer instanceof IA_Player) {
			this.setEnabled(false);
			 this.setVisible(false);

		 }
		 else if (myPlayer instanceof Human_Player) {
			 this.setEnabled(true);
			 this.setVisible(true);
		 }

	 }

	 private JPanel buildContentPanel() throws IOException {
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

		if (myPlayer instanceof Human_Player) {
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
		}else
		{
			randomBoatPositioning();

			for (Boat B : myBoats)
			{

				myImage.add(IADisplayImage(B.getCoordXBase(),B.getCoordYBase(),B));


			}

			for(JLabel I : myImage)
			{
				BackGround_Grid.add(I);

			}
		}

		panel.add(BackGround_Grid);

		G1.add(vertical);
		G1.add(horizontal);


		return  panel;

	 }

	 public ImageIcon SetImageSize(String path, JLabel myLabeltoScale)
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

	 public JLabel IADisplayImage(int posX,int posY,Boat B) throws IOException {

		String img_Path;
		int Iwidth=B.getBoatSize() *(BackGround_Grid.getWidth()/22);
		int IHeight= BackGround_Grid.getHeight()/11;

		if(B.getDirection()==1)
		{
			img_Path=B.getImg_path_horizontal_destroyed();

			B.setBounds(posX,posY,Iwidth,IHeight);
			B.setIcon(SetImageSize(img_Path,B ));
		}else // On IA gameboard
		{

			 Iwidth=BackGround_Grid.getWidth()/22;
			 IHeight= B.getBoatSize() *(BackGround_Grid.getHeight()/11);
			try
			{
				BufferedImage bufferedImage = ImageIO.read(new File(B.getImg_path_vertical_destroyed()));
				Graphics2D g = (Graphics2D) bufferedImage.getGraphics();
				g.drawImage(bufferedImage, 0, 0, null);
				B.setIcon(new ImageIcon(bufferedImage));
				B.setLocation(posX, posY);
				B.setSize(Iwidth, IHeight);
				B.setIcon(SetImageSize(B.getImg_path_vertical_destroyed(), B));

			} catch (IOException  ex) {

				 ex.printStackTrace();

			 }

		}
		B.setVisible(false);
		B.setEnabled(false);

		return B;
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
	public Players getMyPlayer() {
		return myPlayer;
	}

	public void setMyPlayer(Players myPlayer) {
		this.myPlayer = myPlayer;
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
			generateIA_Boat_direction();
		}
	}

	public void generateIA_Boat_direction()
	{
		List<Boat> BoatTested = new ArrayList<Boat>();

		for(int i=0;i<size;i++)
		{
			for(int j=0;j<size;j++){
				if(myCells[i][j].getBoat()!=null && !BoatTested.contains(myCells[i][j].getBoat()))
				{
					Boat myBoat=myCells[i][j].getBoat();
					myCells[i][j].getBoat().setCoordXBase(myCells[i][j].get_posX());
					myCells[i][j].getBoat().setCoordYBase(myCells[i][j].get_posY());
					if(i+1<size)
					{
						if(myCells[i+1][j].getBoat()==myBoat)
						{
							myBoat.setDirection(1);

						}
					}
					if(j+1<size)
					{
						if(myCells[i][j+1].getBoat()==myBoat)
						{
							myBoat.setDirection(0);

						}
					}
					BoatTested.add(myBoat);
				}

			}
		}
	}

	// Place boats horizontally from the upper left corner from the taller to the smaller
	public void testBoatPositioning() {
		Iterator<Boat> iter = myPlayer.getMyBoats().iterator();

		for(int i=0; i<5; i++) {
		Boat boat = iter.next();
			for(int j=0; j<boat.getBoatSize(); j++) {
				myCells[j][i].setState(true);
				myCells[j][i].setBoat(boat);
			}
		}
	}

	public int getIntSize() { return size; }

	@Override
	public void actionPerformed(ActionEvent e) {

		Object source=e.getSource();

		if(source instanceof Board_Cells) {

			Board_Cells myB = (Board_Cells) source;

			if (myPlayer instanceof Human_Player) {
				if(InitialBoatToPlace==5)
				{
					InitialBoatToPlace++;
				}
				if (InitialBoatToPlace < 5) {

					Boat currentBoat;
					currentBoat = myPlayer.getMyBoats().get(InitialBoatToPlace);


					if (vertical.isSelected()) {

						if ((myB.getJ() + myPlayer.getMyBoats().get(InitialBoatToPlace).getBoatSize() - 1) < 10) {

							if (myB.getBoat() == null) {

								boolean boatPresence = false;

								for (int j = 1; j < currentBoat.getBoatSize(); j++) {

									if (myB.getMyBoard().getMyCell(myB.getI(), j + myB.getJ()).getBoat() != null) {

										boatPresence = true;
									}
								}

								if (!(boatPresence)) {


									myB.setBoat(myPlayer.getMyBoats().get(InitialBoatToPlace));
									myB.getBoat().setDirection(0);
									myB.getBoat().setCoordXBase(myB.get_posX());
									myB.getBoat().setCoordYBase(myB.get_posY());
									for (int j = 1; j < currentBoat.getBoatSize(); j++) {
										myB.getMyBoard().getMyCell(myB.getI(), j + myB.getJ()).setBoat(currentBoat);
									}

									int x = myB.getX();
									int y = myB.getY();
									int h = myB.get_height() * currentBoat.getBoatSize();
									int w = myB.get_width();

									try {

										BufferedImage bufferedImage = ImageIO.read(new File(currentBoat.getImg_path_vertical()));
										Graphics2D g = (Graphics2D) bufferedImage.getGraphics();
										g.drawImage(bufferedImage, 0, 0, null);
										currentBoat.setIcon(new ImageIcon(bufferedImage));
										currentBoat.setLocation(x, y);
										currentBoat.setSize(w, h);
										currentBoat.setIcon(SetImageSize(currentBoat.getImg_path_vertical(), currentBoat));



									} catch (IOException  ex) {

										ex.printStackTrace();

									}

									InitialBoatToPlace++;

								}
							}
						}
					} else {

						if ((myB.getI() + myPlayer.getMyBoats().get(InitialBoatToPlace).getBoatSize() - 1) < 10) {

							if (myB.getBoat() == null) {

								boolean boatPresence = false;

								for (int i = 1; i < currentBoat.getBoatSize(); i++) {
									if (myB.getMyBoard().getMyCell(i + myB.getI(), myB.getJ()).getBoat() != null) {
										boatPresence = true;
									}
								}

								if (!(boatPresence)) {


									myB.setBoat(myPlayer.getMyBoats().get(InitialBoatToPlace));
									myB.getBoat().setDirection(1);
									myB.getBoat().setCoordXBase(myB.get_posX());
									myB.getBoat().setCoordYBase(myB.get_posY());

									for (int i = 1; i < myB.getBoat().getBoatSize(); i++) {
										myB.getMyBoard().getMyCell(i + myB.getI(), myB.getJ()).setBoat(myPlayer.getMyBoats().get(InitialBoatToPlace));

									}

									myPlayer.getMyBoats().get(InitialBoatToPlace).setLocation(myB.get_posX(), myB.get_posY());
									InitialBoatToPlace++;

								}
							}
						}
					}

				}
				if(InitialBoatToPlace > 5) {
					vertical.setVisible(false);
					vertical.setEnabled(false);
					horizontal.setEnabled(false);
					horizontal.setVisible(false);

					this.setVisible(true);
					this.setEnabled(true);
					this.myPlayer.adversary.getGameBoard().setVisible(true);
					this.myPlayer.adversary.getGameBoard().setEnabled(true);

				}

			}
			else if (myPlayer instanceof IA_Player) {
				boolean finished=false;
				try {
					myB.destroy();
					TimeUnit.MILLISECONDS.sleep(100);
				} catch (InterruptedException ex) {
					ex.printStackTrace();
				}
				if(!isAnyoneAlive() && !finished)
				{
					finished=true;
					JOptionPane.showMessageDialog(null, "You WIN!!");
					if(myPlayer.adversary instanceof Human_Player)
					{
						Human_Player Winner=(Human_Player)myPlayer.adversary;
						System.out.println(Winner.getPseudo());
						Score score = new Score();
						try {
							System.out.println("enregistrement score");
							score.setScore(Winner.getPseudo(),100-Winner.getNumberOfMiss());
						} catch (IOException ex) {
							ex.printStackTrace();
						}

						myPlayer.adversary.getGameBoard().dispose();
						myPlayer.getGameBoard().dispose();
					}

				}
				IA_Player Ia_toplay=(IA_Player)myPlayer;
				Ia_toplay.tryToDestroy(myPlayer.adversary.getGameBoard(), xTested, yTested);
				try {
					TimeUnit.MILLISECONDS.sleep(100);
				} catch (InterruptedException ex) {
					ex.printStackTrace();
				}
				if(!isAnyoneAlive() && !finished)
				{
					JOptionPane.showMessageDialog(null, "You LOSE!!");
					myPlayer.adversary.getGameBoard().dispose();
					myPlayer.getGameBoard().dispose();
				}

			}


		}
	}
	private boolean isAnyoneAlive()
	{


		boolean Bplayer=false;
		boolean Badv=false;
		for(int i=0;i<5;i++) {
			if(myPlayer.getMyBoats().get(i).getHealthPoint()>0)
			{
				Bplayer=true;
			}
		}
		for(int i=0;i<5;i++) {
			if(myPlayer.adversary.getMyBoats().get(i).getHealthPoint()>0)
			{
				Badv= true;
			}
		}
		return (Badv && Bplayer);

	}

}
