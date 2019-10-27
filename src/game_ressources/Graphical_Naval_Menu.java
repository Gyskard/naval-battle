package game_ressources;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class Graphical_Naval_Menu extends JFrame {

    public Graphical_Naval_Menu(int width, int height) throws HeadlessException {
        super();

        //Initiate
        setSize(width, height);
        setTitle("Naval Board Game");

        //Create and add title
        JLabel title = new JLabel("Naval Battle Game");
        title.setHorizontalAlignment(JLabel.CENTER);
        title.setVerticalAlignment(JLabel.TOP);
        title.setBorder(new EmptyBorder(20, 0, 0, 0));
        title.setFont(new Font("Courier", Font.BOLD,40));
        add(title);
        setVisible(true);

        //Create and add credits
        JLabel credits = new JLabel("By Matthieu H, Nicolas F & Thomas M");
        credits.setHorizontalAlignment(JLabel.CENTER);
        credits.setVerticalAlignment(JLabel.BOTTOM);
        credits.setBorder(new EmptyBorder(0, 0, 20, 0));
        credits.setFont(new Font("Courier", Font.PLAIN, 15));
        add(credits);
        setVisible(true);

        //Create and add pseudo input
        JTextField t  = new JTextField("Anonyme", 16);
        JLabel pseudoText = new JLabel("Pseudo");
        JPanel p = new JPanel();
        p.add(t);
        p.add(pseudoText);
        p.setBackground(Color.CYAN);
        p.setBorder(new EmptyBorder(80, 0, 0, 0));
        add(p);
        setVisible(true);

        //End
        getContentPane().setBackground(Color.CYAN);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

}
