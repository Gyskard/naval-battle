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

    Graphical_Naval_Menu() throws IOException {
        super();
        build();
    }

    private void build() throws IOException {
        repaint();

        setTitle("Naval battle game");
        setSize(500,400);
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
        textField = new JTextField("Anonyme", 20);
        textField.addActionListener(this);

        firstCenterPart.add(textField);

        //secondCenterPart
        JPanel secondCenterPart = new JPanel();
        butt1 = new JButton("Lancer une partie");
        butt1.addActionListener(this);
        secondCenterPart.add(butt1);
        butt2 = new JButton("Quitter");
        butt2.addActionListener(this);
        secondCenterPart.add(butt2);

        //thirdCenterPart
        JPanel thirdCenterPart = new JPanel();
        String[][] topScore = new Score().getTopScore(3);
        String htmlPart1 = "<p style=\"text-align:center; text-decoration: underline;\">Top 3</p>";
        String htmlPart2 = "<p style=\"text-align:center; font-size:0.85em;\">" + topScore[0][0] + " - " + topScore[0][1] + "</p>";
        String htmlPart3 = "<p style=\"text-align:center; font-size:0.85em;\">" + topScore[1][0] + " - " + topScore[1][1] + "</p>";
        String htmlPart4 = "<p style=\"text-align:center; font-size:0.85em;\">" + topScore[2][0] + " - " + topScore[2][1] + "</p>";
        JLabel top = new JLabel("<html>" + htmlPart1 + "<br>" + htmlPart2 + "<br>"+ htmlPart3 + "<br>" + htmlPart4 + "</html>");
        top.setFont(new Font("Courier", Font.BOLD,20));
        thirdCenterPart.add(top);

        //centerPart
        JPanel centerPart = new JPanel();
        centerPart.setLayout(new BoxLayout(centerPart, BoxLayout.Y_AXIS));
        centerPart.add(firstCenterPart);
        centerPart.add(secondCenterPart);
        centerPart.add(thirdCenterPart);

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
        if(source==butt1)
        {
        	
    		//Generate a 1000 x 1000 sized frame with 10 x 10 case in it
    		Human_Player ThePlayer = new  Human_Player(10, textField.getText());
    		//ThePlayer.GameBoard.repaint();
    		dispose();
    	   //repain call the function paint by default but it's more usable than paint
        }
        else if(source==butt2)
        {
        	dispose();
        	System.exit(0);
        }

    }
}