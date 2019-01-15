public class Player {
    /**
     * The player's name
     */
    private String name;

    /**
     * The number of cards in hand
     */
    private int numCards;

    /**
     * The cards in player's hand
     */
    private Card[] hand = new Card[10];

    /**
     * The Player constructor
     */
    public Player(String name) {
        this.name = name;
        this.emptyHand();
    }

    /**
     * This method resets the player's hand
     */
    public void emptyHand() {
        for (int i = 0; i < 10; i++) {
            this.hand[i] = null;
        }

        this.numCards = 0;
    }

    /**
     * This method adds a card to player's hand
     */
    public boolean addCardToHand(Card card) {
        if (this.numCards == 10) {
            System.err.printf("%s's hand have 10 cards, more cards cannot be added", this.name);
            System.exit(1);
        }

        this.hand[this.numCards] = card;
        this.numCards++;

        return (this.getPlayersHandTotal() <= 21);
    }

    /**
     * This method gets the sum of cards in player's hand.
     */
    public int getPlayersHandTotal() {
        int handSum = 0;
        int cardNum;
        int acesNum = 0;


        for (int i = 0; i < this.numCards; i++) {
            cardNum = this.hand[i].getValue(); // this method is from the card class
            if (cardNum == 1) { // Ace
                acesNum++;
                handSum += 11;
            } else if (cardNum >= 10) {
                handSum += 10;
            } else {
                handSum += cardNum;
            }
        }

        while (handSum > 21 && acesNum > 0) {
            handSum -= 10;
            acesNum--;
        }

        return handSum;
    }

    /**
     * This method prints the cards in player's hand.
     */
    public void cardOutput(boolean printCard) {
        System.out.printf("\n%s's cards in hand\n\n", this.name);
        for (int i = 0; i < this.numCards; i++) {
            if (!printCard && i == 0) {
                System.out.printf("\t[hidden]\n");
            } else {
                System.out.printf("\t%s\n\n", this.hand[i].toString());
            }
        }
    }

    public boolean splitPossible() {
        if (this.numCards == 2 && (this.hand[0].getValue() == this.hand[1].getValue())) {
            // this method is from the card class
            return true;
        } else {
            return false;
        }
    }
}
