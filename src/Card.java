package blackJack;

import javax.swing.*;
import java.awt.*;

public class Card extends JPanel {
	private static final long serialVersionUID = 1L;
	private String suit;
    private int value;
    private String face;
    private String imageName;
    private Image cardImage;
    
    /**
     * initialise a card with a suit and a value
     *
     * @param suit  - spade, heart, diamond, club
     * @param value - 2, 3, 4, 5, 6, 7, 8, 9
     */
    Card(int value, String suit, String imageName) {
        this.suit = suit;
        this.value = value;
        this.imageName = imageName;
        this.setPreferredSize(new Dimension(125,175));
        this.setOpaque(false);
        
        try 
        {
        	cardImage = Toolkit.getDefaultToolkit().getImage((Card.class.getResource(imageName)));
        	cardImage = cardImage.getScaledInstance(123,173, Image.SCALE_SMOOTH);
        }
		catch(SecurityException e) 
		{
			JOptionPane.showMessageDialog(this, "Could not find image: "+imageName, "Image error", JOptionPane.ERROR_MESSAGE);
		}
    }

    /**
     * initialise a card with a suit(spade, heart, diamond, club) and a face(jack, queen, king)
     * all face cards have a value of 10
     * <p>
     * TODO Ace card only have value of 10 so far.  This will need to be changed.
     *
     * @param suit - spade, heart, diamond, club
     * @param face - ace, jack, queen, kind
     */
    Card(String face, String suit, String imageName) {
        this.face = face;
        this.suit = suit;
        this.imageName = imageName;
        this.value = 10;
        this.setPreferredSize(new Dimension(125,175));
        this.setOpaque(false);
        
        if(face == "ace")
        	this.value = 11;
        
        try 
        {
        	cardImage = Toolkit.getDefaultToolkit().getImage((Card.class.getResource(imageName)));
        	cardImage = cardImage.getScaledInstance(123,173, Image.SCALE_SMOOTH);
        }
		catch(SecurityException e) 
		{
			JOptionPane.showMessageDialog(this, "Could not find image: "+imageName, "Image error", JOptionPane.ERROR_MESSAGE);
		}
    }

    @Override
    public void paintComponent(Graphics g) {
    	super.paintComponent(g);
    	Graphics2D g2 = (Graphics2D) g;
    	g2.setColor(Color.WHITE);
    	g2.fillRoundRect(0, 0, 125, 175, 10, 10);
    	g2.setColor(Color.BLACK);
    	g2.drawRoundRect(0, 0, 125, 175, 10, 10);
        g2.drawImage(cardImage, 1, 1, this);
    }

    /**
     * @return String representing suit of the card
     */
    String getSuit() {
        return suit;
    }

    /**
     * @return int representing value of the card
     */
    int getValue() {
        return value;
    }

    /**
     * @return String representing face of card
     */
    String getFace() {
        return face;
    }

    /**
     * @return String repreenting location of image in project
     */
    String getImageName() {
        return imageName;
    }

    @Override
    public String toString() {
        return String.format("Card{" +
                "suit = %-8s" +
                ", value = %-2d" +
                ", face = %-5s" +
                ", imageName = %10s", suit, value, face, imageName);
    }
}