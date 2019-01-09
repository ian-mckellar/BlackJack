public class Card {
    String suit;
    int value;
    String face;

    /**
     * initialise a card with a suit(spade, heart, diamond, club) and a value (2 through 9)
     *
     * @param suit
     * @param value
     */
    Card(String suit, int value) {
        this.suit = suit;
        this.value = value;
    }

    /**
     * initialise a card with a suit(spade, heart, diamond, club) and a face(jack, queen, king)
     * all face cards have a value of 10
     *
     * @param suit
     * @param face
     */
    Card(String suit, String face) {
        this.value = 10;
        this.suit = suit;
        this.value = value;
    }

    /**
     * returns the suit of the card
     *
     * @return
     */
    String getSuit() {
        return suit;
    }

    /**
     * returns the point value of a card
     *
     * @return
     */
    int getValue() {
        return value;
    }

    /**
     * returns what face (jack, queen, king) a card has
     *
     * @return
     */
    String getFace() {
        return face;
    }
}
