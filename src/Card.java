import javax.swing.*;
import java.awt.*;

public class Card extends JPanel {
    private String suit;
    private int value;
    private String face;
    private String imageName;

    /**
     * initialise a card with a suit and a value
     *
     * @param suit  - spade, heart, diamond, club
     * @param value - 2, 3, 4, 5, 6, 7, 8, 9
     */
    Card(int value, String suit, String imageName) {
        JPanel jPanel = new JPanel();
        this.suit = suit;
        this.value = value;
        this.imageName = imageName;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawCard(g);
    }

    private void drawCard(Graphics g) {
        ImageIcon imageIcon = new ImageIcon();
        imageIcon.paintIcon(this, g, 25, 5);
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
