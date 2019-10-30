package game_ressources;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.io.File;
import java.io.IOException;

class Graphical_Naval_Menu extends JFrame {

    Graphical_Naval_Menu() throws IOException {
        super();
        build();
    }

    private void build() throws IOException {
        setTitle("Naval battle game");
        setSize(500,175);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(buildContentPane());
    }

    private Container buildContentPane() throws IOException {

        //topPart
        JPanel topPart = new JPanel();

        JLabel title = new JLabel("Naval Battle Game");
        title.setFont(new Font("Courier", Font.BOLD,40));
        topPart.add(title);

        //centerPart
        JPanel centerPart = new JPanel();
        JButton butt1 = new JButton("Lancer une partie");
        centerPart.add(butt1);
        JButton butt2 = new JButton("Quitter");
        centerPart.add(butt2);

        //southPart
        JPanel southPart = new JPanel();
        JLabel credits = new JLabel("By Matthieu H, Nicolas F & Thomas M");
        credits.setFont(new Font("Courier", Font.PLAIN, 15));
        southPart.add(credits);

        //assembledPart
        JPanel cards = new JPanel(new BorderLayout());
        cards.add(topPart, BorderLayout.NORTH);
        cards.add(centerPart, BorderLayout.CENTER);
        cards.add(southPart, BorderLayout.SOUTH);

        return cards;

        /*
        JLabel background = new JLabel(new ImageIcon(ImageIO.read(new File("src/img/sea.jpg"))));
        panel.add(background);

        //add title in panel
        JLabel title = new JLabel("Naval Battle Game");
        title.setBorder(new EmptyBorder(20, 0, 0, 0));
        title.setFont(new Font("Courier", Font.BOLD,40));
        title.setHorizontalAlignment(JLabel.CENTER);
        title.setVerticalAlignment(JLabel.TOP);
        panel.add(title);
        //add buttons in panel
        JButton butt = new JButton("Lancer la partie");
        butt.setHorizontalAlignment(JLabel.CENTER);
        butt.setVerticalAlignment(JLabel.TOP);
        panel.add(butt);
        //add credits in panel
        JLabel credits = new JLabel("By Matthieu H, Nicolas F & Thomas M");
        credits.setBorder(new EmptyBorder(50, 0, 20, 0));
        credits.setFont(new Font("Courier", Font.PLAIN, 15));
        panel.add(credits);
        //panel return
        */
    }
}

        /*



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
         */