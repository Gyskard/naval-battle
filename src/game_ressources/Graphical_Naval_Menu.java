package game_ressources;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

class Graphical_Naval_Menu extends JFrame implements ActionListener {

    private JButton butt1;
    private JButton butt2;
    private JTextField textField;

    Graphical_Naval_Menu() {

        super();
        build();

    }

    private void build() {

        repaint();
        setTitle("Naval battle game");
        setSize(500,400);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(buildContentPane());

    }

    private Container buildContentPane() {

        JPanel topPart = new JPanel(); //topPart

        JLabel title = new JLabel("Naval Battle Game");
        title.setFont(new Font("Courier", Font.BOLD,40));
        topPart.add(title);

        JPanel firstCenterPart = new JPanel(); //firstCenterPart
        textField = new JTextField("Anonyme", 20);
        textField.addActionListener(this);

        firstCenterPart.add(textField);

        JPanel secondCenterPart = new JPanel();  //secondCenterPart
        butt1 = new JButton("Lancer une partie");
        butt1.addActionListener(this);
        secondCenterPart.add(butt1);
        butt2 = new JButton("Quitter");
        butt2.addActionListener(this);
        secondCenterPart.add(butt2);

        JPanel thirdCenterPart = new JPanel(); //thirdCenterPart
        String[][] topScore = new Score().getTopScore(3);
        String htmlPart1 = "<p style=\"text-align:center; text-decoration: underline;\">Top 3</p>";
        String htmlPart2 = "<p style=\"text-align:center; font-size:0.85em;\">" + topScore[0][0] + " - " + topScore[0][1] + "</p>";
        String htmlPart3 = "<p style=\"text-align:center; font-size:0.85em;\">" + topScore[1][0] + " - " + topScore[1][1] + "</p>";
        String htmlPart4 = "<p style=\"text-align:center; font-size:0.85em;\">" + topScore[2][0] + " - " + topScore[2][1] + "</p>";
        JLabel top = new JLabel("<html>" + htmlPart1 + "<br>" + htmlPart2 + "<br>"+ htmlPart3 + "<br>" + htmlPart4 + "</html>");
        top.setFont(new Font("Courier", Font.BOLD,20));
        thirdCenterPart.add(top);

        JPanel centerPart = new JPanel(); //centerPart
        centerPart.setLayout(new BoxLayout(centerPart, BoxLayout.Y_AXIS));
        centerPart.add(firstCenterPart);
        centerPart.add(secondCenterPart);
        centerPart.add(thirdCenterPart);

        JPanel southPart = new JPanel();  //southPart
        JLabel credits = new JLabel("By Matthieu H, Nicolas F & Thomas M");
        credits.setFont(new Font("Courier", Font.PLAIN, 15));
        southPart.add(credits);

        JPanel cards = new JPanel(new BorderLayout()); //assembledPart
        cards.add(topPart, BorderLayout.NORTH);
        cards.add(centerPart, BorderLayout.CENTER);
        cards.add(southPart, BorderLayout.SOUTH);

        return cards;

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        Object source=e.getSource();

        if(source==butt1) { //Start a game

            try {
                Game game = new Game(textField.getText());
            } catch (IOException ex) {
                ex.printStackTrace();
            }

    		dispose();

        }

        else if(source==butt2) { //Quit
        	dispose();
        	System.exit(0);
        }
    }
}