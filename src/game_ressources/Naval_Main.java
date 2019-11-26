package game_ressources;

import javax.swing.SwingUtilities;

/**
 * Classe principale du programme, lancer le menu du jeu.
 * @author FREMONDIERE Nicolas
 * @author HIRTH Matthieu
 * @author MARGUERITAT Thomas
 * @version 1.5.4
 */

public class Naval_Main {

	public static void main(String[] args) {
		
		SwingUtilities.invokeLater(() -> {

			Graphical_Naval_Menu Menu;
			Menu = new Graphical_Naval_Menu();
			Menu.setVisible(true);

		});
	}
}