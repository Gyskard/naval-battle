package game_ressources;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

class Graphical_Naval_Menu extends JFrame implements ActionListener {

    private JButton butt1;
    private JButton butt2;

    Graphical_Naval_Menu() throws IOException {
        super();
        build();
    }

    private void build() throws IOException {
        repaint();

        setTitle("Naval battle game");
        setSize(500,250);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(buildContentPane());
    }

    private Container buildContentPane() {

        //topPart
        JPanel topPart = new JPanel();

        JLabel title = new JLabel("Naval Battle Game");
        title.setFont(new Font("Courier", Font.BOLD,40));
        topPart.add(title);

        //firstCenterPart
        JPanel firstCenterPart = new JPanel();
        JTextField textField = new JTextField("Pseudo", 20);
        firstCenterPart.add(textField);

        //secondCenterPart
        JPanel secondCenterPart = new JPanel();
        butt1 = new JButton("Lancer une partie");
        butt1.addActionListener(this);
        secondCenterPart.add(butt1);
        butt2 = new JButton("Quitter");
        butt2.addActionListener(this);
        secondCenterPart.add(butt2);

        //centerPart
        JPanel centerPart = new JPanel();
        centerPart.setLayout(new BoxLayout(centerPart, BoxLayout.Y_AXIS));
        Border padding = BorderFactory.createEmptyBorder(20, 0, 20, 0);
        centerPart.setBorder(padding);
        centerPart.add(firstCenterPart);
        centerPart.add(secondCenterPart);

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

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        Object source=e.getSource();


    }
}