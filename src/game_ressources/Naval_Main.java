package game_ressources;

import java.io.IOException;

import javax.swing.SwingUtilities;

public class Naval_Main{

	public static void main(String[] args) {
		
		SwingUtilities.invokeLater(() -> {
			Graphical_Naval_Menu Menu;
			try {
				Menu = new Graphical_Naval_Menu();
				Menu.setVisible(true);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
	}
}
