package game_ressources;

import javax.swing.SwingUtilities;

public class Naval_Main{

	public static void main(String[] args) {
		
		SwingUtilities.invokeLater(() -> {

			Graphical_Naval_Menu Menu;
			Menu = new Graphical_Naval_Menu();
			Menu.setVisible(true);

		});
	}
}
